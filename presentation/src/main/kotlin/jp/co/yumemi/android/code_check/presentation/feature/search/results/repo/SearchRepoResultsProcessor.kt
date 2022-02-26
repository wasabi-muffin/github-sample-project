package jp.co.yumemi.android.code_check.presentation.feature.search.results.repo

import jp.co.yumemi.android.code_check.domain.usecases.SearchRepoUseCase
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.utils.process
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsAction
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsEvent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsIntent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsResult
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsSideEffect
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachine
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachineProcessor
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow

@FlowPreview
class SearchRepoResultsProcessor(
    stateMachine: StateMachine<SearchRepoResultsIntent,
        SearchRepoResultsAction,
        SearchRepoResultsResult,
        SearchRepoResultsViewState,
        SearchRepoResultsEvent,
        SearchRepoResultsSideEffect>,
    private val searchRepoUseCase: SearchRepoUseCase
) : StateMachineProcessor<SearchRepoResultsIntent,
    SearchRepoResultsAction,
    SearchRepoResultsResult,
    SearchRepoResultsViewState,
    SearchRepoResultsEvent,
    SearchRepoResultsSideEffect>(
    stateMachine
) {
    override suspend fun process(
        sideEffect: SearchRepoResultsSideEffect,
        state: State<SearchRepoResultsViewState, SearchRepoResultsEvent>
    ): Flow<SearchRepoResultsResult?> = when (sideEffect) {
        is SearchRepoResultsSideEffect.Search -> searchRepoUseCase.execute(SearchRepoUseCase.Args(sideEffect.searchText, sideEffect.pageNumber)).process(
            onSuccess = { SearchRepoResultsResult.SearchSuccess(it) },
            onError = { SearchRepoResultsResult.SearchError(it) }
        )
    }
}
