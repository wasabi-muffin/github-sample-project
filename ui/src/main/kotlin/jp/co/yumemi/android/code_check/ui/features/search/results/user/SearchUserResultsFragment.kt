package jp.co.yumemi.android.code_check.ui.features.search.results.user

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
import jp.co.yumemi.android.code_check.ui.components.search.SearchUserResultItem
import jp.co.yumemi.android.code_check.ui.core.contract
import jp.co.yumemi.android.code_check.ui.features.search.results.SearchResultsScreen
import jp.co.yumemi.android.code_check.ui.utils.compose
import jp.co.yumemi.android.code_check.ui.utils.notImplemented

@AndroidEntryPoint
class SearchUserResultsFragment : Fragment() {
    @Inject lateinit var assistedFactory: SearchUserResultsViewModel.Factory
    private val navArgs: SearchUserResultsFragmentArgs by navArgs()
    private val viewModel: SearchUserResultsViewModel by viewModels {
        SearchUserResultsViewModel.provideFactory(
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
                navigator = SearchUserResultsNavigator(findNavController()),
                title = R.string.common_people,
            ) { item, _ ->
                SearchUserResultItem(user = item, modifier = Modifier.clickable { notImplemented(requireContext()) })
            }
        }
    }
}
