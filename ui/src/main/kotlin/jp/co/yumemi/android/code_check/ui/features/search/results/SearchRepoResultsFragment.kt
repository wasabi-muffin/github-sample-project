package jp.co.yumemi.android.code_check.ui.features.search.results

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.*
import androidx.compose.ui.Modifier
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import jp.co.yumemi.android.code_check.ui.components.search.SearchRepoResultItem
import jp.co.yumemi.android.code_check.ui.core.contract
import jp.co.yumemi.android.code_check.ui.utils.compose

@AndroidEntryPoint
class SearchRepoResultsFragment : Fragment() {
    @Inject lateinit var assistedFactory: SearchRepositoryResultsViewModel.Factory
    private val navArgs: SearchRepoResultsFragmentArgs by navArgs()
    private val viewModel: SearchRepositoryResultsViewModel by viewModels {
        SearchRepositoryResultsViewModel.provideFactory(
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
                navigator = SearchRepositoryResultsNavigator(findNavController())
            ) { item, onClick ->
                SearchRepoResultItem(repository = item, modifier = Modifier.clickable { onClick(item) })
            }
        }
    }
}
