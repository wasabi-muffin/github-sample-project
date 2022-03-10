package io.github.gmvalentino8.github.sample.presentation.statemachine.components

import io.github.gmvalentino8.github.sample.presentation.core.components.Processor
import io.github.gmvalentino8.github.sample.presentation.core.contract.Action
import io.github.gmvalentino8.github.sample.presentation.core.contract.Event
import io.github.gmvalentino8.github.sample.presentation.core.contract.Intent
import io.github.gmvalentino8.github.sample.presentation.core.contract.Result
import io.github.gmvalentino8.github.sample.presentation.core.contract.State
import io.github.gmvalentino8.github.sample.presentation.core.contract.ViewState
import io.github.gmvalentino8.github.sample.presentation.statemachine.contract.SideEffect
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flowOf

/**
 * State machine processor
 *
 * Uses a state machine graph to create a [Processor]
 */
@FlowPreview
abstract class StateMachineProcessor<I : Intent, A : Action, R : Result, VS : ViewState, E : Event, SE : SideEffect>(
    private val stateMachine: StateMachine<I, A, R, VS, E, SE>,
) : Processor<A, R, VS, E> {
    @Suppress("UNCHECKED_CAST")
    override suspend fun process(
        action: A,
        state: State<VS, E>,
    ): Flow<R> = stateMachine.graph
        .filterKeys { key -> key.matches(state.viewState) }.values
        .flatMap { stateNode -> stateNode.actions.entries }
        .find { actionMatcher -> actionMatcher.key.matches(action) }?.value
        ?.asFlow()
        ?.flatMapMerge { node ->
            when (node) {
                is StateMachine.ActionNode.ResultNode<A, *, VS> -> flowOf(node.value(state.viewState, action) as? R)
                is StateMachine.ActionNode.SideEffectNode<A, *, VS> -> (node.value(state.viewState, action) as? SE)?.let { process(it, state) }
                    ?: flowOf()
            }
        }
        ?.filterNotNull()
        ?: flowOf()

    abstract suspend fun process(sideEffect: SE, state: State<VS, E>): Flow<R?>
}
