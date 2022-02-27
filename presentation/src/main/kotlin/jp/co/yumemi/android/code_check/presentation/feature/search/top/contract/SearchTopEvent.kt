package jp.co.yumemi.android.code_check.presentation.feature.search.top.contract

import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.entities.SearchType
import jp.co.yumemi.android.code_check.presentation.core.contract.Event
import kotlinx.parcelize.Parcelize

sealed class SearchTopEvent : Event() {
    @Parcelize object NavigateBack : SearchTopEvent()
    @Parcelize data class NavigateSearch(val type: SearchType, val searchText: String) : SearchTopEvent()
    @Parcelize data class NavigateRepositoryDetails(val repository: Repository) : SearchTopEvent()
}
