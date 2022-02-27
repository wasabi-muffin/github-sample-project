package jp.co.yumemi.android.code_check.ui.features.search.results

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.android.code_check.domain.usecases.SearchRepoUseCase
import jp.co.yumemi.android.code_check.presentation.core.factory.StoreFactory
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.SearchRepositoryResultsProcessor
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.SearchResultsStateMachine
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsAction
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsEvent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsIntent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsResult
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.factory.StateMachineStoreFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
@Module
@InstallIn(ActivityRetainedComponent::class)
class SearchRepoResultsModule {
    @Provides
    fun provideSearchRepoResultsStateMachine(): SearchResultsStateMachine = SearchResultsStateMachine()

    @Provides
    fun provideSearchRepoResultsStoreStateMachineFactory(
        stateMachine: SearchResultsStateMachine,
        processor: SearchRepositoryResultsProcessor
    ): StoreFactory<SearchResultsIntent, SearchResultsAction, SearchResultsResult, SearchResultsViewState, SearchResultsEvent> =
        StateMachineStoreFactory(stateMachine, processor)

    @Provides
    fun provideSearchRepoResultsProcessor(
        stateMachine: SearchResultsStateMachine,
        searchRepoUseCase: SearchRepoUseCase,
    ): SearchRepositoryResultsProcessor = SearchRepositoryResultsProcessor(stateMachine, searchRepoUseCase)
}
