package jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract

sealed class RepoDetailsIntent {
    object OnStart : RepoDetailsIntent()
    object ClickBack : RepoDetailsIntent()
    object ClickTryAgain : RepoDetailsIntent()
    object PullToRefresh : RepoDetailsIntent()
    object ClickErrorOK : RepoDetailsIntent()
}
