package jp.co.yumemi.android.code_check.presentation.feature.details.repository

import jp.co.yumemi.android.code_check.domain.usecases.GetRepositoryDetailsUseCase
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.utils.process
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract.RepositoryDetailsAction
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract.RepositoryDetailsEvent
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract.RepositoryDetailsIntent
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract.RepositoryDetailsResult
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract.RepositoryDetailsSideEffect
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract.RepositoryDetailsViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachine
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachineProcessor
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
