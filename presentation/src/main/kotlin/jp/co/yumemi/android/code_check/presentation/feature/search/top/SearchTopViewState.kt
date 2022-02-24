package jp.co.yumemi.android.code_check.presentation.feature.search.top

import jp.co.yumemi.android.code_check.domain.entities.RecentSearch
import jp.co.yumemi.android.code_check.presentation.core.contract.ViewState
import kotlinx.parcelize.Parcelize

sealed class SearchTopViewState : ViewState {
    @Parcelize object Initial : SearchTopViewState()

    sealed class Stable : SearchTopViewState() {
        abstract val recentSearches: List<RecentSearch>

        @Parcelize data class EmptySearch(
            override val recentSearches: List<RecentSearch>,
        ) : Stable()

        @Parcelize data class NonEmptySearch(
            override val recentSearches: List<RecentSearch>,
            val searchText: String,
        ) : Stable()
    }
}
