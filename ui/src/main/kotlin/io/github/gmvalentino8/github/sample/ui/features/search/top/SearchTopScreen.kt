package io.github.gmvalentino8.github.sample.ui.features.search.top

import android.os.Parcelable
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.dp
import io.github.gmvalentino8.github.sample.domain.entities.Pageable
import io.github.gmvalentino8.github.sample.domain.entities.SearchType
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopEvent
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopIntent
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopViewState
import io.github.gmvalentino8.github.sample.ui.R
import io.github.gmvalentino8.github.sample.ui.components.appbar.AppBarSearch
import io.github.gmvalentino8.github.sample.ui.components.error.ErrorFullscreen
import io.github.gmvalentino8.github.sample.ui.components.list.CommonListSectionHeader
import io.github.gmvalentino8.github.sample.ui.components.search.RecentSearchHeader
import io.github.gmvalentino8.github.sample.ui.components.search.RecentSearchItem
import io.github.gmvalentino8.github.sample.ui.components.search.SearchIssueResultItem
import io.github.gmvalentino8.github.sample.ui.components.search.SearchOrganizationResultItem
import io.github.gmvalentino8.github.sample.ui.components.search.SearchPullRequestResultItem
import io.github.gmvalentino8.github.sample.ui.components.search.SearchRepositoryResultItem
import io.github.gmvalentino8.github.sample.ui.components.search.SearchSeeAllFooter
import io.github.gmvalentino8.github.sample.ui.components.search.SearchTypeItem
import io.github.gmvalentino8.github.sample.ui.components.search.SearchUserResultItem
import io.github.gmvalentino8.github.sample.ui.core.Contract
import io.github.gmvalentino8.github.sample.ui.core.handle
import io.github.gmvalentino8.github.sample.ui.primitives.Github
import io.github.gmvalentino8.github.sample.ui.primitives.Gray
import io.github.gmvalentino8.github.sample.ui.utils.notImplemented
import io.github.gmvalentino8.github.sample.ui.utils.toShortedString

@Composable
fun SearchTopScreen(contract: Contract<SearchTopIntent, SearchTopViewState, SearchTopEvent>, navigator: SearchTopNavigator) {
    val (state, events, dispatch) = contract
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current

    events?.handle(
        process = { dispatch(SearchTopIntent.ProcessEvent(it)) }
    ) { event ->
        when (event) {
            is SearchTopEvent.NavigateBack -> navigator.back()
            is SearchTopEvent.NavigateRepositoryDetails -> navigator.repositoryDetails(event.repository)
            is SearchTopEvent.NavigateSearch -> {
                focusManager.clearFocus(force = true)
                when (event.type) {
                    SearchType.Repository -> navigator.repositoryResults(event.searchText)
                    SearchType.Issues -> navigator.issueResults(event.searchText)
                    SearchType.PullRequests -> navigator.pullRequestResults(event.searchText)
                    SearchType.People -> navigator.userResults(event.searchText)
                    SearchType.Organization -> navigator.organizationResults(event.searchText)
                    SearchType.JumpTo -> notImplemented(context)
                }
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
                    focusManager.clearFocus()
                },
            )
        }
        when (state) {
            is SearchTopViewState.Initial -> Unit
            is SearchTopViewState.Stable.EmptySearch -> {
                if (state.recentSearches.isNotEmpty()) {
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
                                    focusManager.moveFocus(FocusDirection.Next)
                                }
                            )
                        }
                    }
                } else {
                    ErrorFullscreen(
                        title = stringResource(R.string.search_top_empty_title),
                        description = stringResource(R.string.search_top_empty_description)
                    )
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
                        onClickSeeAll = { dispatch(SearchTopIntent.ClickSeeAll(SearchType.Repository)) }
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
                ErrorFullscreen(state.error)
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
        result.items.forEach { item ->
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
