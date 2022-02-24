package jp.co.yumemi.android.code_check.presentation.feature.search.top

import jp.co.yumemi.android.code_check.domain.entities.RecentSearch
import jp.co.yumemi.android.code_check.presentation.core.contract.Result

sealed class SearchTopResult : Result {
    data class RecentSearches(val data: List<RecentSearch>) : SearchTopResult()
    data class UpdateSearchText(val text: String) : SearchTopResult()
    object ClearRecentSearches : SearchTopResult()
}
