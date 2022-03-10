package io.github.gmvalentino8.github.sample.presentation.feature.search.results

import android.os.Parcelable
import io.github.gmvalentino8.github.sample.domain.usecases.SearchUseCase
import io.github.gmvalentino8.github.sample.presentation.core.contract.State
import io.github.gmvalentino8.github.sample.presentation.core.utils.process
import io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract.SearchResultsAction
import io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract.SearchResultsEvent
import io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract.SearchResultsIntent
import io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract.SearchResultsResult
import io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract.SearchResultsSideEffect
import io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract.SearchResultsViewState
import io.github.gmvalentino8.github.sample.presentation.statemachine.components.StateMachine
import io.github.gmvalentino8.github.sample.presentation.statemachine.components.StateMachineProcessor
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
    private val searchUseCase: SearchUseCase<T>
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
        is SearchResultsSideEffect.Search -> searchUseCase.execute(SearchUseCase.Args(sideEffect.searchText, sideEffect.pageNumber)).process(
            onSuccess = { SearchResultsResult.SearchSuccess(it) },
            onError = { SearchResultsResult.SearchError(it) }
        )
    }
}
