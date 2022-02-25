package jp.co.yumemi.android.code_check.ui.features.search.results

import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
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
import jp.co.yumemi.android.code_check.ui.core.saveState

@HiltViewModel
class SearchRepoResultsViewModel @Inject constructor(
    storeFactory: StoreFactory<SearchRepoResultsIntent, SearchRepoResultsAction, SearchRepoResultsResult, SearchRepoResultsViewState, SearchRepoResultsEvent>,
    stateHandle: SavedStateHandle,
) : StoreViewModel<SearchRepoResultsIntent, SearchRepoResultsAction, SearchRepoResultsResult, SearchRepoResultsViewState, SearchRepoResultsEvent>(storeFactory) {
    override val store: Store<SearchRepoResultsIntent, SearchRepoResultsViewState, SearchRepoResultsEvent> = storeFactory.create(
        stateHandle.getState() ?: State(SearchRepoResultsViewState.Initial(TODO())),
        middlewares = listOf(
            StateSaverMiddleware<SearchRepoResultsViewState, SearchRepoResultsEvent> { stateHandle.saveState(it) }
        )
    )

    init {
        dispatch(SearchRepoResultsIntent.OnStart(TODO()))
    }
}
