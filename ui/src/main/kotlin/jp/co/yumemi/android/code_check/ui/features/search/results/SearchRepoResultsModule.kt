package jp.co.yumemi.android.code_check.ui.features.search.results

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.usecases.SearchRepoUseCase
import jp.co.yumemi.android.code_check.presentation.core.factory.StoreFactory
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.SearchRepositoryResultsProcessor
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.SearchResultsProcessor
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
class SearchResultsModule {
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
        searchRepoUseCase: SearchRepoUseCase
    ): SearchResultsProcessor<Repository> = SearchRepositoryResultsProcessor(stateMachine, searchRepoUseCase)
}
