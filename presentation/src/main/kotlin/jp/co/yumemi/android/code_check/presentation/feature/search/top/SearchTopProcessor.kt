package jp.co.yumemi.android.code_check.presentation.feature.search.top

import jp.co.yumemi.android.code_check.domain.usecases.ClearRecentSearchesUseCase
import jp.co.yumemi.android.code_check.domain.usecases.GetRecentSearchesUseCase
import jp.co.yumemi.android.code_check.domain.usecases.SearchAllUseCase
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.utils.process
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopAction
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopEvent
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopIntent
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopResult
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopSideEffect
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachineProcessor
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@FlowPreview
class SearchTopProcessor(
    stateMachine: SearchTopStateMachine,
    private val clearRecentSearchesUseCase: ClearRecentSearchesUseCase,
    private val getRecentSearchesUseCase: GetRecentSearchesUseCase,
    private val searchAllUseCase: SearchAllUseCase,
) : StateMachineProcessor<SearchTopIntent, SearchTopAction, SearchTopResult, SearchTopViewState, SearchTopEvent, SearchTopSideEffect>(stateMachine) {
    override suspend fun process(sideEffect: SearchTopSideEffect, state: State<SearchTopViewState, SearchTopEvent>): Flow<SearchTopResult?> =
        when (sideEffect) {
            SearchTopSideEffect.ClearRecentSearches -> {
                clearRecentSearchesUseCase.execute(Unit)
                flowOf(SearchTopResult.ClearRecentSearches)
            }
            SearchTopSideEffect.LoadRecentSearches -> {
                flowOf(SearchTopResult.RecentSearches(getRecentSearchesUseCase.execute(Unit)))
            }
            is SearchTopSideEffect.SearchAll -> searchAllUseCase
                .execute(SearchAllUseCase.Args(sideEffect.searchText))
                .process(
                    onSuccess = { SearchTopResult.LoadSearchSuccess(it) },
                    onError = { SearchTopResult.LoadSearchError(it) },
                )
        }
}
