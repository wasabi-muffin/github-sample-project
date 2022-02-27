package jp.co.yumemi.android.code_check.presentation.feature.search.top.contract

import jp.co.yumemi.android.code_check.domain.entities.RecentSearch
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.entities.SearchType
import jp.co.yumemi.android.code_check.presentation.core.contract.Intent
import jp.co.yumemi.android.code_check.presentation.core.contract.ProcessEventIntent

sealed class SearchTopIntent : Intent {
    object OnStart : SearchTopIntent()
    object ClickBack : SearchTopIntent()
    data class InputSearchText(val text: String) : SearchTopIntent()
    object ClickClearRecentSearches : SearchTopIntent()
    data class ClickRecentSearchItem(val recentSearch: RecentSearch) : SearchTopIntent()
    data class ClickItem(val type: SearchType) : SearchTopIntent()
    object ClickClearSearchText : SearchTopIntent()
    object ClickSearch : SearchTopIntent()
    object ClickTryAgain : SearchTopIntent()
    data class ClickRepositoryResult(val repository: Repository) : SearchTopIntent()
    data class ClickSeeAll(val searchType: SearchType) : SearchTopIntent()
    data class ProcessEvent(override val event: SearchTopEvent) : SearchTopIntent(), ProcessEventIntent<SearchTopEvent>
}
