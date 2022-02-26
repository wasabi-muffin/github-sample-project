package jp.co.yumemi.android.code_check.ui.features.search.results

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import jp.co.yumemi.android.code_check.presentation.core.components.Store
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.factory.StoreFactory
import jp.co.yumemi.android.code_check.presentation.core.middleware.StateSaverMiddleware
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsAction
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsEvent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsIntent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsResult
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsViewState
import jp.co.yumemi.android.code_check.ui.core.StoreViewModel
import jp.co.yumemi.android.code_check.ui.core.getState
import jp.co.yumemi.android.code_check.ui.core.onInit
import jp.co.yumemi.android.code_check.ui.core.saveState

class SearchRepoResultsViewModel @AssistedInject constructor(
    storeFactory: StoreFactory<SearchRepoResultsIntent, SearchRepoResultsAction, SearchRepoResultsResult, SearchRepoResultsViewState, SearchRepoResultsEvent>,
    @Assisted stateHandle: SavedStateHandle,
    @Assisted val searchText: String,
) : StoreViewModel<SearchRepoResultsIntent,
    SearchRepoResultsAction,
    SearchRepoResultsResult,
    SearchRepoResultsViewState,
    SearchRepoResultsEvent>(storeFactory) {
    override val store: Store<SearchRepoResultsIntent, SearchRepoResultsViewState, SearchRepoResultsEvent> = storeFactory.create(
        stateHandle.getState() ?: State(SearchRepoResultsViewState.Initial(searchText)),
        middlewares = listOf(
            StateSaverMiddleware<SearchRepoResultsViewState, SearchRepoResultsEvent> { stateHandle.saveState(it) }
        )
    )

    init {
        stateHandle.onInit {
            dispatch(SearchRepoResultsIntent.OnStart)
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(
            savedStateHandle: SavedStateHandle,
            searchText: String,
        ): SearchRepoResultsViewModel
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
