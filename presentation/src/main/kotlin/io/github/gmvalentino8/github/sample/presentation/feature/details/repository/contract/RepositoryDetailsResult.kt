package io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract

import io.github.gmvalentino8.github.sample.domain.core.DomainError
import io.github.gmvalentino8.github.sample.domain.entities.RepositoryDetails
import io.github.gmvalentino8.github.sample.presentation.core.contract.ProcessEventResult
import io.github.gmvalentino8.github.sample.presentation.core.contract.Result
import io.github.gmvalentino8.github.sample.presentation.core.contract.SendEventResult

sealed class RepositoryDetailsResult : Result {
    object Loading : RepositoryDetailsResult()
    data class LoadDetailsSuccess(val details: RepositoryDetails) : RepositoryDetailsResult()
    data class LoadDetailsError(val error: DomainError) : RepositoryDetailsResult()
    object RefreshLoading : RepositoryDetailsResult()
    object ResolveError : RepositoryDetailsResult()
    data class ProcessEvent(override val event: RepositoryDetailsEvent) : RepositoryDetailsResult(), ProcessEventResult<RepositoryDetailsEvent>
    data class SendEvent(override val event: RepositoryDetailsEvent) : RepositoryDetailsResult(), SendEventResult<RepositoryDetailsEvent>
}
