package jp.co.yumemi.android.code_check.ui.features.details.repo

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import jp.co.yumemi.android.code_check.domain.entities.RepositoryDetails
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsEvent
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsIntent
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsViewState
import jp.co.yumemi.android.code_check.ui.R
import jp.co.yumemi.android.code_check.ui.components.appbar.BackIcon
import jp.co.yumemi.android.code_check.ui.components.appbar.TitleAppBar
import jp.co.yumemi.android.code_check.ui.components.error.ErrorFullscreen
import jp.co.yumemi.android.code_check.ui.components.error.ErrorOkDialog
import jp.co.yumemi.android.code_check.ui.components.error.description
import jp.co.yumemi.android.code_check.ui.components.error.title
import jp.co.yumemi.android.code_check.ui.components.repo.RepoDetailsElementItem
import jp.co.yumemi.android.code_check.ui.components.repo.RepoDetailsHeader
import jp.co.yumemi.android.code_check.ui.core.Contract
import jp.co.yumemi.android.code_check.ui.core.handle
import jp.co.yumemi.android.code_check.ui.core.render
import jp.co.yumemi.android.code_check.ui.primitives.Gray
import jp.co.yumemi.android.code_check.ui.utils.elevation

@Composable
fun RepoDetailsScreen(
    contract: Contract<RepoDetailsIntent, RepoDetailsViewState, RepoDetailsEvent>,
    navigator: RepoDetailsNavigator
) {
    val (state, events, dispatch) = contract
    val scrollState = rememberScrollState()

    events?.handle(
        process = { dispatch(RepoDetailsIntent.ProcessEvent(it)) }
    ) { event ->
        when (event) {
            is RepoDetailsEvent.NavigateBack -> Log.d("RepoDetails", "NavigateBack") // TODO: Add Navigation
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TitleAppBar(
            title = stringResource(id = R.string.common_repositories),
            elevation = scrollState.elevation,
            navigationIcon = {
                BackIcon { dispatch(RepoDetailsIntent.ClickBack) }
            }
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            when (state) {
                is RepoDetailsViewState.Initial -> Unit
                is RepoDetailsViewState.Loading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Gray.v200)
                    ) {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }
                }
                is RepoDetailsViewState.Error -> {
                    ErrorFullscreen(title = stringResource(id = state.error.title())) { dispatch(RepoDetailsIntent.ClickTryAgain) }
                }
                is RepoDetailsViewState.Stable -> {
                    SwipeRefresh(
                        state = rememberSwipeRefreshState(isRefreshing = state is RepoDetailsViewState.Stable.RefreshLoading),
                        onRefresh = { dispatch(RepoDetailsIntent.PullToRefresh) },
                    ) {
                        Column(
                            modifier = Modifier
                                .verticalScroll(scrollState)
                                .fillMaxSize()
                        ) {
                            RepoDetailsHeader(repository = state.details.repository)
                            Divider()
                            RepoDetailsElementItem(repoDetails = state.details, element = RepositoryDetails.Element.Issues)
                            // RepoDetailsElementItem(repoDetails = state.details, element = RepositoryDetails.Element.PullRequests) // TODO: Add pull requests
                            RepoDetailsElementItem(repoDetails = state.details, element = RepositoryDetails.Element.Releases)
                            RepoDetailsElementItem(repoDetails = state.details, element = RepositoryDetails.Element.Contributors)
                            RepoDetailsElementItem(repoDetails = state.details, element = RepositoryDetails.Element.Watchers)
                            RepoDetailsElementItem(repoDetails = state.details, element = RepositoryDetails.Element.License)
                        }
                    }
                    state.render<RepoDetailsViewState.Stable.RefreshError> {
                        ErrorOkDialog(title = stringResource(id = it.error.title()), description = stringResource(id = it.error.description())) {
                            dispatch(RepoDetailsIntent.ClickErrorOk)
                        }
                    }
                }
            }
        }
    }
}
