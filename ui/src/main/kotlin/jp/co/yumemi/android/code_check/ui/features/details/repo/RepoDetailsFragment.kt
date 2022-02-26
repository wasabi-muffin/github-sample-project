package jp.co.yumemi.android.code_check.ui.features.details.repo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.ui.core.compose
import jp.co.yumemi.android.code_check.ui.core.contract

@AndroidEntryPoint
class RepoDetailsFragment : Fragment() {
    @Inject lateinit var assistedFactory: RepoDetailsViewModel.Factory
    private val viewModel: RepoDetailsViewModel by viewModels {
        RepoDetailsViewModel.provideFactory(
            assistedFactory = assistedFactory,
            owner = this,
            arguments = arguments,
            repository = Repository(
                id = 0,
                name = "gmvalentino8/cyklone",
                description = null,
                owner = null,
                homepage = null,
                language = null,
                stargazersCount = 10,
                watchersCount = 1300,
                forksCount = 100,
                openIssuesCount = 123345,
                license = null
            )
        ) // TODO: Fix placeholder
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return requireContext().compose {
            RepoDetailsScreen(contract = contract(viewModel.store), navigator = RepoDetailsNavigator(findNavController()))
        }
    }
}
