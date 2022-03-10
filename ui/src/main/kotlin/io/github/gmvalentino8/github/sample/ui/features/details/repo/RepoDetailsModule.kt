package io.github.gmvalentino8.github.sample.ui.features.details.repo

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import io.github.gmvalentino8.github.sample.domain.usecases.GetRepositoryDetailsUseCase
import io.github.gmvalentino8.github.sample.presentation.core.factory.StoreFactory
import io.github.gmvalentino8.github.sample.presentation.feature.details.repository.RepositoryDetailsProcessor
import io.github.gmvalentino8.github.sample.presentation.feature.details.repository.RepositoryDetailsStateMachine
import io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract.RepositoryDetailsAction
import io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract.RepositoryDetailsEvent
import io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract.RepositoryDetailsIntent
import io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract.RepositoryDetailsResult
import io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract.RepositoryDetailsViewState
import io.github.gmvalentino8.github.sample.presentation.statemachine.factory.StateMachineStoreFactory
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
