package io.github.gmvalentino8.github.sample.ui.features.search.top

import androidx.navigation.NavController
import io.github.gmvalentino8.github.sample.domain.entities.Repository

class SearchTopNavigator(private val navController: NavController) {
    fun back() = navController.popBackStack()
    fun repositoryDetails(repository: Repository) = navController.navigate(SearchTopFragmentDirections.actionSearchTopToRepoDetails(repository))
    fun repositoryResults(searchText: String) = navController.navigate(SearchTopFragmentDirections.actionSearchTopToSearchRepositoryResults(searchText))
    fun issueResults(searchText: String) = navController.navigate(SearchTopFragmentDirections.actionSearchTopToSearchIssueResults(searchText))
    fun pullRequestResults(searchText: String) = navController.navigate(SearchTopFragmentDirections.actionSearchTopToSearchPullRequestResults(searchText))
    fun userResults(searchText: String) = navController.navigate(SearchTopFragmentDirections.actionSearchTopToSearchUserResults(searchText))
    fun organizationResults(searchText: String) = navController.navigate(SearchTopFragmentDirections.actionSearchTopToSearchOrganizationResults(searchText))
}
