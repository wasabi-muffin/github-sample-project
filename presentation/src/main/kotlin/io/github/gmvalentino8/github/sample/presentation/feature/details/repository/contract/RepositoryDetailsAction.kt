package io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract

import io.github.gmvalentino8.github.sample.presentation.core.contract.Action
import io.github.gmvalentino8.github.sample.presentation.core.contract.ProcessEventAction

sealed class RepositoryDetailsAction : Action {
    object LoadDetails : RepositoryDetailsAction()
    object NavigateBack : RepositoryDetailsAction()
    object RefreshDetails : RepositoryDetailsAction()
    object ResolveError : RepositoryDetailsAction()
    data class ProcessEvent(override val event: RepositoryDetailsEvent) : RepositoryDetailsAction(), ProcessEventAction<RepositoryDetailsEvent>
}
