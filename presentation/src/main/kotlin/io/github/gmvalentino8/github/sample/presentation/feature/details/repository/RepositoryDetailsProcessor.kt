package io.github.gmvalentino8.github.sample.presentation.feature.details.repository

import io.github.gmvalentino8.github.sample.domain.usecases.GetRepositoryDetailsUseCase
import io.github.gmvalentino8.github.sample.presentation.core.contract.State
import io.github.gmvalentino8.github.sample.presentation.core.utils.process
import io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract.RepositoryDetailsAction
import io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract.RepositoryDetailsEvent
import io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract.RepositoryDetailsIntent
import io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract.RepositoryDetailsResult
import io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract.RepositoryDetailsSideEffect
import io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract.RepositoryDetailsViewState
import io.github.gmvalentino8.github.sample.presentation.statemachine.components.StateMachine
import io.github.gmvalentino8.github.sample.presentation.statemachine.components.StateMachineProcessor
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow

@FlowPreview
class RepositoryDetailsProcessor(
    stateMachine: StateMachine<RepositoryDetailsIntent,
        RepositoryDetailsAction,
        RepositoryDetailsResult,
        RepositoryDetailsViewState,
        RepositoryDetailsEvent,
        RepositoryDetailsSideEffect>,
    private val getRepositoryDetailsUseCase: GetRepositoryDetailsUseCase
) : StateMachineProcessor<RepositoryDetailsIntent,
    RepositoryDetailsAction,
    RepositoryDetailsResult,
    RepositoryDetailsViewState,
    RepositoryDetailsEvent,
    RepositoryDetailsSideEffect>(
    stateMachine = stateMachine
) {
    override suspend fun process(
        sideEffect: RepositoryDetailsSideEffect,
        state: State<RepositoryDetailsViewState, RepositoryDetailsEvent>
    ): Flow<RepositoryDetailsResult?> = when (sideEffect) {
        is RepositoryDetailsSideEffect.LoadDetails ->
            getRepositoryDetailsUseCase
                .execute(GetRepositoryDetailsUseCase.Args(sideEffect.repository))
                .process(
                    onSuccess = { RepositoryDetailsResult.LoadDetailsSuccess(details = it) },
                    onError = { RepositoryDetailsResult.LoadDetailsError(error = it) }
                )
    }
}
