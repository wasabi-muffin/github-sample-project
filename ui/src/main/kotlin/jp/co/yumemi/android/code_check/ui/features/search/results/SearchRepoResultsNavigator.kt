package jp.co.yumemi.android.code_check.ui.features.search.results

import androidx.navigation.NavController

class SearchRepoResultsNavigator(private val navController: NavController) {
    fun back() = navController.popBackStack()
}
