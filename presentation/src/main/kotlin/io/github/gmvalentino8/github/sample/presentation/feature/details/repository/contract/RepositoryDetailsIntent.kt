package io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract

import io.github.gmvalentino8.github.sample.presentation.core.contract.Intent
import io.github.gmvalentino8.github.sample.presentation.core.contract.ProcessEventIntent

sealed class RepositoryDetailsIntent : Intent {
    object OnStart : RepositoryDetailsIntent()
    object ClickBack : RepositoryDetailsIntent()
    object ClickTryAgain : RepositoryDetailsIntent()
    object PullToRefresh : RepositoryDetailsIntent()
    object ClickErrorOk : RepositoryDetailsIntent()
    data class ProcessEvent(override val event: RepositoryDetailsEvent) : RepositoryDetailsIntent(), ProcessEventIntent<RepositoryDetailsEvent>
}
