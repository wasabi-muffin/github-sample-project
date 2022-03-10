package io.github.gmvalentino8.github.sample.ui.features.search.results.repository

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
import io.github.gmvalentino8.github.sample.ui.components.search.SearchRepositoryResultItem
import io.github.gmvalentino8.github.sample.ui.core.contract
import io.github.gmvalentino8.github.sample.ui.features.search.results.SearchResultsScreen
import io.github.gmvalentino8.github.sample.ui.utils.compose

@AndroidEntryPoint
class SearchRepositoryResultsFragment : Fragment() {
    @Inject lateinit var assistedFactory: SearchRepositoryResultsViewModel.Factory
    private val navArgs: SearchRepositoryResultsFragmentArgs by navArgs()
    private val viewModel: SearchRepositoryResultsViewModel by viewModels {
        SearchRepositoryResultsViewModel.provideFactory(
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
                navigator = SearchRepositoryResultsNavigator(findNavController()),
                title = R.string.common_repositories,
            ) { item, onClick ->
                SearchRepositoryResultItem(repository = item, modifier = Modifier.clickable { onClick(item) })
            }
        }
    }
}
