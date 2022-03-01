package jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract

import jp.co.yumemi.android.code_check.presentation.core.contract.Action
import jp.co.yumemi.android.code_check.presentation.core.contract.ProcessEventAction

sealed class RepositoryDetailsAction : Action {
    object LoadDetails : RepositoryDetailsAction()
    object NavigateBack : RepositoryDetailsAction()
    object RefreshDetails : RepositoryDetailsAction()
    object ResolveError : RepositoryDetailsAction()
    data class ProcessEvent(override val event: RepositoryDetailsEvent) : RepositoryDetailsAction(), ProcessEventAction<RepositoryDetailsEvent>
}
