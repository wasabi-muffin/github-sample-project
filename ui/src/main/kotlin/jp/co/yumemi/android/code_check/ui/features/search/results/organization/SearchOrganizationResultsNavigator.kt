package jp.co.yumemi.android.code_check.ui.features.search.results.organization

import androidx.navigation.NavController
import jp.co.yumemi.android.code_check.domain.entities.Organization
import jp.co.yumemi.android.code_check.ui.features.search.results.SearchResultsNavigator

class SearchOrganizationResultsNavigator(private val navController: NavController) : SearchResultsNavigator<Organization> {
    override fun back() {
        navController.popBackStack()
    }

    override fun details(item: Organization) = Unit // TODO: Add Organization Details
}
