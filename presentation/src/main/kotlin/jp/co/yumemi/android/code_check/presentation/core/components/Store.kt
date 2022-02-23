package jp.co.yumemi.android.code_check.presentation.core.components

import jp.co.yumemi.android.code_check.presentation.core.contract.Event
import jp.co.yumemi.android.code_check.presentation.core.contract.Intent
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.contract.ViewState
import kotlinx.coroutines.flow.StateFlow

/**
 * The store exposes a stream of [State] and a stream of [Event] for the client to react to.
 */
interface Store<I : Intent, VS : ViewState, E : Event> {
    /**
     * Stream of [State] exposed to the client
     */
    val state: StateFlow<State<VS, E>>

    /**
     * Dispatches an [Intent]
     */
    fun dispatch(intent: I)

    /**
     * Cancels all jobs within the store
     */
    fun dispose()
}
