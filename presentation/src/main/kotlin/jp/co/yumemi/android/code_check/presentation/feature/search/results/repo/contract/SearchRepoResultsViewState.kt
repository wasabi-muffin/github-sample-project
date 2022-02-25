package jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract

import jp.co.yumemi.android.code_check.domain.entities.SimpleGithubRepo
import jp.co.yumemi.android.code_check.presentation.core.contract.ViewState
import kotlinx.parcelize.Parcelize

sealed class SearchRepoResultsViewState : ViewState {
    @Parcelize object Initial : SearchRepoResultsViewState()

    @Parcelize object Loading : SearchRepoResultsViewState()

    @Parcelize object Empty : SearchRepoResultsViewState()

    sealed class Stable : SearchRepoResultsViewState() {
        abstract val results: List<SimpleGithubRepo>
        abstract val pageable: Boolean
        internal abstract val pageNumber: Int
        internal abstract val totalCount: Int

        @Parcelize data class Initial(
            override val results: List<SimpleGithubRepo>,
            override val pageable: Boolean,
            override val pageNumber: Int,
            override val totalCount: Int,
        ) : Stable()

        @Parcelize data class PageLoading(
            override val results: List<SimpleGithubRepo>,
            override val pageable: Boolean,
            override val pageNumber: Int,
            override val totalCount: Int,
        ) : Stable()

        @Parcelize data class PageError(
            override val results: List<SimpleGithubRepo>,
            override val pageable: Boolean,
            override val pageNumber: Int,
            override val totalCount: Int,
        ) : Stable()

        @Parcelize data class RefreshLoading(
            override val results: List<SimpleGithubRepo>,
            override val pageable: Boolean,
            override val pageNumber: Int,
            override val totalCount: Int,
        ) : Stable()

        @Parcelize data class RefreshError(
            override val results: List<SimpleGithubRepo>,
            override val pageable: Boolean,
            override val pageNumber: Int,
            override val totalCount: Int,
        ) : Stable()
    }
}
