package jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract

import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.presentation.core.contract.Action
import jp.co.yumemi.android.code_check.presentation.core.contract.ProcessEventAction

sealed class SearchRepoResultsAction : Action {
    object NavigateBack : SearchRepoResultsAction()
    object LoadSearch : SearchRepoResultsAction()
    data class NavigateDetails(val item: Repository) : SearchRepoResultsAction()
    object RefreshSearch : SearchRepoResultsAction()
    object PageSearch : SearchRepoResultsAction()
    object ResolveError : SearchRepoResultsAction()
    data class ProcessEvent(override val event: SearchRepoResultsEvent) : SearchRepoResultsAction(), ProcessEventAction<SearchRepoResultsEvent>
}
