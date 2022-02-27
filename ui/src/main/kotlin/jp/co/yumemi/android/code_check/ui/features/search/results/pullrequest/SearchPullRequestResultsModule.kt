package jp.co.yumemi.android.code_check.ui.features.search.results.pullrequest

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.android.code_check.domain.entities.PullRequest
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
class SearchPullRequestResultsModule {
    @Provides
    fun provideSearchPullRequestResultsStateMachine(): SearchResultsStateMachine<PullRequest> = SearchResultsStateMachine()

    @Provides
    fun provideSearchPullRequestResultsStoreStateMachineFactory(
        stateMachine: SearchResultsStateMachine<PullRequest>,
        processor: SearchResultsProcessor<PullRequest>
    ): StoreFactory<SearchResultsIntent<PullRequest>,
        SearchResultsAction<PullRequest>,
        SearchResultsResult<PullRequest>,
        SearchResultsViewState<PullRequest>,
        SearchResultsEvent<PullRequest>> = StateMachineStoreFactory(stateMachine, processor)

    @Provides
    fun provideSearchPullRequestResultsProcessor(
        stateMachine: SearchResultsStateMachine<PullRequest>,
        searchUseCase: SearchUseCase<PullRequest>
    ): SearchResultsProcessor<PullRequest> = SearchResultsProcessor(stateMachine, searchUseCase)
}
