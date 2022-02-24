package jp.co.yumemi.android.code_check.presentation.feature.search.top.contract

import jp.co.yumemi.android.code_check.presentation.statemachine.contract.SideEffect

sealed class SearchTopSideEffect : SideEffect {
    object LoadRecentSearches : SearchTopSideEffect()
    object ClearRecentSearches : SearchTopSideEffect()
}
