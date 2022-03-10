package io.github.gmvalentino8.github.sample.presentation.core.components

import io.github.gmvalentino8.github.sample.presentation.core.contract.Event
import io.github.gmvalentino8.github.sample.presentation.core.contract.Intent
import io.github.gmvalentino8.github.sample.presentation.core.contract.State
import io.github.gmvalentino8.github.sample.presentation.core.contract.ViewState
import kotlinx.coroutines.flow.StateFlow

/**
 * Store
 *
 * The store exposes a stream of [State] and a stream of [Event] for the client to react to.
 */
interface Store<I : Intent, VS : ViewState, E : Event> {
    /**
     * State
     *
     * Stream of [State] exposed to the client
     */
    val state: StateFlow<State<VS, E>>

    /**
     * Dispatch
     *
     * Dispatches an [Intent]
     */
    fun dispatch(intent: I)

    /**
     * Dispose
     *
     * Cancels all jobs within the store
     */
    fun dispose()
}
