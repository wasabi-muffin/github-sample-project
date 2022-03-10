package io.github.gmvalentino8.github.sample.ui.features.search.results.pullrequest

import androidx.navigation.NavController
import io.github.gmvalentino8.github.sample.domain.entities.PullRequest
import io.github.gmvalentino8.github.sample.ui.features.search.results.SearchResultsNavigator

class SearchPullRequestResultsNavigator(private val navController: NavController) : SearchResultsNavigator<PullRequest> {
    override fun back() {
        navController.popBackStack()
    }

    override fun details(item: PullRequest) = Unit // TODO: Add Pull Request Details
}
