package jp.co.yumemi.android.code_check.presentation.feature.details.repo

import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsAction
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsEvent
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsIntent
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsResult
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsSideEffect
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachine

class RepoDetailsStateMachine : StateMachine<RepoDetailsIntent, RepoDetailsAction, RepoDetailsResult, RepoDetailsViewState, RepoDetailsEvent, RepoDetailsSideEffect>(
    builder = {

    }
)
