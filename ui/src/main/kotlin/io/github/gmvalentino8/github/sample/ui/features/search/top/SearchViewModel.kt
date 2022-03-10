package io.github.gmvalentino8.github.sample.ui.features.search.top

import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import io.github.gmvalentino8.github.sample.presentation.core.components.Store
import io.github.gmvalentino8.github.sample.presentation.core.contract.State
import io.github.gmvalentino8.github.sample.presentation.core.factory.StoreFactory
import io.github.gmvalentino8.github.sample.presentation.core.middleware.StateSaverMiddleware
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopAction
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopEvent
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopIntent
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopResult
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopViewState
import io.github.gmvalentino8.github.sample.ui.core.StoreViewModel
import io.github.gmvalentino8.github.sample.ui.core.getState
import io.github.gmvalentino8.github.sample.ui.core.saveState

@HiltViewModel
class SearchViewModel @Inject constructor(
    storeFactory: StoreFactory<SearchTopIntent, SearchTopAction, SearchTopResult, SearchTopViewState, SearchTopEvent>,
    stateHandle: SavedStateHandle,
) : StoreViewModel<SearchTopIntent, SearchTopAction, SearchTopResult, SearchTopViewState, SearchTopEvent>(storeFactory) {
    override val store: Store<SearchTopIntent, SearchTopViewState, SearchTopEvent> = storeFactory.create(
        stateHandle.getState() ?: State(SearchTopViewState.Initial),
        middlewares = listOf(
            StateSaverMiddleware<SearchTopViewState, SearchTopEvent> { stateHandle.saveState(it) }
        )
    )

    init {
        dispatch(SearchTopIntent.OnStart)
    }
}
