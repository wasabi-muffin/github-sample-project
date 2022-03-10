package io.github.gmvalentino8.github.sample.ui.features.search.results.user

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import io.github.gmvalentino8.github.sample.domain.entities.User
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
class SearchUserResultsModule {
    @Provides
    fun provideSearchUserResultsStateMachine(): SearchResultsStateMachine<User> = SearchResultsStateMachine()

    @Provides
    fun provideSearchUserResultsStoreStateMachineFactory(
        stateMachine: SearchResultsStateMachine<User>,
        processor: SearchResultsProcessor<User>
    ): StoreFactory<SearchResultsIntent<User>,
        SearchResultsAction<User>,
        SearchResultsResult<User>,
        SearchResultsViewState<User>,
        SearchResultsEvent<User>> = StateMachineStoreFactory(stateMachine, processor)

    @Provides
    fun provideSearchUserResultsProcessor(
        stateMachine: SearchResultsStateMachine<User>,
        searchUseCase: SearchUseCase<User>
    ): SearchResultsProcessor<User> = SearchResultsProcessor(stateMachine, searchUseCase)
}
