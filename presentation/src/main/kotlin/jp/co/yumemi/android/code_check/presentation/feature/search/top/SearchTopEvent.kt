package jp.co.yumemi.android.code_check.presentation.feature.search.top

import jp.co.yumemi.android.code_check.domain.entities.SearchType
import jp.co.yumemi.android.code_check.presentation.core.contract.Event
import kotlinx.parcelize.Parcelize

sealed class SearchTopEvent : Event() {
    @Parcelize object NavigateBack : SearchTopEvent()
    @Parcelize data class NavigateSearch(val type: SearchType) : SearchTopEvent()
}
