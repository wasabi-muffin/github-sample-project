package io.github.gmvalentino8.github.sample.presentation.statemachine.components

import io.github.gmvalentino8.github.sample.presentation.core.components.Interpreter
import io.github.gmvalentino8.github.sample.presentation.core.contract.Action
import io.github.gmvalentino8.github.sample.presentation.core.contract.Event
import io.github.gmvalentino8.github.sample.presentation.core.contract.Intent
import io.github.gmvalentino8.github.sample.presentation.core.contract.Result
import io.github.gmvalentino8.github.sample.presentation.core.contract.State
import io.github.gmvalentino8.github.sample.presentation.core.contract.ViewState
import io.github.gmvalentino8.github.sample.presentation.statemachine.contract.SideEffect

/**
 * State machine interpreter
 *
 * Uses a state machine graph to create an [Interpreter]
 */
open class StateMachineInterpreter<I : Intent, A : Action, R : Result, VS : ViewState, E : Event, SE : SideEffect>(
    private val stateMachine: StateMachine<I, A, R, VS, E, SE>
) : Interpreter<I, A, VS, E> {
    override suspend fun interpret(intent: I, state: State<VS, E>): A? = stateMachine.graph
        .filterKeys { key -> key.matches(state.viewState) }.values
        .flatMap { stateNode -> stateNode.intents.entries }
        .find { intentMatcher -> intentMatcher.key.matches(intent) }
        ?.value?.invoke(state.viewState, intent)
}
