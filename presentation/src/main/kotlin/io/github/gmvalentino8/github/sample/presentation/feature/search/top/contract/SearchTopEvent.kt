package io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract

import io.github.gmvalentino8.github.sample.domain.entities.Repository
import io.github.gmvalentino8.github.sample.domain.entities.SearchType
import io.github.gmvalentino8.github.sample.presentation.core.contract.Event
import kotlinx.parcelize.Parcelize

sealed class SearchTopEvent : Event() {
    @Parcelize object NavigateBack : SearchTopEvent()
    @Parcelize data class NavigateSearch(val type: SearchType, val searchText: String) : SearchTopEvent()
    @Parcelize data class NavigateRepositoryDetails(val repository: Repository) : SearchTopEvent()
}
