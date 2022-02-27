package jp.co.yumemi.android.code_check.presentation.feature.search.results

import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.usecases.SearchRepoUseCase
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.utils.process
import jp.co.yumemi.android.code_check.presentation.feature.search.results.contract.SearchResultsAction
import jp.co.yumemi.android.code_check.presentation.feature.search.results.contract.SearchResultsEvent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.contract.SearchResultsIntent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.contract.SearchResultsResult
import jp.co.yumemi.android.code_check.presentation.feature.search.results.contract.SearchResultsSideEffect
import jp.co.yumemi.android.code_check.presentation.feature.search.results.contract.SearchResultsViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachine
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
    private val searchRepoUseCase: SearchRepoUseCase<Repository>
) : SearchResultsProcessor<Repository>(stateMachine) {
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
