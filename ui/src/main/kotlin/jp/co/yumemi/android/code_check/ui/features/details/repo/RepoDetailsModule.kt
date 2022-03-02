package jp.co.yumemi.android.code_check.ui.features.details.repo

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.android.code_check.domain.usecases.GetRepositoryDetailsUseCase
import jp.co.yumemi.android.code_check.presentation.core.factory.StoreFactory
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.RepositoryDetailsProcessor
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.RepositoryDetailsStateMachine
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract.RepositoryDetailsAction
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract.RepositoryDetailsEvent
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract.RepositoryDetailsIntent
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract.RepositoryDetailsResult
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract.RepositoryDetailsViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.factory.StateMachineStoreFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
@Module
@InstallIn(ActivityRetainedComponent::class)
class RepoDetailsModule {
    @Provides
    fun provideRepoDetailsStateMachine(): RepositoryDetailsStateMachine = RepositoryDetailsStateMachine()

    @Provides
    fun provideRepoDetailsStoreStateMachineFactory(
        stateMachine: RepositoryDetailsStateMachine,
        processor: RepositoryDetailsProcessor
    ): StoreFactory<RepositoryDetailsIntent, RepositoryDetailsAction, RepositoryDetailsResult, RepositoryDetailsViewState, RepositoryDetailsEvent> =
        StateMachineStoreFactory(stateMachine, processor)

    @Provides
    fun provideRepoDetailsProcessor(
        stateMachine: RepositoryDetailsStateMachine,
        getRepositoryDetailsUseCase: GetRepositoryDetailsUseCase,
    ): RepositoryDetailsProcessor = RepositoryDetailsProcessor(stateMachine, getRepositoryDetailsUseCase)
}
