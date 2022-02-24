package jp.co.yumemi.android.code_check.presentation.feature.search.top

import jp.co.yumemi.android.code_check.domain.usecases.ClearRecentSearchesUseCase
import jp.co.yumemi.android.code_check.domain.usecases.GetRecentSearchesUseCase
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachineProcessor

class SearchTopProcessor(
    stateMachine: SearchTopStateMachine,
    private val clearRecentSearchesUseCase: ClearRecentSearchesUseCase,
    private val getRecentSearchesUseCase: GetRecentSearchesUseCase,
) : StateMachineProcessor<SearchTopIntent, SearchTopAction, SearchTopResult, SearchTopViewState, SearchTopEvent, SearchTopSideEffect>(stateMachine) {
    override suspend fun process(sideEffect: SearchTopSideEffect, state: State<SearchTopViewState, SearchTopEvent>): SearchTopResult? = when (sideEffect) {
        SearchTopSideEffect.ClearRecentSearches -> {
            clearRecentSearchesUseCase.execute(Unit)
            SearchTopResult.ClearRecentSearches
        }
        SearchTopSideEffect.LoadRecentSearches -> {
            SearchTopResult.RecentSearches(
                getRecentSearchesUseCase.execute(Unit)
            )
        }
    }
}
