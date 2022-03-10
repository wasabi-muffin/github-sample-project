package io.github.gmvalentino8.github.sample.ui.features.search.results.issue

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import io.github.gmvalentino8.github.sample.domain.entities.Issue
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
class SearchIssueResultsModule {
    @Provides
    fun provideSearchIssueResultsStateMachine(): SearchResultsStateMachine<Issue> = SearchResultsStateMachine()

    @Provides
    fun provideSearchIssueResultsStoreStateMachineFactory(
        stateMachine: SearchResultsStateMachine<Issue>,
        processor: SearchResultsProcessor<Issue>
    ): StoreFactory<SearchResultsIntent<Issue>,
        SearchResultsAction<Issue>,
        SearchResultsResult<Issue>,
        SearchResultsViewState<Issue>,
        SearchResultsEvent<Issue>> = StateMachineStoreFactory(stateMachine, processor)

    @Provides
    fun provideSearchIssueResultsProcessor(
        stateMachine: SearchResultsStateMachine<Issue>,
        searchUseCase: SearchUseCase<Issue>
    ): SearchResultsProcessor<Issue> = SearchResultsProcessor(stateMachine, searchUseCase)
}
