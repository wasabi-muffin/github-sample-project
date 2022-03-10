package io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract

import io.github.gmvalentino8.github.sample.presentation.statemachine.contract.SideEffect

sealed class SearchTopSideEffect : SideEffect {
    object LoadRecentSearches : SearchTopSideEffect()
    object ClearRecentSearches : SearchTopSideEffect()
    data class SearchAll(val searchText: String) : SearchTopSideEffect()
}
