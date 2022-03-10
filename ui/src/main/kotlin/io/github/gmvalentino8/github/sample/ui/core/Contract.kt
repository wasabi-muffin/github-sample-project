package io.github.gmvalentino8.github.sample.ui.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import io.github.gmvalentino8.github.sample.presentation.core.components.Store
import io.github.gmvalentino8.github.sample.presentation.core.contract.Event
import io.github.gmvalentino8.github.sample.presentation.core.contract.Intent
import io.github.gmvalentino8.github.sample.presentation.core.contract.ViewState

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
