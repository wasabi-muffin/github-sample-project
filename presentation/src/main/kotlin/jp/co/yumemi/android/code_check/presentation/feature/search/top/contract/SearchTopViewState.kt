package jp.co.yumemi.android.code_check.presentation.feature.search.top.contract

import jp.co.yumemi.android.code_check.domain.entities.RecentSearch
import jp.co.yumemi.android.code_check.presentation.core.contract.ViewState
import kotlinx.parcelize.Parcelize

sealed class SearchTopViewState : ViewState {
    @Parcelize object Initial : SearchTopViewState()

    sealed class Stable : SearchTopViewState() {
        abstract val recentSearches: List<RecentSearch>
        abstract val searchText: String

        @Parcelize data class EmptySearch(
            override val searchText: String = "",
            override val recentSearches: List<RecentSearch>,
        ) : Stable()

        @Parcelize data class NonEmptySearch(
            override val searchText: String,
            override val recentSearches: List<RecentSearch>,
        ) : Stable()
    }
}
