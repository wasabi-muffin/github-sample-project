package io.github.gmvalentino8.github.sample.ui.features.search.results.user

import androidx.navigation.NavController
import io.github.gmvalentino8.github.sample.domain.entities.User
import io.github.gmvalentino8.github.sample.ui.features.search.results.SearchResultsNavigator

class SearchUserResultsNavigator(private val navController: NavController) : SearchResultsNavigator<User> {
    override fun back() {
        navController.popBackStack()
    }

    override fun details(item: User) = Unit // TODO: Add User Details
}
