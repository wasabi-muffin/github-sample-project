package jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract

import jp.co.yumemi.android.code_check.domain.core.DomainError
import jp.co.yumemi.android.code_check.domain.core.Pageable
import jp.co.yumemi.android.code_check.domain.entities.SimpleGithubRepo
import jp.co.yumemi.android.code_check.presentation.core.contract.Result

sealed class SearchRepoResultsResult : Result {
    object Loading : SearchRepoResultsResult()
    data class SearchSuccess(val data: Pageable<SimpleGithubRepo>) : SearchRepoResultsResult()
    data class SearchError(val error: DomainError) : SearchRepoResultsResult()
    object RefreshLoading : SearchRepoResultsResult()
    object PageLoading : SearchRepoResultsResult()
    object ResolveError : SearchRepoResultsResult()
}
