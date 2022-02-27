package jp.co.yumemi.android.code_check.presentation.feature.search.top.contract

import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.entities.SearchType
import jp.co.yumemi.android.code_check.presentation.core.contract.Action
import jp.co.yumemi.android.code_check.presentation.core.contract.ProcessEventAction

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
