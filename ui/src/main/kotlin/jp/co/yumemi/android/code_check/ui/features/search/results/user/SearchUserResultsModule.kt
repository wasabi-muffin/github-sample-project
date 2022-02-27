package jp.co.yumemi.android.code_check.ui.features.search.results.user

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.android.code_check.domain.entities.User
import jp.co.yumemi.android.code_check.domain.usecases.SearchUseCase
import jp.co.yumemi.android.code_check.presentation.core.factory.StoreFactory
import jp.co.yumemi.android.code_check.presentation.feature.search.results.SearchResultsProcessor
import jp.co.yumemi.android.code_check.presentation.feature.search.results.SearchResultsStateMachine
import jp.co.yumemi.android.code_check.presentation.feature.search.results.contract.SearchResultsAction
import jp.co.yumemi.android.code_check.presentation.feature.search.results.contract.SearchResultsEvent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.contract.SearchResultsIntent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.contract.SearchResultsResult
import jp.co.yumemi.android.code_check.presentation.feature.search.results.contract.SearchResultsViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.factory.StateMachineStoreFactory
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
