package jp.co.yumemi.android.code_check.core

import androidx.lifecycle.SavedStateHandle
import jp.co.yumemi.android.code_check.presentation.core.contract.Event
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.contract.ViewState

private const val StateKey = "StateKey"
private const val EventKey = "EventKey"
private const val EventsKey = "EventsKey"

fun <VS : ViewState, E : Event> SavedStateHandle.saveState(state: State<VS, E>) {
    set(StateKey, state.viewState)
    set(EventKey, state.event)
    set(EventsKey, state.events)
}

fun <VS : ViewState, E : Event> SavedStateHandle.getState(): State<VS, E>? {
    return get<VS>(StateKey)?.let { viewState ->
        get<List<E>>(EventsKey)?.let { events ->
            State(viewState, get(EventKey), events)
        }
    }
}

fun SavedStateHandle.hasState(): Boolean = contains(StateKey) && contains(EventsKey)

fun SavedStateHandle.onInit(block: () -> Unit) {
    if (!hasState()) block()
}
