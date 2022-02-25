package jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract

import jp.co.yumemi.android.code_check.domain.entities.SimpleGithubRepo
import jp.co.yumemi.android.code_check.presentation.core.contract.Intent
import jp.co.yumemi.android.code_check.presentation.core.contract.ProcessEventIntent
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopEvent
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopIntent

sealed class SearchRepoResultsIntent : Intent {
    object ClickBack : SearchRepoResultsIntent()
    data class OnStart(val searchText: String) : SearchRepoResultsIntent()
    object ClickTryAgain : SearchRepoResultsIntent()
    data class ClickItem(val item: SimpleGithubRepo) : SearchRepoResultsIntent()
    object PullToRefresh : SearchRepoResultsIntent()
    object ScrollToBottom : SearchRepoResultsIntent()
    object ClickErrorRetry : SearchRepoResultsIntent()
    object ClickErrorOk : SearchRepoResultsIntent()
    data class ProcessEvent(override val event: SearchRepoResultsEvent): SearchRepoResultsIntent(), ProcessEventIntent<SearchRepoResultsEvent>
}
