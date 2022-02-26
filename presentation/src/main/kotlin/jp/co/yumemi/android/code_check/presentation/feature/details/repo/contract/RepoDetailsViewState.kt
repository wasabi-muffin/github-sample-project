package jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract

import jp.co.yumemi.android.code_check.domain.core.DomainError
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.entities.RepositoryDetails
import jp.co.yumemi.android.code_check.presentation.core.contract.ViewState
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

sealed class RepoDetailsViewState : ViewState {
    internal abstract val repo: Repository

    @Parcelize data class Initial(
        override val repo: Repository
    ) : RepoDetailsViewState()

    @Parcelize data class Loading(
        override val repo: Repository
    ) : RepoDetailsViewState()

    @Parcelize data class Error(
        override val repo: Repository,
        val error: DomainError
    ) : RepoDetailsViewState()

    sealed class Stable : RepoDetailsViewState() {
        abstract val details: RepositoryDetails

        @Parcelize data class Initial(
            override val repo: Repository,
            override val details: RepositoryDetails
        ) : Stable()

        @Parcelize data class RefreshLoading(
            override val repo: Repository,
            override val details: RepositoryDetails
        ) : Stable()

        @Parcelize data class RefreshError(
            override val repo: Repository,
            override val details: RepositoryDetails,
            val error: DomainError
        ) : Stable()
    }
}
