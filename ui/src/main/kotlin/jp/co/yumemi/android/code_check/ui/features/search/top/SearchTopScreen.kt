package jp.co.yumemi.android.code_check.ui.features.search.top

import android.os.Parcelable
import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.dp
import jp.co.yumemi.android.code_check.domain.core.Pageable
import jp.co.yumemi.android.code_check.domain.entities.SearchType
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopEvent
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopIntent
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopViewState
import jp.co.yumemi.android.code_check.ui.R
import jp.co.yumemi.android.code_check.ui.components.appbar.AppBarSearch
import jp.co.yumemi.android.code_check.ui.components.error.ErrorFullscreen
import jp.co.yumemi.android.code_check.ui.components.list.CommonListSectionHeader
import jp.co.yumemi.android.code_check.ui.components.search.RecentSearchHeader
import jp.co.yumemi.android.code_check.ui.components.search.RecentSearchItem
import jp.co.yumemi.android.code_check.ui.components.search.SearchIssueResultItem
import jp.co.yumemi.android.code_check.ui.components.search.SearchOrganizationResultItem
import jp.co.yumemi.android.code_check.ui.components.search.SearchPullRequestResultItem
import jp.co.yumemi.android.code_check.ui.components.search.SearchRepositoryResultItem
import jp.co.yumemi.android.code_check.ui.components.search.SearchSeeAllFooter
import jp.co.yumemi.android.code_check.ui.components.search.SearchTypeItem
import jp.co.yumemi.android.code_check.ui.components.search.SearchUserResultItem
import jp.co.yumemi.android.code_check.ui.core.Contract
import jp.co.yumemi.android.code_check.ui.core.handle
import jp.co.yumemi.android.code_check.ui.primitives.Github
import jp.co.yumemi.android.code_check.ui.primitives.Gray
import jp.co.yumemi.android.code_check.ui.utils.toShortedString

@ExperimentalComposeUiApi
@Composable
fun SearchTopScreen(contract: Contract<SearchTopIntent, SearchTopViewState, SearchTopEvent>, navigator: SearchTopNavigator) {
    val (state, events, dispatch) = contract
    val keyboardController = LocalSoftwareKeyboardController.current

    events?.handle(
        process = { dispatch(SearchTopIntent.ProcessEvent(it)) }
    ) { event ->
        when (event) {
            is SearchTopEvent.NavigateBack -> navigator.back()
            is SearchTopEvent.NavigateRepositoryDetails -> navigator.repositoryDetails(event.repository)
            is SearchTopEvent.NavigateSearch -> when (event.type) {
                SearchType.Repo -> navigator.repositoryResults(event.searchText)
                SearchType.Issues -> navigator.issueResults(event.searchText)
                SearchType.PullRequests -> navigator.pullRequestResults(event.searchText)
                SearchType.People -> navigator.userResults(event.searchText)
                SearchType.Organization -> navigator.organizationResults(event.searchText)
                SearchType.JumpTo -> Log.d("NavigateSearch", "JumpTo ${event.searchText}") // TODO: Add Screen
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray.v200)
    ) {
        if (state is SearchTopViewState.Stable) {
            AppBarSearch(
                placeholder = "Search GitHub",
                searchText = state.searchText,
                onClickBack = { navigator.back() },
                onClickClear = { dispatch(SearchTopIntent.ClickClearSearchText) },
                onSearchTextChanged = { dispatch(SearchTopIntent.InputSearchText(it)) },
                onClickImeSearch = {
                    dispatch(SearchTopIntent.ClickSearch)
                    keyboardController?.hide()
                },
            )
        }
        when (state) {
            is SearchTopViewState.Initial -> Unit
            is SearchTopViewState.Stable.EmptySearch -> {
                LazyColumn(
                    modifier = Modifier.background(Github.White),
                ) {
                    itemsIndexed(state.recentSearches) { index, item ->
                        if (index == 0) {
                            RecentSearchHeader(
                                onClickClear = { dispatch(SearchTopIntent.ClickClearRecentSearches) }
                            )
                        }
                        RecentSearchItem(
                            searchText = item.searchText,
                            modifier = Modifier.clickable {
                                dispatch(SearchTopIntent.ClickRecentSearchItem(item))
                                keyboardController?.show()
                            }
                        )
                    }
                }
            }
            is SearchTopViewState.Stable.NonEmptySearch -> {
                Column(
                    modifier = Modifier.background(Github.White),
                ) {
                    SearchType.values().forEach { searchType ->
                        SearchTypeItem(
                            searchText = state.searchText,
                            searchType = searchType,
                            modifier = Modifier.clickable { dispatch(SearchTopIntent.ClickItem(searchType)) }
                        )
                    }
                }
            }
            is SearchTopViewState.Stable.Search.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Gray.v200)
                ) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
            is SearchTopViewState.Stable.Search.Success -> {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .fillMaxSize()
                        .background(Github.White)
                ) {
                    SearchResultGroup(
                        result = state.searchResults.repositories,
                        title = R.string.common_repositories,
                        onClickSeeAll = { dispatch(SearchTopIntent.ClickSeeAll(SearchType.Repo)) }
                    ) {
                        SearchRepositoryResultItem(
                            repository = it,
                            modifier = Modifier.clickable { dispatch(SearchTopIntent.ClickRepositoryResult(it)) }
                        )
                    }
                    Divider()
                    SearchResultGroup(
                        result = state.searchResults.issues,
                        title = R.string.common_issues,
                        onClickSeeAll = { dispatch(SearchTopIntent.ClickSeeAll(SearchType.Issues)) },
                        hasDividers = true,
                    ) {
                        SearchIssueResultItem(issue = it)
                    }
                    Divider()
                    SearchResultGroup(
                        result = state.searchResults.pullRequests,
                        title = R.string.common_pull_requests,
                        onClickSeeAll = { dispatch(SearchTopIntent.ClickSeeAll(SearchType.PullRequests)) },
                        hasDividers = true,
                    ) {
                        SearchPullRequestResultItem(pullRequest = it)
                    }
                    Divider()
                    SearchResultGroup(
                        result = state.searchResults.people,
                        title = R.string.common_people,
                        onClickSeeAll = { dispatch(SearchTopIntent.ClickSeeAll(SearchType.People)) }
                    ) {
                        SearchUserResultItem(user = it)
                    }
                    Divider()
                    SearchResultGroup(
                        result = state.searchResults.organizations,
                        title = R.string.common_organizations,
                        onClickSeeAll = { dispatch(SearchTopIntent.ClickSeeAll(SearchType.Organization)) }
                    ) {
                        SearchOrganizationResultItem(organization = it)
                    }
                }
            }
            is SearchTopViewState.Stable.Search.Error -> {
                ErrorFullscreen(title = stringResource(R.string.common_empty_content))
            }
        }
    }
}

@Composable
private fun <T : Parcelable> SearchResultGroup(
    result: Pageable<T>,
    @StringRes title: Int,
    onClickSeeAll: () -> Unit,
    hasDividers: Boolean = false,
    content: @Composable (T) -> Unit
) {
    if (result.items.isNotEmpty()) {
        CommonListSectionHeader(title = stringResource(id = title))
        // TODO: Fix API query param name
        result.items.take(3).forEach { item ->
            content(item)
            if (hasDividers) Divider()
        }
        SearchSeeAllFooter(
            title = stringResource(
                id = R.string.search_top_see_more,
                result.totalCount.toShortedString(),
                stringResource(id = title).toLowerCase(Locale.current)
            ),
            modifier = Modifier
                .clickable(onClick = onClickSeeAll)
                .padding(vertical = 12.dp)
        )
    }
}
