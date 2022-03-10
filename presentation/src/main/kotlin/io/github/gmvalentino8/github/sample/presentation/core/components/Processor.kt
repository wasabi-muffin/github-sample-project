package io.github.gmvalentino8.github.sample.presentation.core.components

import io.github.gmvalentino8.github.sample.presentation.core.contract.Action
import io.github.gmvalentino8.github.sample.presentation.core.contract.Event
import io.github.gmvalentino8.github.sample.presentation.core.contract.Result
import io.github.gmvalentino8.github.sample.presentation.core.contract.State
import io.github.gmvalentino8.github.sample.presentation.core.contract.ViewState
import kotlinx.coroutines.flow.Flow

/**
 * Processor
 *
 * Processors receives [Action] from the [Interpreter] and processes it
 */
fun interface Processor<A : Action, R : Result, VS : ViewState, E : Event> {
    /**
     * Process
     *
     * Execute an [Action] given a current [State] and returns a stream of [Result]
     *
     * Side-effects should be processed here (i.e. Usecases, Repository)
     */
    suspend fun process(action: A, state: State<VS, E>): Flow<R>
}
