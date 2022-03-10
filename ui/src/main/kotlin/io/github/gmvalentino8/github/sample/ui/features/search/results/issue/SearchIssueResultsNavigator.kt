package io.github.gmvalentino8.github.sample.ui.features.search.results.issue

import androidx.navigation.NavController
import io.github.gmvalentino8.github.sample.domain.entities.Issue
import io.github.gmvalentino8.github.sample.ui.features.search.results.SearchResultsNavigator

class SearchIssueResultsNavigator(private val navController: NavController) : SearchResultsNavigator<Issue> {
    override fun back() {
        navController.popBackStack()
    }

    override fun details(item: Issue) = Unit // TODO: Add Issue Details
}
