package jp.co.yumemi.android.code_check.ui.features.search.results

import androidx.compose.runtime.Composable
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsEvent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsIntent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsViewState
import jp.co.yumemi.android.code_check.ui.core.Contract
import jp.co.yumemi.android.code_check.ui.core.handle

@Composable
fun SearchRepoResultsScreen(
    contract: Contract<SearchRepoResultsIntent, SearchRepoResultsViewState, SearchRepoResultsEvent>,
    navigator: SearchRepoResultsNavigator
) {
    val (state, events, dispatch) = contract

    events?.handle(
        process = { dispatch(SearchRepoResultsIntent.ProcessEvent(it)) }
    ) { event ->
        when (event) {
            is SearchRepoResultsEvent.NavigateBack -> TODO()
            is SearchRepoResultsEvent.NavigateDetails -> TODO()
        }
    }
}
