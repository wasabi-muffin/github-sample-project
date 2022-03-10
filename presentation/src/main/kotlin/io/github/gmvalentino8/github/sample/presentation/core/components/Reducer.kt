package io.github.gmvalentino8.github.sample.presentation.core.components

import io.github.gmvalentino8.github.sample.presentation.core.contract.Event
import io.github.gmvalentino8.github.sample.presentation.core.contract.Result
import io.github.gmvalentino8.github.sample.presentation.core.contract.State
import io.github.gmvalentino8.github.sample.presentation.core.contract.ViewState

/**
 * Reducer
 *
 * [Reducer] receives [Result]s from the [Processor] and creates a new [State]
 */
fun interface Reducer<in R : Result, VS : ViewState, E : Event> {
    /**
     * Reduce
     *
     * A pure function that applies a [Result] to the current [State] and returns a new [State]
     */
    suspend fun reduce(result: R, state: State<VS, E>): State<VS, E>?
}
