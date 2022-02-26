package jp.co.yumemi.android.code_check.ui.features.details.repo

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.android.code_check.domain.usecases.GetRepositoryDetailsUseCase
import jp.co.yumemi.android.code_check.presentation.core.factory.StoreFactory
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.RepoDetailsProcessor
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.RepoDetailsStateMachine
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsAction
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsEvent
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsIntent
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsResult
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.factory.StateMachineStoreFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
@Module
@InstallIn(ActivityRetainedComponent::class)
class RepoDetailsModule {
    @Provides
    fun provideRepoDetailsStateMachine(): RepoDetailsStateMachine = RepoDetailsStateMachine()

    @Provides
    fun provideRepoDetailsStoreStateMachineFactory(
        stateMachine: RepoDetailsStateMachine,
        processor: RepoDetailsProcessor
    ): StoreFactory<RepoDetailsIntent, RepoDetailsAction, RepoDetailsResult, RepoDetailsViewState, RepoDetailsEvent> =
        StateMachineStoreFactory(stateMachine, processor)

    @Provides
    fun provideRepoDetailsProcessor(
        stateMachine: RepoDetailsStateMachine,
        getRepositoryDetailsUseCase: GetRepositoryDetailsUseCase,
    ): RepoDetailsProcessor = RepoDetailsProcessor(stateMachine, getRepositoryDetailsUseCase)
}
