package jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract

import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.presentation.core.contract.Event
import kotlinx.parcelize.Parcelize

sealed class SearchRepoResultsEvent : Event() {
    @Parcelize object NavigateBack : SearchRepoResultsEvent()
    @Parcelize data class NavigateDetails(val item: Repository) : SearchRepoResultsEvent()
}
