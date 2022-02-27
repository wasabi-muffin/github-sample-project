package jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract

import jp.co.yumemi.android.code_check.presentation.core.contract.Action
import jp.co.yumemi.android.code_check.presentation.core.contract.ProcessEventAction

sealed class RepoDetailsAction : Action {
    object LoadDetails : RepoDetailsAction()
    object NavigateBack : RepoDetailsAction()
    object RefreshDetails : RepoDetailsAction()
    object ResolveError : RepoDetailsAction()
    data class ProcessEvent(override val event: RepoDetailsEvent) : RepoDetailsAction(), ProcessEventAction<RepoDetailsEvent>
}
