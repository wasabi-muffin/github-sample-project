package jp.co.yumemi.android.code_check.ui.features.details.repo

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
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.ui.utils.compose
import jp.co.yumemi.android.code_check.ui.core.contract
import jp.co.yumemi.android.code_check.ui.features.search.results.SearchRepoResultsFragmentArgs

@AndroidEntryPoint
class RepoDetailsFragment : Fragment() {
    @Inject lateinit var assistedFactory: RepoDetailsViewModel.Factory
    private val navArgs: RepoDetailsFragmentArgs by navArgs()
    private val viewModel: RepoDetailsViewModel by viewModels {
        RepoDetailsViewModel.provideFactory(
            assistedFactory = assistedFactory,
            owner = this,
            arguments = arguments,
            repository = navArgs.repository
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return requireContext().compose {
            RepoDetailsScreen(contract = contract(viewModel.store), navigator = RepoDetailsNavigator(findNavController()))
        }
    }
}
