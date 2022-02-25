package jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract

import jp.co.yumemi.android.code_check.presentation.statemachine.contract.SideEffect

sealed class SearchRepoResultsSideEffect : SideEffect {
    data class Search(val pageNumber: Int) : SearchRepoResultsSideEffect()
}
