package jp.co.yumemi.android.code_check.ui.features.search.results.issue

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.android.code_check.domain.entities.Issue
import jp.co.yumemi.android.code_check.domain.usecases.SearchRepoUseCase
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
        searchRepoUseCase: SearchRepoUseCase<Issue>
    ): SearchResultsProcessor<Issue> = SearchResultsProcessor(stateMachine, searchRepoUseCase)
}
