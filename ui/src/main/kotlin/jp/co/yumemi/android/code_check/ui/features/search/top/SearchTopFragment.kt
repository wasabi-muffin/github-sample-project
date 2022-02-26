package jp.co.yumemi.android.code_check.ui.features.search.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.android.code_check.ui.utils.compose
import jp.co.yumemi.android.code_check.ui.core.contract

@AndroidEntryPoint
class SearchTopFragment : Fragment() {
    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return requireContext().compose {
            SearchTopScreen(contract = contract(viewModel.store), navigator = SearchTopNavigator(findNavController()))
        }
    }
}
