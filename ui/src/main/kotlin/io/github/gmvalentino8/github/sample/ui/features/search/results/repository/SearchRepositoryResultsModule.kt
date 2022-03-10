package io.github.gmvalentino8.github.sample.ui.features.search.results.repository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import io.github.gmvalentino8.github.sample.domain.entities.Repository
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
class SearchRepositoryResultsModule {
    @Provides
    fun provideSearchRepositoryResultsStateMachine(): SearchResultsStateMachine<Repository> = SearchResultsStateMachine()

    @Provides
    fun provideSearchRepositoryResultsStoreStateMachineFactory(
        stateMachine: SearchResultsStateMachine<Repository>,
        processor: SearchResultsProcessor<Repository>
    ): StoreFactory<SearchResultsIntent<Repository>,
        SearchResultsAction<Repository>,
        SearchResultsResult<Repository>,
        SearchResultsViewState<Repository>,
        SearchResultsEvent<Repository>> = StateMachineStoreFactory(stateMachine, processor)

    @Provides
    fun provideSearchRepositoryResultsProcessor(
        stateMachine: SearchResultsStateMachine<Repository>,
        searchUseCase: SearchUseCase<Repository>
    ): SearchResultsProcessor<Repository> = SearchResultsProcessor(stateMachine, searchUseCase)
}
