package jp.co.yumemi.android.code_check.ui.features.search.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import jp.co.yumemi.android.code_check.ui.core.compose

class SearchTopFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return requireContext().compose {
            SearchTopScreen(navigator = SearchTopNavigator(findNavController()))
        }
    }
}
