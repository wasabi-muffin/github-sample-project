package io.github.gmvalentino8.github.sample.ui.features.search.results.repository

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.github.gmvalentino8.github.sample.domain.entities.Repository
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

class SearchRepositoryResultsViewModel @AssistedInject constructor(
    storeFactory: StoreFactory<SearchResultsIntent<Repository>,
        SearchResultsAction<Repository>,
        SearchResultsResult<Repository>,
        SearchResultsViewState<Repository>,
        SearchResultsEvent<Repository>>,
    @Assisted stateHandle: SavedStateHandle,
    @Assisted val searchText: String,
) : StoreViewModel<SearchResultsIntent<Repository>,
    SearchResultsAction<Repository>,
    SearchResultsResult<Repository>,
    SearchResultsViewState<Repository>,
    SearchResultsEvent<Repository>>(storeFactory) {
    override val store: Store<SearchResultsIntent<Repository>, SearchResultsViewState<Repository>, SearchResultsEvent<Repository>> = storeFactory.create(
        stateHandle.getState() ?: State(SearchResultsViewState.Initial(searchText)),
        middlewares = listOf(
            StateSaverMiddleware<SearchResultsViewState<Repository>, SearchResultsEvent<Repository>> { stateHandle.saveState(it) }
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
        ): SearchRepositoryResultsViewModel
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
