package jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract

import jp.co.yumemi.android.code_check.presentation.core.contract.Intent
import jp.co.yumemi.android.code_check.presentation.core.contract.ProcessEventIntent

sealed class RepositoryDetailsIntent : Intent {
    object OnStart : RepositoryDetailsIntent()
    object ClickBack : RepositoryDetailsIntent()
    object ClickTryAgain : RepositoryDetailsIntent()
    object PullToRefresh : RepositoryDetailsIntent()
    object ClickErrorOk : RepositoryDetailsIntent()
    data class ProcessEvent(override val event: RepositoryDetailsEvent) : RepositoryDetailsIntent(), ProcessEventIntent<RepositoryDetailsEvent>
}
