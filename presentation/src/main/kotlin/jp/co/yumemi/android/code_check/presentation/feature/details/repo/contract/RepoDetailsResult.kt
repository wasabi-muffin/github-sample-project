package jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract

import jp.co.yumemi.android.code_check.domain.core.DomainError
import jp.co.yumemi.android.code_check.domain.entities.RepositoryDetails
import jp.co.yumemi.android.code_check.presentation.core.contract.Result

sealed class RepoDetailsResult : Result {
    object Loading : RepoDetailsResult()
    data class LoadDetailsSuccess(val details: RepositoryDetails) : RepoDetailsResult()
    data class LoadDetailsError(val error: DomainError) : RepoDetailsResult()
    object RefreshLoading : RepoDetailsResult()
    object ResolveError : RepoDetailsResult()
}
