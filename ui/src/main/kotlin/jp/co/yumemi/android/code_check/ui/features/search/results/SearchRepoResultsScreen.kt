package jp.co.yumemi.android.code_check.ui.features.search.results

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsEvent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsIntent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsViewState
import jp.co.yumemi.android.code_check.ui.R
import jp.co.yumemi.android.code_check.ui.components.appbar.BackIcon
import jp.co.yumemi.android.code_check.ui.components.appbar.TitleAppBar
import jp.co.yumemi.android.code_check.ui.components.error.ErrorFullscreen
import jp.co.yumemi.android.code_check.ui.components.error.ErrorOkDialog
import jp.co.yumemi.android.code_check.ui.components.error.description
import jp.co.yumemi.android.code_check.ui.components.error.title
import jp.co.yumemi.android.code_check.ui.components.paging.PagingColumn
import jp.co.yumemi.android.code_check.ui.components.search.SearchRepoResultItem
import jp.co.yumemi.android.code_check.ui.core.Contract
import jp.co.yumemi.android.code_check.ui.utils.elevation
import jp.co.yumemi.android.code_check.ui.core.handle
import jp.co.yumemi.android.code_check.ui.utils.onScrolledToBottom
import jp.co.yumemi.android.code_check.ui.core.render
import jp.co.yumemi.android.code_check.ui.primitives.Gray

@Composable
fun SearchRepoResultsScreen(
    contract: Contract<SearchRepoResultsIntent, SearchRepoResultsViewState, SearchRepoResultsEvent>,
    navigator: SearchRepoResultsNavigator
) {
    val (state, events, dispatch) = contract
    val scrollState = rememberLazyListState()
    scrollState.onScrolledToBottom(buffer = 3) { dispatch(SearchRepoResultsIntent.ScrollToBottom) }

    events?.handle(
        process = { dispatch(SearchRepoResultsIntent.ProcessEvent(it)) }
    ) { event ->
        when (event) {
            is SearchRepoResultsEvent.NavigateBack -> Log.d("SearchRepoResults", "NavigateBack") // TODO: Add Navigation
            is SearchRepoResultsEvent.NavigateDetails -> Log.d("SearchRepoResults", "NavigateDetails") // TODO: Add Navigation
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TitleAppBar(
            title = stringResource(id = R.string.common_repositories),
            elevation = scrollState.elevation,
            navigationIcon = {
                BackIcon { dispatch(SearchRepoResultsIntent.ClickBack) }
            }
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            when (state) {
                is SearchRepoResultsViewState.Initial -> Unit
                is SearchRepoResultsViewState.Empty -> {
                    ErrorFullscreen(title = stringResource(R.string.common_empty_content))
                }
                is SearchRepoResultsViewState.Loading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Gray.v200)
                    ) {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }
                }
                is SearchRepoResultsViewState.Error -> {
                    ErrorFullscreen(title = stringResource(id = state.error.title())) { dispatch(SearchRepoResultsIntent.ClickTryAgain) }
                }
                is SearchRepoResultsViewState.Stable -> {
                    SwipeRefresh(
                        state = rememberSwipeRefreshState(isRefreshing = state is SearchRepoResultsViewState.Stable.RefreshLoading),
                        onRefresh = { dispatch(SearchRepoResultsIntent.PullToRefresh) },
                    ) {
                        PagingColumn<Repository, SearchRepoResultsViewState.Stable.PageLoading, SearchRepoResultsViewState.Stable.PageError>(
                            items = state.results,
                            viewState = state,
                            state = scrollState,
                            onClickRetry = { dispatch(SearchRepoResultsIntent.ClickErrorRetry) },
                        ) { index, item ->
                            SearchRepoResultItem(
                                repository = item,
                                modifier = Modifier.clickable { dispatch(SearchRepoResultsIntent.ClickItem(item = item)) }
                            )
                            if (index != state.results.lastIndex) {
                                Divider()
                            }
                        }
                    }
                    state.render<SearchRepoResultsViewState.Stable.RefreshError> {
                        ErrorOkDialog(title = stringResource(id = it.error.title()), description = stringResource(id = it.error.description())) {
                            dispatch(SearchRepoResultsIntent.ClickErrorOk)
                        }
                    }
                }
            }
        }
    }
}
