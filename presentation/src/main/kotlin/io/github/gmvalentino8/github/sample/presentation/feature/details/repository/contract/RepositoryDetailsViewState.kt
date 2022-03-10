package io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract

import io.github.gmvalentino8.github.sample.domain.core.DomainError
import io.github.gmvalentino8.github.sample.domain.entities.Repository
import io.github.gmvalentino8.github.sample.domain.entities.RepositoryDetails
import io.github.gmvalentino8.github.sample.presentation.core.contract.ViewState
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
