package jp.co.yumemi.android.code_check.ui.core

import androidx.lifecycle.ViewModel
import jp.co.yumemi.android.code_check.presentation.core.components.Store
import jp.co.yumemi.android.code_check.presentation.core.contract.Action
import jp.co.yumemi.android.code_check.presentation.core.contract.Event
import jp.co.yumemi.android.code_check.presentation.core.contract.Intent
import jp.co.yumemi.android.code_check.presentation.core.contract.Result
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.contract.ViewState
import jp.co.yumemi.android.code_check.presentation.core.factory.StoreFactory
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
