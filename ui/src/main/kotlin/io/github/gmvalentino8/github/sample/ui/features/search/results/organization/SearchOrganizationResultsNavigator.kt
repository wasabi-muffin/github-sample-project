package io.github.gmvalentino8.github.sample.ui.features.search.results.organization

import androidx.navigation.NavController
import io.github.gmvalentino8.github.sample.domain.entities.Organization
import io.github.gmvalentino8.github.sample.ui.features.search.results.SearchResultsNavigator

class SearchOrganizationResultsNavigator(private val navController: NavController) : SearchResultsNavigator<Organization> {
    override fun back() {
        navController.popBackStack()
    }

    override fun details(item: Organization) = Unit // TODO: Add Organization Details
}
