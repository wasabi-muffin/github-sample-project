package jp.co.yumemi.android.code_check.ui.features.search.results

import androidx.navigation.NavController
import jp.co.yumemi.android.code_check.domain.entities.Repository

class SearchRepositoryResultsNavigator(private val navController: NavController) : SearchResultsNavigator<Repository> {
    override fun back() { navController.popBackStack() }
    override fun details(item: Repository) = navController.navigate(SearchRepoResultsFragmentDirections.actionSearchRepoResultsToRepoDetails(item))
}
