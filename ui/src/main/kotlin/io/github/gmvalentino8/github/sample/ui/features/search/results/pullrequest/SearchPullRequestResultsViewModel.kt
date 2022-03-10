package io.github.gmvalentino8.github.sample.ui.features.search.results.pullrequest

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.github.gmvalentino8.github.sample.domain.entities.PullRequest
import io.github.gmvalentino8.github.sample.presentation.core.components.Store
import io.github.gmvalentino8.github.sample.presentation.core.contract.State
import io.github.gmvalentino8.github.sample.presentation.core.factory.StoreFactory
import io.github.gmvalentino8.github.sample.presentation.core.middleware.StateSaverMiddleware
import io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract.SearchResultsAction
import io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract.SearchResultsEvent
import io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract.SearchResultsIntent
import io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract.SearchResultsResult
import io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract.SearchResultsViewState
import io.github.gmvalentino8.github.sample.ui.core.StoreViewModel
import io.github.gmvalentino8.github.sample.ui.core.getState
import io.github.gmvalentino8.github.sample.ui.core.onInit
import io.github.gmvalentino8.github.sample.ui.core.saveState

class SearchPullRequestResultsViewModel @AssistedInject constructor(
    storeFactory: StoreFactory<SearchResultsIntent<PullRequest>,
        SearchResultsAction<PullRequest>,
        SearchResultsResult<PullRequest>,
        SearchResultsViewState<PullRequest>,
        SearchResultsEvent<PullRequest>>,
    @Assisted stateHandle: SavedStateHandle,
    @Assisted val searchText: String,
) : StoreViewModel<SearchResultsIntent<PullRequest>,
    SearchResultsAction<PullRequest>,
    SearchResultsResult<PullRequest>,
    SearchResultsViewState<PullRequest>,
    SearchResultsEvent<PullRequest>>(storeFactory) {
    override val store: Store<SearchResultsIntent<PullRequest>, SearchResultsViewState<PullRequest>, SearchResultsEvent<PullRequest>> = storeFactory.create(
        stateHandle.getState() ?: State(SearchResultsViewState.Initial(searchText)),
        middlewares = listOf(
            StateSaverMiddleware<SearchResultsViewState<PullRequest>, SearchResultsEvent<PullRequest>> { stateHandle.saveState(it) }
        )
    )

    init {
        stateHandle.onInit {
            dispatch(SearchResultsIntent.OnStart())
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(
            savedStateHandle: SavedStateHandle,
            searchText: String,
        ): SearchPullRequestResultsViewModel
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun provideFactory(
            assistedFactory: Factory,
            owner: SavedStateRegistryOwner,
            arguments: Bundle?,
            searchText: String,
        ): AbstractSavedStateViewModelFactory = object : AbstractSavedStateViewModelFactory(owner, arguments) {
            override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T =
                assistedFactory.create(handle, searchText) as T
        }
    }
}
