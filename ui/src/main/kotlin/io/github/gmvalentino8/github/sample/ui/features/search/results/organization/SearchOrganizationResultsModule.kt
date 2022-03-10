package io.github.gmvalentino8.github.sample.ui.features.search.results.organization

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import io.github.gmvalentino8.github.sample.domain.entities.Organization
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
class SearchOrganizationResultsModule {
    @Provides
    fun provideSearchOrganizationResultsStateMachine(): SearchResultsStateMachine<Organization> = SearchResultsStateMachine()

    @Provides
    fun provideSearchOrganizationResultsStoreStateMachineFactory(
        stateMachine: SearchResultsStateMachine<Organization>,
        processor: SearchResultsProcessor<Organization>
    ): StoreFactory<SearchResultsIntent<Organization>,
        SearchResultsAction<Organization>,
        SearchResultsResult<Organization>,
        SearchResultsViewState<Organization>,
        SearchResultsEvent<Organization>> = StateMachineStoreFactory(stateMachine, processor)

    @Provides
    fun provideSearchOrganizationResultsProcessor(
        stateMachine: SearchResultsStateMachine<Organization>,
        searchUseCase: SearchUseCase<Organization>
    ): SearchResultsProcessor<Organization> = SearchResultsProcessor(stateMachine, searchUseCase)
}
