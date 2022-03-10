package io.github.gmvalentino8.github.sample.ui.features.details.repo

import androidx.navigation.NavController

class RepoDetailsNavigator(private val navController: NavController) {
    fun back() = navController.popBackStack()
}
