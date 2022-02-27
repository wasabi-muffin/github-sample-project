package jp.co.yumemi.android.code_check.ui.features.search.results.pullrequest

import androidx.navigation.NavController
import jp.co.yumemi.android.code_check.domain.entities.PullRequest
import jp.co.yumemi.android.code_check.ui.features.search.results.SearchResultsNavigator

class SearchPullRequestResultsNavigator(private val navController: NavController) : SearchResultsNavigator<PullRequest> {
    override fun back() {
        navController.popBackStack()
    }

    override fun details(item: PullRequest) = Unit // TODO: Add Pull Request Details
}
