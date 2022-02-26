package jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract

import jp.co.yumemi.android.code_check.presentation.core.contract.Intent

sealed class RepoDetailsIntent : Intent {
    object OnStart : RepoDetailsIntent()
    object ClickBack : RepoDetailsIntent()
    object ClickTryAgain : RepoDetailsIntent()
    object PullToRefresh : RepoDetailsIntent()
    object ClickErrorOK : RepoDetailsIntent()
}
