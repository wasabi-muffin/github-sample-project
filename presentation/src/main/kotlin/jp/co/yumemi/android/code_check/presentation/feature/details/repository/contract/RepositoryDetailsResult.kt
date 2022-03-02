package jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract

import jp.co.yumemi.android.code_check.domain.core.DomainError
import jp.co.yumemi.android.code_check.domain.entities.RepositoryDetails
import jp.co.yumemi.android.code_check.presentation.core.contract.ProcessEventResult
import jp.co.yumemi.android.code_check.presentation.core.contract.Result
import jp.co.yumemi.android.code_check.presentation.core.contract.SendEventResult

sealed class RepositoryDetailsResult : Result {
    object Loading : RepositoryDetailsResult()
    data class LoadDetailsSuccess(val details: RepositoryDetails) : RepositoryDetailsResult()
    data class LoadDetailsError(val error: DomainError) : RepositoryDetailsResult()
    object RefreshLoading : RepositoryDetailsResult()
    object ResolveError : RepositoryDetailsResult()
    data class ProcessEvent(override val event: RepositoryDetailsEvent) : RepositoryDetailsResult(), ProcessEventResult<RepositoryDetailsEvent>
    data class SendEvent(override val event: RepositoryDetailsEvent) : RepositoryDetailsResult(), SendEventResult<RepositoryDetailsEvent>
}
