package jp.co.yumemi.android.code_check.presentation.feature.search.results.repo

import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.usecases.SearchRepoUseCase
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.utils.process
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsAction
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsEvent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsIntent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsResult
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsSideEffect
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachine
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachineProcessor
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow

@FlowPreview
class SearchRepositoryResultsProcessor(
    stateMachine: StateMachine<SearchResultsIntent<Repository>,
        SearchResultsAction<Repository>,
        SearchResultsResult<Repository>,
        SearchResultsViewState<Repository>,
        SearchResultsEvent<Repository>,
        SearchResultsSideEffect<Repository>>,
    private val searchRepoUseCase: SearchRepoUseCase
) : StateMachineProcessor<SearchResultsIntent<Repository>,
    SearchResultsAction<Repository>,
    SearchResultsResult<Repository>,
    SearchResultsViewState<Repository>,
    SearchResultsEvent<Repository>,
    SearchResultsSideEffect<Repository>>(
    stateMachine
) {
    override suspend fun process(
        sideEffect: SearchResultsSideEffect<Repository>,
        state: State<SearchResultsViewState<Repository>, SearchResultsEvent<Repository>>
    ): Flow<SearchResultsResult<Repository>?> = when (sideEffect) {
        is SearchResultsSideEffect.Search -> searchRepoUseCase.execute(SearchRepoUseCase.Args(sideEffect.searchText, sideEffect.pageNumber)).process(
            onSuccess = { SearchResultsResult.SearchSuccess(it) },
            onError = { SearchResultsResult.SearchError(it) }
        )
    }
}
