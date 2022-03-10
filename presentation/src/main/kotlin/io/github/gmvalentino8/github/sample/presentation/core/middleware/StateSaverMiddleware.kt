package io.github.gmvalentino8.github.sample.presentation.core.middleware

import io.github.gmvalentino8.github.sample.presentation.core.contract.Event
import io.github.gmvalentino8.github.sample.presentation.core.contract.State
import io.github.gmvalentino8.github.sample.presentation.core.contract.ViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

/**
 * State saver middleware
 *
 * Middleware to persist state upon process death
 */
class StateSaverMiddleware<VS : ViewState, E : Event>(
    private val save: (state: State<VS, E>) -> Unit,
) : StateMiddleware<VS, E> {
    override fun modifyStates(input: Flow<State<VS, E>>): Flow<State<VS, E>> = input.onEach { state ->
        save(state)
    }
}
