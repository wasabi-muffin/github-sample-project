package jp.co.yumemi.android.code_check.presentation.statemachine.components

import jp.co.yumemi.android.code_check.presentation.core.components.Reducer
import jp.co.yumemi.android.code_check.presentation.core.contract.Action
import jp.co.yumemi.android.code_check.presentation.core.contract.Event
import jp.co.yumemi.android.code_check.presentation.core.contract.Intent
import jp.co.yumemi.android.code_check.presentation.core.contract.ProcessEventResult
import jp.co.yumemi.android.code_check.presentation.core.contract.Result
import jp.co.yumemi.android.code_check.presentation.core.contract.SendEventResult
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.contract.ViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.contract.SideEffect

open class StateMachineReducer<I : Intent, A : Action, R : Result, VS : ViewState, E : Event, SE : SideEffect>(
    private val stateMachine: StateMachine<I, A, R, VS, E, SE>,
) : Reducer<R, VS, E> {
    @Suppress("UNCHECKED_CAST")
    override suspend fun reduce(result: R, state: State<VS, E>): State<VS, E>? = when (result) {
        is SendEventResult<*> -> state.send(result.event as E)
        is ProcessEventResult<*> -> state.process(result.event as E)
        else -> stateMachine.graph
            .filterKeys { key -> key.matches(state.viewState) }.values
            .flatMap { stateNode -> stateNode.transitions.entries }
            .find { resultMatcher -> resultMatcher.key.matches(result) }
            ?.value?.invoke(state.viewState, result)
            ?.let { state.copy(viewState = it) }
    }
}
