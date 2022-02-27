package jp.co.yumemi.android.code_check.ui.features.search.results

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import jp.co.yumemi.android.code_check.ui.core.contract
import jp.co.yumemi.android.code_check.ui.utils.compose

@AndroidEntryPoint
class SearchRepoResultsFragment : Fragment() {
    @Inject lateinit var assistedFactory: SearchRepoResultsViewModel.Factory
    private val navArgs: SearchRepoResultsFragmentArgs by navArgs()
    private val viewModel: SearchRepoResultsViewModel by viewModels {
        SearchRepoResultsViewModel.provideFactory(
            assistedFactory = assistedFactory,
            owner = this,
            arguments = arguments,
            searchText = navArgs.searchText
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return requireContext().compose {
            SearchRepoResultsScreen(contract = contract(viewModel.store), navigator = SearchRepoResultsNavigator(findNavController()))
        }
    }
}
