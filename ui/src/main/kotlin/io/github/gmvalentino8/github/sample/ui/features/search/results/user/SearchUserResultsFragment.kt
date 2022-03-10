package io.github.gmvalentino8.github.sample.ui.features.search.results.user

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
import io.github.gmvalentino8.github.sample.ui.R
import io.github.gmvalentino8.github.sample.ui.components.search.SearchUserResultItem
import io.github.gmvalentino8.github.sample.ui.core.contract
import io.github.gmvalentino8.github.sample.ui.features.search.results.SearchResultsScreen
import io.github.gmvalentino8.github.sample.ui.utils.compose
import io.github.gmvalentino8.github.sample.ui.utils.notImplemented

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return context?.compose {
            SearchResultsScreen(
                contract = contract(viewModel.store),
                navigator = SearchUserResultsNavigator(findNavController()),
                title = R.string.common_people,
            ) { item, _ ->
                SearchUserResultItem(user = item, modifier = Modifier.clickable { notImplemented(this) })
            }
        }
    }
}
