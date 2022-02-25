package jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract

import jp.co.yumemi.android.code_check.domain.entities.SimpleGithubRepo
import jp.co.yumemi.android.code_check.presentation.core.contract.Intent

sealed class SearchRepoResultsIntent : Intent {
    object ClickBack : SearchRepoResultsIntent()
    data class OnStart(val searchText: String) : SearchRepoResultsIntent()
    object ClickTryAgain : SearchRepoResultsIntent()
    data class ClickItem(val item: SimpleGithubRepo)
    object PullToRefresh : SearchRepoResultsIntent()
    object ScrollToBottom : SearchRepoResultsIntent()
    object ClickErrorRetry : SearchRepoResultsIntent()
    object ClickErrorOk : SearchRepoResultsIntent()
}
