package jp.co.yumemi.android.code_check.ui.features.search.results

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.android.code_check.domain.usecases.SearchRepoUseCase
import jp.co.yumemi.android.code_check.presentation.core.factory.StoreFactory
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.SearchRepoResultsProcessor
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.SearchRepoResultsStateMachine
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsAction
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsEvent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsIntent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsResult
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.factory.StateMachineStoreFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
@Module
@InstallIn(ActivityRetainedComponent::class)
class SearchRepoResultsModule {
    @Provides
    fun provideSearchRepoResultsStateMachine(): SearchRepoResultsStateMachine = SearchRepoResultsStateMachine()

    @Provides
    fun provideSearchRepoResultsStoreStateMachineFactory(
        stateMachine: SearchRepoResultsStateMachine,
        processor: SearchRepoResultsProcessor
    ): StoreFactory<SearchRepoResultsIntent, SearchRepoResultsAction, SearchRepoResultsResult, SearchRepoResultsViewState, SearchRepoResultsEvent> =
        StateMachineStoreFactory(stateMachine, processor)

    @Provides
    fun provideSearchRepoResultsProcessor(
        stateMachine: SearchRepoResultsStateMachine,
        searchRepoUseCase: SearchRepoUseCase,
    ): SearchRepoResultsProcessor = SearchRepoResultsProcessor(stateMachine, searchRepoUseCase)
}
