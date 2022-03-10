package io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract

import io.github.gmvalentino8.github.sample.domain.entities.Repository
import io.github.gmvalentino8.github.sample.domain.entities.SearchType
import io.github.gmvalentino8.github.sample.presentation.core.contract.Action
import io.github.gmvalentino8.github.sample.presentation.core.contract.ProcessEventAction

sealed class SearchTopAction : Action {
    object LoadRecentSearches : SearchTopAction()
    data class UpdateSearchText(val text: String) : SearchTopAction()
    object ClearRecentSearches : SearchTopAction()
    object LoadSearch : SearchTopAction()
    object NavigateBack : SearchTopAction()
    data class NavigateSearch(val type: SearchType) : SearchTopAction()
    data class NavigateRepositoryDetails(val repository: Repository) : SearchTopAction()
    data class ProcessEvent(override val event: SearchTopEvent) : SearchTopAction(), ProcessEventAction<SearchTopEvent>
}
