package io.github.gmvalentino8.github.sample.presentation.core.factory

import io.github.gmvalentino8.github.sample.presentation.core.components.DefaultStore
import io.github.gmvalentino8.github.sample.presentation.core.components.Interpreter
import io.github.gmvalentino8.github.sample.presentation.core.components.Processor
import io.github.gmvalentino8.github.sample.presentation.core.components.Reducer
import io.github.gmvalentino8.github.sample.presentation.core.components.Store
import io.github.gmvalentino8.github.sample.presentation.core.contract.Action
import io.github.gmvalentino8.github.sample.presentation.core.contract.Event
import io.github.gmvalentino8.github.sample.presentation.core.contract.Intent
import io.github.gmvalentino8.github.sample.presentation.core.contract.Result
import io.github.gmvalentino8.github.sample.presentation.core.contract.State
import io.github.gmvalentino8.github.sample.presentation.core.contract.ViewState
import io.github.gmvalentino8.github.sample.presentation.core.middleware.Middleware

/**
 * Default store factory
 *
 * Default implementation of a store factory
 */
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
