package io.github.gmvalentino8.github.sample.ui.features.search.results.pullrequest

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import io.github.gmvalentino8.github.sample.domain.entities.PullRequest
import io.github.gmvalentino8.github.sample.domain.usecases.SearchUseCase
import io.github.gmvalentino8.github.sample.presentation.core.factory.StoreFactory
import io.github.gmvalentino8.github.sample.presentation.feature.search.results.SearchResultsProcessor
import io.github.gmvalentino8.github.sample.presentation.feature.search.results.SearchResultsStateMachine
import io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract.SearchResultsAction
import io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract.SearchResultsEvent
import io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract.SearchResultsIntent
import io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract.SearchResultsResult
import io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract.SearchResultsViewState
import io.github.gmvalentino8.github.sample.presentation.statemachine.factory.StateMachineStoreFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
@Module
@InstallIn(ActivityRetainedComponent::class)
class SearchPullRequestResultsModule {
    @Provides
    fun provideSearchPullRequestResultsStateMachine(): SearchResultsStateMachine<PullRequest> = SearchResultsStateMachine()

    @Provides
    fun provideSearchPullRequestResultsStoreStateMachineFactory(
        stateMachine: SearchResultsStateMachine<PullRequest>,
        processor: SearchResultsProcessor<PullRequest>
    ): StoreFactory<SearchResultsIntent<PullRequest>,
        SearchResultsAction<PullRequest>,
        SearchResultsResult<PullRequest>,
        SearchResultsViewState<PullRequest>,
        SearchResultsEvent<PullRequest>> = StateMachineStoreFactory(stateMachine, processor)

    @Provides
    fun provideSearchPullRequestResultsProcessor(
        stateMachine: SearchResultsStateMachine<PullRequest>,
        searchUseCase: SearchUseCase<PullRequest>
    ): SearchResultsProcessor<PullRequest> = SearchResultsProcessor(stateMachine, searchUseCase)
}
