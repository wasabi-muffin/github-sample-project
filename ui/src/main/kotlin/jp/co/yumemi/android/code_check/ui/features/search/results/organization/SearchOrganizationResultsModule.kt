package jp.co.yumemi.android.code_check.ui.features.search.results.organization

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.android.code_check.domain.entities.Organization
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
