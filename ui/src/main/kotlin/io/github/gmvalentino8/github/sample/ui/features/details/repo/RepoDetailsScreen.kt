package io.github.gmvalentino8.github.sample.ui.features.details.repo

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
import io.github.gmvalentino8.github.sample.domain.entities.RepositoryDetails
import io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract.RepositoryDetailsEvent
import io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract.RepositoryDetailsIntent
import io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract.RepositoryDetailsViewState
import io.github.gmvalentino8.github.sample.ui.R
import io.github.gmvalentino8.github.sample.ui.components.appbar.BackIcon
import io.github.gmvalentino8.github.sample.ui.components.appbar.TitleAppBar
import io.github.gmvalentino8.github.sample.ui.components.error.ErrorFullscreen
import io.github.gmvalentino8.github.sample.ui.components.error.ErrorOkDialog
import io.github.gmvalentino8.github.sample.ui.components.repo.RepositoryDetailsElementItem
import io.github.gmvalentino8.github.sample.ui.components.repo.RepositoryDetailsHeader
import io.github.gmvalentino8.github.sample.ui.core.Contract
import io.github.gmvalentino8.github.sample.ui.core.handle
import io.github.gmvalentino8.github.sample.ui.core.render
import io.github.gmvalentino8.github.sample.ui.primitives.Gray
import io.github.gmvalentino8.github.sample.ui.utils.elevation

@Composable
fun RepoDetailsScreen(
    contract: Contract<RepositoryDetailsIntent, RepositoryDetailsViewState, RepositoryDetailsEvent>,
    navigator: RepoDetailsNavigator
) {
    val (state, events, dispatch) = contract
    val scrollState = rememberScrollState()

    events?.handle(
        process = { dispatch(RepositoryDetailsIntent.ProcessEvent(it)) }
    ) { event ->
        when (event) {
            is RepositoryDetailsEvent.NavigateBack -> navigator.back()
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TitleAppBar(
            title = stringResource(id = R.string.common_repositories),
            elevation = scrollState.elevation(),
            navigationIcon = {
                BackIcon { dispatch(RepositoryDetailsIntent.ClickBack) }
            }
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            when (state) {
                is RepositoryDetailsViewState.Initial -> Unit
                is RepositoryDetailsViewState.Loading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Gray.v200)
                    ) {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }
                }
                is RepositoryDetailsViewState.Error -> {
                    ErrorFullscreen(error = state.error) { dispatch(RepositoryDetailsIntent.ClickTryAgain) }
                }
                is RepositoryDetailsViewState.Stable -> {
                    SwipeRefresh(
                        state = rememberSwipeRefreshState(isRefreshing = state is RepositoryDetailsViewState.Stable.RefreshLoading),
                        onRefresh = { dispatch(RepositoryDetailsIntent.PullToRefresh) },
                    ) {
                        Column(
                            modifier = Modifier
                                .verticalScroll(scrollState)
                                .fillMaxSize()
                        ) {
                            RepositoryDetailsHeader(repository = state.details.repository)
                            Divider()
                            RepositoryDetailsElementItem(repoDetails = state.details, element = RepositoryDetails.Element.Issues)
                            RepositoryDetailsElementItem(repoDetails = state.details, element = RepositoryDetails.Element.PullRequests)
                            RepositoryDetailsElementItem(repoDetails = state.details, element = RepositoryDetails.Element.Releases)
                            RepositoryDetailsElementItem(repoDetails = state.details, element = RepositoryDetails.Element.Contributors)
                            RepositoryDetailsElementItem(repoDetails = state.details, element = RepositoryDetails.Element.Watchers)
                            RepositoryDetailsElementItem(repoDetails = state.details, element = RepositoryDetails.Element.License)
                        }
                    }
                    state.render<RepositoryDetailsViewState.Stable.RefreshError> {
                        ErrorOkDialog(error = it.error) {
                            dispatch(RepositoryDetailsIntent.ClickErrorOk)
                        }
                    }
                }
            }
        }
    }
}
