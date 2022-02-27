package jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract

import jp.co.yumemi.android.code_check.presentation.core.contract.Intent
import jp.co.yumemi.android.code_check.presentation.core.contract.ProcessEventIntent

sealed class RepoDetailsIntent : Intent {
    object OnStart : RepoDetailsIntent()
    object ClickBack : RepoDetailsIntent()
    object ClickTryAgain : RepoDetailsIntent()
    object PullToRefresh : RepoDetailsIntent()
    object ClickErrorOk : RepoDetailsIntent()
    data class ProcessEvent(override val event: RepoDetailsEvent) : RepoDetailsIntent(), ProcessEventIntent<RepoDetailsEvent>
}
