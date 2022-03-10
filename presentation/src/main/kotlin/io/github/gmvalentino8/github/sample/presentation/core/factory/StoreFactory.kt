package io.github.gmvalentino8.github.sample.presentation.core.factory

import io.github.gmvalentino8.github.sample.presentation.core.components.Store
import io.github.gmvalentino8.github.sample.presentation.core.contract.Action
import io.github.gmvalentino8.github.sample.presentation.core.contract.Event
import io.github.gmvalentino8.github.sample.presentation.core.contract.Intent
import io.github.gmvalentino8.github.sample.presentation.core.contract.Result
import io.github.gmvalentino8.github.sample.presentation.core.contract.State
import io.github.gmvalentino8.github.sample.presentation.core.contract.ViewState
import io.github.gmvalentino8.github.sample.presentation.core.middleware.Middleware

/**
 * Store factory
 *
 * Creates a store
 */
interface StoreFactory<I : Intent, A : Action, R : Result, VS : ViewState, E : Event> {
    fun create(initialState: State<VS, E>, middlewares: List<Middleware> = emptyList()): Store<I, VS, E>
}
