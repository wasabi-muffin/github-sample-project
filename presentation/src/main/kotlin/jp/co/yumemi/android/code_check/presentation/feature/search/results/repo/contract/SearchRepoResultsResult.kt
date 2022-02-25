package jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract

import jp.co.yumemi.android.code_check.domain.core.DomainError
import jp.co.yumemi.android.code_check.domain.core.Pageable
import jp.co.yumemi.android.code_check.domain.entities.SimpleGithubRepo
import jp.co.yumemi.android.code_check.presentation.core.contract.ProcessEventResult
import jp.co.yumemi.android.code_check.presentation.core.contract.Result
import jp.co.yumemi.android.code_check.presentation.core.contract.SendEventResult

sealed class SearchRepoResultsResult : Result {
    object Loading : SearchRepoResultsResult()
    data class SearchSuccess(val data: Pageable<SimpleGithubRepo>) : SearchRepoResultsResult()
    data class SearchError(val error: DomainError) : SearchRepoResultsResult()
    object RefreshLoading : SearchRepoResultsResult()
    object PageLoading : SearchRepoResultsResult()
    object ResolveError : SearchRepoResultsResult()
    data class ProcessEvent(override val event: SearchRepoResultsEvent) : SearchRepoResultsResult(), ProcessEventResult<SearchRepoResultsEvent>
    data class SendEvent(override val event: SearchRepoResultsEvent) : SearchRepoResultsResult(), SendEventResult<SearchRepoResultsEvent>
}
