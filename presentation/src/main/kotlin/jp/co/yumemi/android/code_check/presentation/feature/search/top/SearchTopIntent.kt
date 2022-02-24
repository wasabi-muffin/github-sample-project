package jp.co.yumemi.android.code_check.presentation.feature.search.top

import jp.co.yumemi.android.code_check.domain.entities.RecentSearch
import jp.co.yumemi.android.code_check.domain.entities.SearchType
import jp.co.yumemi.android.code_check.presentation.core.contract.Intent

sealed class SearchTopIntent : Intent {
    object OnStart : SearchTopIntent()
    object ClickBack: SearchTopIntent()
    data class InputSearchText(val text: String): SearchTopIntent()
    object ClickClearRecentSearches : SearchTopIntent()
    data class ClickRecentSearchItem(val recentSearch: RecentSearch) : SearchTopIntent()
    data class ClickItem(val type: SearchType) : SearchTopIntent()
    object ClickClearSearchText : SearchTopIntent()
}
