package jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract

import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.presentation.core.contract.Intent
import jp.co.yumemi.android.code_check.presentation.core.contract.ProcessEventIntent

sealed class SearchRepoResultsIntent : Intent {
    object OnStart : SearchRepoResultsIntent()
    object ClickBack : SearchRepoResultsIntent()
    object ClickTryAgain : SearchRepoResultsIntent()
    data class ClickItem(val item: Repository) : SearchRepoResultsIntent()
    object PullToRefresh : SearchRepoResultsIntent()
    object ScrollToBottom : SearchRepoResultsIntent()
    object ClickErrorRetry : SearchRepoResultsIntent()
    object ClickErrorOk : SearchRepoResultsIntent()
    data class ProcessEvent(override val event: SearchRepoResultsEvent) : SearchRepoResultsIntent(), ProcessEventIntent<SearchRepoResultsEvent>
}
