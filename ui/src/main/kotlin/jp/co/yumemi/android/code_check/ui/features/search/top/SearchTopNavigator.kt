package jp.co.yumemi.android.code_check.ui.features.search.top

import androidx.navigation.NavController

class SearchTopNavigator(private val navController: NavController) {
    fun back() = navController.popBackStack()
    fun repositoryResults(searchText: String) = navController.navigate(SearchTopFragmentDirections.actionSearchTopToSearchRepositoryResults(searchText))
    fun issueResults(searchText: String) = navController.navigate(SearchTopFragmentDirections.actionSearchTopToSearchIssueResults(searchText))
}
