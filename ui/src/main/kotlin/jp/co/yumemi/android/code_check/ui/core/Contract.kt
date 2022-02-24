package jp.co.yumemi.android.code_check.ui.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import jp.co.yumemi.android.code_check.presentation.core.components.Store
import jp.co.yumemi.android.code_check.presentation.core.contract.Event
import jp.co.yumemi.android.code_check.presentation.core.contract.Intent
import jp.co.yumemi.android.code_check.presentation.core.contract.ViewState

data class Contract<I : Intent, VS : ViewState, E : Event>(
    val state: VS,
    val events: E?,
    val dispatch: (I) -> Unit,
)

@Composable
inline fun <reified INTENT : Intent, STATE : ViewState, EVENT : Event> contract(
    store: Store<INTENT, STATE, EVENT>,
): Contract<INTENT, STATE, EVENT> {
    val state by store.state.collectAsState()

    return Contract(
        state = state.viewState,
        events = state.event,
        dispatch = { store.dispatch(it) }
    )
}
