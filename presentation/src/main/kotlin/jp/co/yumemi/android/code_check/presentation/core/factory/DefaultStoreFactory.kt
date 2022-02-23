package jp.co.yumemi.android.code_check.presentation.core.factory

import jp.co.yumemi.android.code_check.presentation.core.components.DefaultStore
import jp.co.yumemi.android.code_check.presentation.core.components.Interpreter
import jp.co.yumemi.android.code_check.presentation.core.components.Processor
import jp.co.yumemi.android.code_check.presentation.core.components.Reducer
import jp.co.yumemi.android.code_check.presentation.core.components.Store
import jp.co.yumemi.android.code_check.presentation.core.contract.Action
import jp.co.yumemi.android.code_check.presentation.core.contract.Event
import jp.co.yumemi.android.code_check.presentation.core.contract.Intent
import jp.co.yumemi.android.code_check.presentation.core.contract.Result
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.contract.ViewState
import jp.co.yumemi.android.code_check.presentation.core.middleware.Middleware

class DefaultStoreFactory<I : Intent, A : Action, R : Result, VS : ViewState, E : Event>(
    private val interpreter: Interpreter<I, A, VS, E>,
    private val processor: Processor<A, R, VS, E>,
    private val reducer: Reducer<R, VS, E>,
) : StoreFactory<I, A, R, VS, E> {
    override fun create(initialState: State<VS, E>, middlewares: List<Middleware>): Store<I, VS, E> = DefaultStore(
        initialState = initialState,
        interpreter = interpreter,
        processor = processor,
        reducer = reducer,
        middlewares = middlewares
    )
}
