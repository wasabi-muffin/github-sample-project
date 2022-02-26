package jp.co.yumemi.android.code_check.ui.features.details.repo

import androidx.navigation.NavController

class RepoDetailsNavigator(private val navController: NavController) {
    fun back() = navController.popBackStack()
}
