package io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract

import io.github.gmvalentino8.github.sample.domain.entities.RecentSearch
import io.github.gmvalentino8.github.sample.domain.entities.Repository
import io.github.gmvalentino8.github.sample.domain.entities.SearchType
import io.github.gmvalentino8.github.sample.presentation.core.contract.Intent
import io.github.gmvalentino8.github.sample.presentation.core.contract.ProcessEventIntent

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
