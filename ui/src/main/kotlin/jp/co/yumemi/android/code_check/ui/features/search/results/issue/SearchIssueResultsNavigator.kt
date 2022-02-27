package jp.co.yumemi.android.code_check.ui.features.search.results.issue

import androidx.navigation.NavController
import jp.co.yumemi.android.code_check.domain.entities.Issue
import jp.co.yumemi.android.code_check.ui.features.search.results.SearchResultsNavigator

class SearchIssueResultsNavigator(private val navController: NavController) : SearchResultsNavigator<Issue> {
    override fun back() {
        navController.popBackStack()
    }

    override fun details(item: Issue) = Unit // TODO: Add Issue Details
}
