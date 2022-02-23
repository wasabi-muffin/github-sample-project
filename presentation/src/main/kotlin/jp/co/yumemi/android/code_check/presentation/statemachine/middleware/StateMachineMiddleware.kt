package jp.co.yumemi.android.code_check.presentation.statemachine.middleware

import jp.co.yumemi.android.code_check.presentation.R
import jp.co.yumemi.android.code_check.presentation.core.contract.Action
import jp.co.yumemi.android.code_check.presentation.core.contract.Event
import jp.co.yumemi.android.code_check.presentation.core.contract.Intent
import jp.co.yumemi.android.code_check.presentation.core.contract.ProcessEventResult
import jp.co.yumemi.android.code_check.presentation.core.contract.Result
import jp.co.yumemi.android.code_check.presentation.core.contract.SendEventResult
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.contract.ViewState
import jp.co.yumemi.android.code_check.presentation.core.middleware.ActionMiddleware
import jp.co.yumemi.android.code_check.presentation.core.middleware.IntentMiddleware
import jp.co.yumemi.android.code_check.presentation.core.middleware.ResultMiddleware
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachine
import jp.co.yumemi.android.code_check.presentation.statemachine.contract.SideEffect
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filter

class StateMachineMiddleware<I : Intent, A : Action, R : Result, VS : ViewState, E : Event, SE : SideEffect>(
    private val stateMachine: StateMachine<I, A, R, VS, E, SE>,
    private val log: ((String) -> Unit)? = null
) : IntentMiddleware<I, VS, E>, ActionMiddleware<A, VS, E>, ResultMiddleware<R, VS, E> {
    override fun modifyIntents(input: Flow<I>, state: StateFlow<State<VS, E>>): Flow<I> = input.filter { intent ->
        stateMachine.graph
            .filterKeys { keys -> keys.matches(state.value.viewState) }.values
            .flatMap { node -> node.intents.keys }
            .any { intentMatcher -> intentMatcher.matches(intent) }
            .also { isValid ->
                if (!isValid) log?.invoke("Invalid transition:\nState: ${state.value::class.qualifiedName}\nIntent: ${intent::class.qualifiedName}")
            }
    }

    override fun modifyActions(input: Flow<A>, state: StateFlow<State<VS, E>>): Flow<A> = input.filter { action ->
        stateMachine.graph
            .filterKeys { keys -> keys.matches(state.value.viewState) }.values
            .flatMap { node -> node.actions.keys }
            .any { actionMatcher -> actionMatcher.matches(action) }
            .also { isValid ->
                if (!isValid) log?.invoke("Invalid transition:\nState: ${state.value::class.qualifiedName}\nAction: ${action::class.qualifiedName}")
            }
    }

    override fun modifyResults(input: Flow<R>, state: StateFlow<State<VS, E>>): Flow<R> = input.filter { result ->
        result is SendEventResult<*> || result is ProcessEventResult<*> || stateMachine.graph
            .filterKeys { keys -> keys.matches(state.value.viewState) }.values
            .flatMap { node -> node.transitions.entries }
            .any { resultMatcher -> resultMatcher.key.matches(result) }
            .also { isValid ->
                if (!isValid) log?.invoke("Invalid transition:\nState: ${state.value::class.qualifiedName}\nResult: ${result::class.qualifiedName}")
            }
    }
}
