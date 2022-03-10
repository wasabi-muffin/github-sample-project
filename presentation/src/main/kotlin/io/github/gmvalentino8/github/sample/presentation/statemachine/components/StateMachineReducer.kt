package io.github.gmvalentino8.github.sample.presentation.statemachine.components

import io.github.gmvalentino8.github.sample.presentation.core.components.Reducer
import io.github.gmvalentino8.github.sample.presentation.core.contract.Action
import io.github.gmvalentino8.github.sample.presentation.core.contract.Event
import io.github.gmvalentino8.github.sample.presentation.core.contract.Intent
import io.github.gmvalentino8.github.sample.presentation.core.contract.ProcessEventResult
import io.github.gmvalentino8.github.sample.presentation.core.contract.Result
import io.github.gmvalentino8.github.sample.presentation.core.contract.SendEventResult
import io.github.gmvalentino8.github.sample.presentation.core.contract.State
import io.github.gmvalentino8.github.sample.presentation.core.contract.ViewState
import io.github.gmvalentino8.github.sample.presentation.statemachine.contract.SideEffect

/**
 * State machine reducer
 *
 * Uses a state machine graph to create a [Reducer]
 */
open class StateMachineReducer<I : Intent, A : Action, R : Result, VS : ViewState, E : Event, SE : SideEffect>(
    private val stateMachine: StateMachine<I, A, R, VS, E, SE>,
) : Reducer<R, VS, E> {
    @Suppress("UNCHECKED_CAST")
    override suspend fun reduce(result: R, state: State<VS, E>): State<VS, E>? = when (result) {
        is SendEventResult<*> -> state.send(result.event as E)
        is ProcessEventResult<*> -> state.process(result.event as E)
        else ->
            stateMachine.graph
                .filterKeys { key -> key.matches(state.viewState) }.values
                .flatMap { stateNode -> stateNode.transitions.entries }
                .find { resultMatcher -> resultMatcher.key.matches(result) }
                ?.value?.invoke(state.viewState, result)
                ?.let { state.copy(viewState = it) }
    }
}
