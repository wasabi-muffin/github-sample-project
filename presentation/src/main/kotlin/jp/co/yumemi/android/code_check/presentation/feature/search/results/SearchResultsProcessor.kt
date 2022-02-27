package jp.co.yumemi.android.code_check.presentation.feature.search.results

import android.os.Parcelable
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
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachineProcessor
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow

@FlowPreview
class SearchResultsProcessor<T : Parcelable>(
    stateMachine: StateMachine<SearchResultsIntent<T>,
        SearchResultsAction<T>,
        SearchResultsResult<T>,
        SearchResultsViewState<T>,
        SearchResultsEvent<T>,
        SearchResultsSideEffect<T>>,
    private val searchRepoUseCase: SearchRepoUseCase<T>
) : StateMachineProcessor<SearchResultsIntent<T>,
    SearchResultsAction<T>,
    SearchResultsResult<T>,
    SearchResultsViewState<T>,
    SearchResultsEvent<T>,
    SearchResultsSideEffect<T>>(stateMachine) {
    override suspend fun process(
        sideEffect: SearchResultsSideEffect<T>,
        state: State<SearchResultsViewState<T>, SearchResultsEvent<T>>
    ): Flow<SearchResultsResult<T>?> = when (sideEffect) {
        is SearchResultsSideEffect.Search -> searchRepoUseCase.execute(SearchRepoUseCase.Args(sideEffect.searchText, sideEffect.pageNumber)).process(
            onSuccess = { SearchResultsResult.SearchSuccess(it) },
            onError = { SearchResultsResult.SearchError(it) }
        )
    }
}
