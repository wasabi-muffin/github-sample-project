package io.github.gmvalentino8.github.sample.ui.core

import androidx.lifecycle.ViewModel
import io.github.gmvalentino8.github.sample.presentation.core.components.Store
import io.github.gmvalentino8.github.sample.presentation.core.contract.Action
import io.github.gmvalentino8.github.sample.presentation.core.contract.Event
import io.github.gmvalentino8.github.sample.presentation.core.contract.Intent
import io.github.gmvalentino8.github.sample.presentation.core.contract.Result
import io.github.gmvalentino8.github.sample.presentation.core.contract.State
import io.github.gmvalentino8.github.sample.presentation.core.contract.ViewState
import io.github.gmvalentino8.github.sample.presentation.core.factory.StoreFactory
import kotlinx.coroutines.flow.StateFlow

abstract class StoreViewModel<I : Intent, A : Action, R : Result, VS : ViewState, E : Event>(
    private val storeFactory: StoreFactory<I, A, R, VS, E>,
) : ViewModel(), Store<I, VS, E> {
    abstract val store: Store<I, VS, E>
    override val state: StateFlow<State<VS, E>> get() = store.state

    override fun dispatch(intent: I) {
        store.dispatch(intent)
    }

    override fun dispose() {
        store.dispose()
    }

    override fun onCleared() {
        store.dispose()
        super.onCleared()
    }
}
