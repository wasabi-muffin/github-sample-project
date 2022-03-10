package io.github.gmvalentino8.github.sample.ui.features.search.results.repository

import androidx.navigation.NavController
import io.github.gmvalentino8.github.sample.domain.entities.Repository
import io.github.gmvalentino8.github.sample.ui.features.search.results.SearchResultsNavigator

class SearchRepositoryResultsNavigator(private val navController: NavController) : SearchResultsNavigator<Repository> {
    override fun back() {
        navController.popBackStack()
    }

    override fun details(item: Repository) = navController.navigate(SearchRepositoryResultsFragmentDirections.actionSearchRepositoryResultsToRepoDetails(item))
}
