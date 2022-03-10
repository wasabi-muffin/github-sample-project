package io.github.gmvalentino8.github.sample.presentation.statemachine.factory

import io.github.gmvalentino8.github.sample.presentation.core.components.DefaultStore
import io.github.gmvalentino8.github.sample.presentation.core.components.Store
import io.github.gmvalentino8.github.sample.presentation.core.contract.Action
import io.github.gmvalentino8.github.sample.presentation.core.contract.Event
import io.github.gmvalentino8.github.sample.presentation.core.contract.Intent
import io.github.gmvalentino8.github.sample.presentation.core.contract.Result
import io.github.gmvalentino8.github.sample.presentation.core.contract.State
import io.github.gmvalentino8.github.sample.presentation.core.contract.ViewState
import io.github.gmvalentino8.github.sample.presentation.core.factory.StoreFactory
import io.github.gmvalentino8.github.sample.presentation.core.middleware.Middleware
import io.github.gmvalentino8.github.sample.presentation.statemachine.components.StateMachine
import io.github.gmvalentino8.github.sample.presentation.statemachine.components.StateMachineInterpreter
import io.github.gmvalentino8.github.sample.presentation.statemachine.components.StateMachineProcessor
import io.github.gmvalentino8.github.sample.presentation.statemachine.components.StateMachineReducer
import io.github.gmvalentino8.github.sample.presentation.statemachine.contract.SideEffect
import io.github.gmvalentino8.github.sample.presentation.statemachine.middleware.StateMachineMiddleware
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

/**
 * State machine store factory
 *
 * Creates a store with a [StateMachine] and applies [StateMachineMiddleware]
 */
@FlowPreview
@ExperimentalCoroutinesApi
class StateMachineStoreFactory<I : Intent, A : Action, R : Result, VS : ViewState, E : Event, SE : SideEffect>(
    private val stateMachine: StateMachine<I, A, R, VS, E, SE>,
    private val processor: StateMachineProcessor<I, A, R, VS, E, SE>,
    private val logger: ((String) -> Unit)? = null
) : StoreFactory<I, A, R, VS, E> {
    override fun create(initialState: State<VS, E>, middlewares: List<Middleware>): Store<I, VS, E> {
        return DefaultStore(
            initialState = initialState,
            interpreter = StateMachineInterpreter(stateMachine),
            processor = processor,
            reducer = StateMachineReducer(stateMachine),
            middlewares = listOf(StateMachineMiddleware(stateMachine, logger)) + middlewares
        )
    }
}
