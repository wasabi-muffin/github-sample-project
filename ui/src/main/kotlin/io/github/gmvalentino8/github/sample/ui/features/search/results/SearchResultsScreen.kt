package io.github.gmvalentino8.github.sample.ui.features.search.results

import android.os.Parcelable
import androidx.annotation.StringRes
import androidx.compose.foundation.background
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
import io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract.SearchResultsEvent
import io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract.SearchResultsIntent
import io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract.SearchResultsViewState
import io.github.gmvalentino8.github.sample.ui.R
import io.github.gmvalentino8.github.sample.ui.components.appbar.BackIcon
import io.github.gmvalentino8.github.sample.ui.components.appbar.TitleAppBar
import io.github.gmvalentino8.github.sample.ui.components.error.ErrorFullscreen
import io.github.gmvalentino8.github.sample.ui.components.error.ErrorOkDialog
import io.github.gmvalentino8.github.sample.ui.components.paging.PagingColumn
import io.github.gmvalentino8.github.sample.ui.core.Contract
import io.github.gmvalentino8.github.sample.ui.core.handle
import io.github.gmvalentino8.github.sample.ui.core.render
import io.github.gmvalentino8.github.sample.ui.primitives.Gray
import io.github.gmvalentino8.github.sample.ui.utils.elevation
import io.github.gmvalentino8.github.sample.ui.utils.onScrolledToBottom

@Composable
fun <T : Parcelable> SearchResultsScreen(
    contract: Contract<SearchResultsIntent<T>, SearchResultsViewState<T>, SearchResultsEvent<T>>,
    navigator: SearchResultsNavigator<T>,
    @StringRes title: Int,
    resultItem: @Composable (item: T, onClick: (T) -> Unit) -> Unit
) {
    val (state, events, dispatch) = contract
    val scrollState = rememberLazyListState()
    scrollState.onScrolledToBottom(buffer = 3) { dispatch(SearchResultsIntent.ScrollToBottom()) }

    events?.handle(
        process = { dispatch(SearchResultsIntent.ProcessEvent(it)) }
    ) { event ->
        when (event) {
            is SearchResultsEvent.NavigateBack -> navigator.back()
            is SearchResultsEvent.NavigateDetails -> navigator.details(event.item)
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TitleAppBar(
            title = stringResource(id = title),
            elevation = scrollState.elevation(),
            navigationIcon = {
                BackIcon { dispatch(SearchResultsIntent.ClickBack()) }
            }
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            when (state) {
                is SearchResultsViewState.Initial -> Unit
                is SearchResultsViewState.Empty -> {
                    ErrorFullscreen(title = stringResource(R.string.common_empty_content))
                }
                is SearchResultsViewState.Loading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Gray.v200)
                    ) {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }
                }
                is SearchResultsViewState.Error -> {
                    ErrorFullscreen(error = state.error) { dispatch(SearchResultsIntent.ClickTryAgain()) }
                }
                is SearchResultsViewState.Stable -> {
                    SwipeRefresh(
                        state = rememberSwipeRefreshState(isRefreshing = state is SearchResultsViewState.Stable.RefreshLoading),
                        onRefresh = { dispatch(SearchResultsIntent.PullToRefresh()) },
                        modifier = Modifier.fillMaxSize()
                    ) {
                        PagingColumn<T, SearchResultsViewState.Stable.PageLoading<T>, SearchResultsViewState.Stable.PageError<T>>(
                            items = state.results,
                            viewState = state,
                            state = scrollState,
                            onClickRetry = { dispatch(SearchResultsIntent.ClickErrorRetry()) },
                            modifier = Modifier.fillMaxSize()
                        ) { index, item ->
                            resultItem(item) {
                                dispatch(SearchResultsIntent.ClickItem(item = item))
                            }
                            if (index != state.results.lastIndex) {
                                Divider()
                            }
                        }
                    }
                    state.render<SearchResultsViewState.Stable.RefreshError<T>> {
                        ErrorOkDialog(error = it.error) {
                            dispatch(SearchResultsIntent.ClickErrorOk())
                        }
                    }
                }
            }
        }
    }
}
