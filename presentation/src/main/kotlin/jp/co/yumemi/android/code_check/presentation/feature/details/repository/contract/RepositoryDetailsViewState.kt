package jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract

import jp.co.yumemi.android.code_check.domain.core.DomainError
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.entities.RepositoryDetails
import jp.co.yumemi.android.code_check.presentation.core.contract.ViewState
import kotlinx.parcelize.Parcelize

sealed class RepositoryDetailsViewState : ViewState {
    internal abstract val repository: Repository

    @Parcelize data class Initial(
        override val repository: Repository
    ) : RepositoryDetailsViewState()

    @Parcelize data class Loading(
        override val repository: Repository
    ) : RepositoryDetailsViewState()

    @Parcelize data class Error(
        override val repository: Repository,
        val error: DomainError
    ) : RepositoryDetailsViewState()

    sealed class Stable : RepositoryDetailsViewState() {
        abstract val details: RepositoryDetails

        @Parcelize data class Initial(
            override val repository: Repository,
            override val details: RepositoryDetails
        ) : Stable()

        @Parcelize data class RefreshLoading(
            override val repository: Repository,
            override val details: RepositoryDetails
        ) : Stable()

        @Parcelize data class RefreshError(
            override val repository: Repository,
            override val details: RepositoryDetails,
            val error: DomainError
        ) : Stable()
    }
}
