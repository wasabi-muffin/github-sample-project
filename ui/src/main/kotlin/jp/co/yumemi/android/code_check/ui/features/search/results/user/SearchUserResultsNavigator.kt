package jp.co.yumemi.android.code_check.ui.features.search.results.user

import androidx.navigation.NavController
import jp.co.yumemi.android.code_check.domain.entities.User
import jp.co.yumemi.android.code_check.ui.features.search.results.SearchResultsNavigator

class SearchUserResultsNavigator(private val navController: NavController) : SearchResultsNavigator<User> {
    override fun back() {
        navController.popBackStack()
    }

    override fun details(item: User) = Unit // TODO: Add User Details
}
