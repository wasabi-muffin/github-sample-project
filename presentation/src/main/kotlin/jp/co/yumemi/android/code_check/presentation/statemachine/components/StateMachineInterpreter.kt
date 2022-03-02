package jp.co.yumemi.android.code_check.presentation.statemachine.components

import jp.co.yumemi.android.code_check.presentation.core.components.Interpreter
import jp.co.yumemi.android.code_check.presentation.core.contract.Action
import jp.co.yumemi.android.code_check.presentation.core.contract.Event
import jp.co.yumemi.android.code_check.presentation.core.contract.Intent
import jp.co.yumemi.android.code_check.presentation.core.contract.Result
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.contract.ViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.contract.SideEffect

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
