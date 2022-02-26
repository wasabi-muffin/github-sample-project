package jp.co.yumemi.android.code_check.presentation.feature.details.repo

import jp.co.yumemi.android.code_check.domain.usecases.GetRepositoryDetailsUseCase
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.utils.process
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsAction
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsEvent
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsIntent
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsResult
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsSideEffect
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachine
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachineProcessor
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow

@FlowPreview
class RepoDetailsProcessor(
    stateMachine: StateMachine<RepoDetailsIntent,
        RepoDetailsAction,
        RepoDetailsResult,
        RepoDetailsViewState,
        RepoDetailsEvent,
        RepoDetailsSideEffect>,
    private val getRepositoryDetailsUseCase: GetRepositoryDetailsUseCase
) : StateMachineProcessor<RepoDetailsIntent,
    RepoDetailsAction,
    RepoDetailsResult,
    RepoDetailsViewState,
    RepoDetailsEvent,
    RepoDetailsSideEffect>(
    stateMachine = stateMachine
) {
    override suspend fun process(
        sideEffect: RepoDetailsSideEffect,
        state: State<RepoDetailsViewState, RepoDetailsEvent>
    ): Flow<RepoDetailsResult?> = when (sideEffect) {
        is RepoDetailsSideEffect.LoadDetails -> getRepositoryDetailsUseCase
            .execute(GetRepositoryDetailsUseCase.Args(sideEffect.repo))
            .process(
                onSuccess = { RepoDetailsResult.LoadDetailsSuccess(details = it) },
                onError = { RepoDetailsResult.LoadDetailsError(error = it) }
            )
    }
}
