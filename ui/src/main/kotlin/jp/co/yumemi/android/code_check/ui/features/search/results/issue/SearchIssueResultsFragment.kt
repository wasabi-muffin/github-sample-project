package jp.co.yumemi.android.code_check.ui.features.search.results.issue

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
import jp.co.yumemi.android.code_check.ui.components.search.SearchIssueResultItem
import jp.co.yumemi.android.code_check.ui.core.contract
import jp.co.yumemi.android.code_check.ui.features.search.results.SearchResultsScreen
import jp.co.yumemi.android.code_check.ui.features.search.results.issue.SearchIssueResultsViewModel
import jp.co.yumemi.android.code_check.ui.utils.compose

@AndroidEntryPoint
class SearchIssueResultsFragment : Fragment() {
    @Inject lateinit var assistedFactory: SearchIssueResultsViewModel.Factory
    private val navArgs: SearchIssueResultsFragmentArgs by navArgs()
    private val viewModel: SearchIssueResultsViewModel by viewModels {
        SearchIssueResultsViewModel.provideFactory(
            assistedFactory = assistedFactory,
            owner = this,
            arguments = arguments,
            searchText = navArgs.searchText
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return requireContext().compose {
            SearchResultsScreen(
                contract = contract(viewModel.store),
                navigator = SearchIssueResultsNavigator(findNavController()),
                title = R.string.common_issues,
            ) { item, onClick ->
                SearchIssueResultItem(issue = item, modifier = Modifier.clickable { onClick(item) })
            }
        }
    }
}
