package io.github.gmvalentino8.github.sample.presentation.core.components

import io.github.gmvalentino8.github.sample.presentation.core.contract.Action
import io.github.gmvalentino8.github.sample.presentation.core.contract.Event
import io.github.gmvalentino8.github.sample.presentation.core.contract.Intent
import io.github.gmvalentino8.github.sample.presentation.core.contract.State
import io.github.gmvalentino8.github.sample.presentation.core.contract.ViewState

/**
 * Interpreter
 *
 * Interpreters receive [Intent] from user input and maps it to an [Action]
 */
fun interface Interpreter<in I : Intent, out A : Action, VS : ViewState, E : Event> {
    suspend fun interpret(intent: I, state: State<VS, E>): A?
}
