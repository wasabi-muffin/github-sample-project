package jp.co.yumemi.android.code_check.presentation.feature.search.top

import jp.co.yumemi.android.code_check.domain.usecases.ClearRecentSearchesUseCase
import jp.co.yumemi.android.code_check.domain.usecases.GetRecentSearchesUseCase
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopAction
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopEvent
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopIntent
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopResult
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopSideEffect
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachineProcessor
import kotlinx.coroutines.FlowPreview

@FlowPreview
class SearchTopProcessor(
    stateMachine: SearchTopStateMachine,
    private val clearRecentSearchesUseCase: ClearRecentSearchesUseCase,
    private val getRecentSearchesUseCase: GetRecentSearchesUseCase,
) : StateMachineProcessor<SearchTopIntent, SearchTopAction, SearchTopResult, SearchTopViewState, SearchTopEvent, SearchTopSideEffect>(stateMachine) {
    override suspend fun process(sideEffect: SearchTopSideEffect, state: State<SearchTopViewState, SearchTopEvent>): List<SearchTopResult?> =
        when (sideEffect) {
            SearchTopSideEffect.ClearRecentSearches -> {
                clearRecentSearchesUseCase.execute(Unit)
                listOf(SearchTopResult.ClearRecentSearches)
            }
            SearchTopSideEffect.LoadRecentSearches -> {
                listOf(SearchTopResult.RecentSearches(getRecentSearchesUseCase.execute(Unit)))
            }
        }
}
