package jp.co.yumemi.android.code_check.presentation.feature.search.results.repo

import jp.co.yumemi.android.code_check.domain.core.DomainResult
import jp.co.yumemi.android.code_check.domain.usecases.SearchRepoUseCase
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsAction
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsEvent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsIntent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsResult
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsSideEffect
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachine
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachineProcessor

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
    ): SearchRepoResultsResult? = when (sideEffect) {
        is SearchRepoResultsSideEffect.Search -> {
            when (val result = searchRepoUseCase.execute(SearchRepoUseCase.Args(sideEffect.searchText, sideEffect.pageNumber))) {
                is DomainResult.Success -> SearchRepoResultsResult.SearchSuccess(result.data)
                is DomainResult.Failure -> SearchRepoResultsResult.SearchError(result.error)
            }
        }
    }
}
