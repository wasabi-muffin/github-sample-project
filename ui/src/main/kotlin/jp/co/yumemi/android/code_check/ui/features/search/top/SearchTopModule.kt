package jp.co.yumemi.android.code_check.di

import dagger.Provides
import jp.co.yumemi.android.code_check.domain.usecases.ClearRecentSearchesUseCase
import jp.co.yumemi.android.code_check.domain.usecases.GetRecentSearchesUseCase
import jp.co.yumemi.android.code_check.presentation.core.factory.StoreFactory
import jp.co.yumemi.android.code_check.presentation.feature.search.top.SearchTopProcessor
import jp.co.yumemi.android.code_check.presentation.feature.search.top.SearchTopStateMachine
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopAction
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopEvent
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopIntent
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopResult
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.factory.StateMachineStoreFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
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
    ): SearchTopProcessor = SearchTopProcessor(stateMachine, clearRecentSearchesUseCase, getRecentSearchesUseCase)
}
