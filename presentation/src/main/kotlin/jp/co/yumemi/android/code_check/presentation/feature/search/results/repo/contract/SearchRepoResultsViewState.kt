package jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract

import jp.co.yumemi.android.code_check.domain.core.DomainError
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.presentation.core.contract.ViewState
import kotlinx.parcelize.Parcelize

sealed class SearchRepoResultsViewState : ViewState {
    internal abstract val searchText: String

    @Parcelize data class Initial(
        override val searchText: String
    ) : SearchRepoResultsViewState()

    @Parcelize data class Loading(
        override val searchText: String
    ) : SearchRepoResultsViewState()

    @Parcelize data class Empty(
        override val searchText: String
    ) : SearchRepoResultsViewState()

    sealed class Stable : SearchRepoResultsViewState() {
        abstract val results: List<Repository>
        internal abstract val pageNumber: Int
        internal abstract val totalCount: Int
        val pageable: Boolean get() = results.size < totalCount

        @Parcelize data class Initial(
            override val searchText: String,
            override val results: List<Repository>,
            override val pageNumber: Int,
            override val totalCount: Int,
        ) : Stable()

        @Parcelize data class PageLoading(
            override val searchText: String,
            override val results: List<Repository>,
            override val pageNumber: Int,
            override val totalCount: Int,
        ) : Stable()

        @Parcelize data class PageError(
            override val searchText: String,
            override val results: List<Repository>,
            override val pageNumber: Int,
            override val totalCount: Int,
            val error: DomainError,
        ) : Stable()

        @Parcelize data class RefreshLoading(
            override val searchText: String,
            override val results: List<Repository>,
            override val pageNumber: Int,
            override val totalCount: Int,
        ) : Stable()

        @Parcelize data class RefreshError(
            override val searchText: String,
            override val results: List<Repository>,
            override val pageNumber: Int,
            override val totalCount: Int,
            val error: DomainError,
        ) : Stable()
    }

    @Parcelize data class Error(
        val error: DomainError,
        override val searchText: String
    ) : SearchRepoResultsViewState()
}
