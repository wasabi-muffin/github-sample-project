package io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract

import io.github.gmvalentino8.github.sample.domain.core.DomainError
import io.github.gmvalentino8.github.sample.domain.entities.RecentSearch
import io.github.gmvalentino8.github.sample.domain.entities.SearchAll
import io.github.gmvalentino8.github.sample.presentation.core.contract.ProcessEventResult
import io.github.gmvalentino8.github.sample.presentation.core.contract.Result
import io.github.gmvalentino8.github.sample.presentation.core.contract.SendEventResult

sealed class SearchTopResult : Result {
    data class RecentSearches(val data: List<RecentSearch>) : SearchTopResult()
    data class UpdateSearchText(val text: String) : SearchTopResult()
    object ClearRecentSearches : SearchTopResult()
    object Loading : SearchTopResult()
    data class LoadSearchSuccess(val results: SearchAll) : SearchTopResult()
    data class LoadSearchError(val error: DomainError) : SearchTopResult()
    data class SendEvent(override val event: SearchTopEvent) : SearchTopResult(), SendEventResult<SearchTopEvent>
    data class ProcessEvent(override val event: SearchTopEvent) : SearchTopResult(), ProcessEventResult<SearchTopEvent>
}
