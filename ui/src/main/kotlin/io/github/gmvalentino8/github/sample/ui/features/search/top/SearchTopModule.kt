package io.github.gmvalentino8.github.sample.ui.features.search.top

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import io.github.gmvalentino8.github.sample.domain.usecases.ClearRecentSearchesUseCase
import io.github.gmvalentino8.github.sample.domain.usecases.GetRecentSearchesUseCase
import io.github.gmvalentino8.github.sample.domain.usecases.SearchAllUseCase
import io.github.gmvalentino8.github.sample.presentation.core.factory.StoreFactory
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.SearchTopProcessor
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.SearchTopStateMachine
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopAction
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopEvent
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopIntent
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopResult
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopViewState
import io.github.gmvalentino8.github.sample.presentation.statemachine.factory.StateMachineStoreFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
@Module
@InstallIn(ActivityRetainedComponent::class)
class SearchTopModule {
    @Provides
    fun provideSearchTopStateMachine(): SearchTopStateMachine = SearchTopStateMachine()

    @Provides
    fun provideSearchTopStoreStateMachineFactory(
        stateMachine: SearchTopStateMachine,
        processor: SearchTopProcessor
    ): StoreFactory<SearchTopIntent, SearchTopAction, SearchTopResult, SearchTopViewState, SearchTopEvent> = StateMachineStoreFactory(
        stateMachine, processor
    )

    @Provides
    fun provideSearchTopProcessor(
        stateMachine: SearchTopStateMachine,
        clearRecentSearchesUseCase: ClearRecentSearchesUseCase,
        getRecentSearchesUseCase: GetRecentSearchesUseCase,
        searchAllUseCase: SearchAllUseCase,
    ): SearchTopProcessor = SearchTopProcessor(stateMachine, clearRecentSearchesUseCase, getRecentSearchesUseCase, searchAllUseCase)
}
