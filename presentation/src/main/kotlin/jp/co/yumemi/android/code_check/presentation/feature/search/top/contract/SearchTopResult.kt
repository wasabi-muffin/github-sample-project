package jp.co.yumemi.android.code_check.presentation.feature.search.top.contract

import jp.co.yumemi.android.code_check.domain.core.DomainError
import jp.co.yumemi.android.code_check.domain.entities.RecentSearch
import jp.co.yumemi.android.code_check.domain.entities.SearchAll
import jp.co.yumemi.android.code_check.presentation.core.contract.ProcessEventResult
import jp.co.yumemi.android.code_check.presentation.core.contract.Result
import jp.co.yumemi.android.code_check.presentation.core.contract.SendEventResult

sealed class SearchTopResult : Result {
    data class RecentSearches(val data: List<RecentSearch>) : SearchTopResult()
    data class UpdateSearchText(val text: String) : SearchTopResult()
    object ClearRecentSearches : SearchTopResult()
    object Loading : SearchTopResult()
    data class LoadSearchSuccess(val results: SearchAll): SearchTopResult()
    data class LoadSearchError(val error: DomainError): SearchTopResult()
    data class SendEvent(override val event: SearchTopEvent) : SearchTopResult(), SendEventResult<SearchTopEvent>
    data class ProcessEvent(override val event: SearchTopEvent) : SearchTopResult(), ProcessEventResult<SearchTopEvent>
}
