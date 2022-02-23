package jp.co.yumemi.android.code_check.presentation.statemachine.factory

import jp.co.yumemi.android.code_check.presentation.core.components.DefaultStore
import jp.co.yumemi.android.code_check.presentation.core.components.Store
import jp.co.yumemi.android.code_check.presentation.core.contract.Action
import jp.co.yumemi.android.code_check.presentation.core.contract.Event
import jp.co.yumemi.android.code_check.presentation.core.contract.Intent
import jp.co.yumemi.android.code_check.presentation.core.contract.Result
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.contract.ViewState
import jp.co.yumemi.android.code_check.presentation.core.factory.StoreFactory
import jp.co.yumemi.android.code_check.presentation.core.middleware.Middleware
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachine
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachineInterpreter
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachineProcessor
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachineReducer
import jp.co.yumemi.android.code_check.presentation.statemachine.contract.SideEffect
import jp.co.yumemi.android.code_check.presentation.statemachine.middleware.StateMachineMiddleware
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

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
