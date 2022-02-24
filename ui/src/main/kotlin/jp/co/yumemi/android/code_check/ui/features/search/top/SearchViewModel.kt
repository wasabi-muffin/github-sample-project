package jp.co.yumemi.android.code_check.ui.features.search.top

import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import jp.co.yumemi.android.code_check.domain.entities.RecentSearch
import jp.co.yumemi.android.code_check.presentation.core.components.Store
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.factory.StoreFactory
import jp.co.yumemi.android.code_check.presentation.core.middleware.StateSaverMiddleware
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopAction
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopEvent
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopIntent
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopResult
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopViewState
import jp.co.yumemi.android.code_check.ui.core.StoreViewModel
import jp.co.yumemi.android.code_check.ui.core.getState
import jp.co.yumemi.android.code_check.ui.core.saveState

@HiltViewModel
class SearchViewModel @Inject constructor(
    storeFactory: StoreFactory<SearchTopIntent, SearchTopAction, SearchTopResult, SearchTopViewState, SearchTopEvent>,
    stateHandle: SavedStateHandle,
) : StoreViewModel<SearchTopIntent, SearchTopAction, SearchTopResult, SearchTopViewState, SearchTopEvent>(storeFactory) {
    override val store: Store<SearchTopIntent, SearchTopViewState, SearchTopEvent> = storeFactory.create(
        stateHandle.getState() ?: State(SearchTopViewState.Stable.EmptySearch(recentSearches = listOf(
            RecentSearch("1", 0L),
            RecentSearch("abcdefghijklmnopqrstuvwxyzabcdefghijklmnoprstuvwxyzabcdefghjijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz", 5L),
            RecentSearch("asdf", 2L),
            RecentSearch("asdfff", 4L),
        ))),
        middlewares = listOf(
            StateSaverMiddleware<SearchTopViewState, SearchTopEvent> { stateHandle.saveState(it) }
        )
    )

    init {
        dispatch(SearchTopIntent.OnStart)
    }
}
