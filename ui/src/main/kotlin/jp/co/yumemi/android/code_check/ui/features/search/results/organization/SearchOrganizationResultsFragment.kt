package jp.co.yumemi.android.code_check.ui.features.search.results.organization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import jp.co.yumemi.android.code_check.ui.R
import jp.co.yumemi.android.code_check.ui.components.search.SearchOrganizationResultItem
import jp.co.yumemi.android.code_check.ui.core.contract
import jp.co.yumemi.android.code_check.ui.features.search.results.SearchResultsScreen
import jp.co.yumemi.android.code_check.ui.utils.compose
import jp.co.yumemi.android.code_check.ui.utils.notImplemented

@AndroidEntryPoint
class SearchOrganizationResultsFragment : Fragment() {
    @Inject lateinit var assistedFactory: SearchOrganizationResultsViewModel.Factory
    private val navArgs: SearchOrganizationResultsFragmentArgs by navArgs()
    private val viewModel: SearchOrganizationResultsViewModel by viewModels {
        SearchOrganizationResultsViewModel.provideFactory(
            assistedFactory = assistedFactory,
            owner = this,
            arguments = arguments,
            searchText = navArgs.searchText
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return context?.compose {
            SearchResultsScreen(
                contract = contract(viewModel.store),
                navigator = SearchOrganizationResultsNavigator(findNavController()),
                title = R.string.common_organizations,
            ) { item, _ ->
                SearchOrganizationResultItem(organization = item, modifier = Modifier.clickable { notImplemented(this) })
            }
        }
    }
}
