package jp.co.yumemi.android.code_check.ui.features.search.results

import androidx.navigation.NavController
import jp.co.yumemi.android.code_check.domain.entities.Repository

class SearchRepoResultsNavigator(private val navController: NavController) {
    fun back() = navController.popBackStack()
    fun details(repository: Repository) = navController.navigate(SearchRepoResultsFragmentDirections.actionSearchRepoResultsToRepoDetails(repository))
}
