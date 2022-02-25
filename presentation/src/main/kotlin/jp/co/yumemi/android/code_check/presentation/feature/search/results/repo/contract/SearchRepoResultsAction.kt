package jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract

import jp.co.yumemi.android.code_check.domain.entities.SimpleGithubRepo
import jp.co.yumemi.android.code_check.presentation.core.contract.Action

sealed class SearchRepoResultsAction : Action {
    object NavigateBack : SearchRepoResultsAction()
    object LoadSearch : SearchRepoResultsAction()
    data class NavigateDetails(val item: SimpleGithubRepo) : SearchRepoResultsAction()
    object RefreshSearch : SearchRepoResultsAction()
    data class PageSearch(val pageNumber: Int) : SearchRepoResultsAction()
    object ResolveError : SearchRepoResultsAction()
}
