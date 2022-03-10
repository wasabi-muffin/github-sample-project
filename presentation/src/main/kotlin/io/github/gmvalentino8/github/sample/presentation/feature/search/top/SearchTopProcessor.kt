package io.github.gmvalentino8.github.sample.presentation.feature.search.top

import io.github.gmvalentino8.github.sample.domain.usecases.ClearRecentSearchesUseCase
import io.github.gmvalentino8.github.sample.domain.usecases.GetRecentSearchesUseCase
import io.github.gmvalentino8.github.sample.domain.usecases.SearchAllUseCase
import io.github.gmvalentino8.github.sample.presentation.core.contract.State
import io.github.gmvalentino8.github.sample.presentation.core.utils.process
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopAction
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopEvent
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopIntent
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopResult
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopSideEffect
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopViewState
import io.github.gmvalentino8.github.sample.presentation.statemachine.components.StateMachineProcessor
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
            is SearchTopSideEffect.SearchAll ->
                searchAllUseCase
                    .execute(SearchAllUseCase.Args(sideEffect.searchText))
                    .process(
                        onSuccess = { SearchTopResult.LoadSearchSuccess(it) },
                        onError = { SearchTopResult.LoadSearchError(it) },
                    )
        }
}
