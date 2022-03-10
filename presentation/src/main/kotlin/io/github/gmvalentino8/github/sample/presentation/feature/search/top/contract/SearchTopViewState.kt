package io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract

import io.github.gmvalentino8.github.sample.domain.core.DomainError
import io.github.gmvalentino8.github.sample.domain.entities.RecentSearch
import io.github.gmvalentino8.github.sample.domain.entities.SearchAll
import io.github.gmvalentino8.github.sample.presentation.core.contract.ViewState
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

        sealed class Search : Stable() {

            @Parcelize data class Loading(
                override val recentSearches: List<RecentSearch>,
                override val searchText: String
            ) : Search()

            @Parcelize data class Success(
                override val recentSearches: List<RecentSearch>,
                override val searchText: String,
                val searchResults: SearchAll,
            ) : Search()

            @Parcelize data class Error(
                override val recentSearches: List<RecentSearch>,
                override val searchText: String,
                val error: DomainError,
            ) : Search()
        }
    }
}
