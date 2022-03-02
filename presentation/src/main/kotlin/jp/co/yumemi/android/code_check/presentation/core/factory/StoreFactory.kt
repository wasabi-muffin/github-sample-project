package jp.co.yumemi.android.code_check.presentation.core.factory

import jp.co.yumemi.android.code_check.presentation.core.components.Store
import jp.co.yumemi.android.code_check.presentation.core.contract.Action
import jp.co.yumemi.android.code_check.presentation.core.contract.Event
import jp.co.yumemi.android.code_check.presentation.core.contract.Intent
import jp.co.yumemi.android.code_check.presentation.core.contract.Result
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.contract.ViewState
import jp.co.yumemi.android.code_check.presentation.core.middleware.Middleware

/**
 * Store factory
 *
 * Creates a store
 */
interface StoreFactory<I : Intent, A : Action, R : Result, VS : ViewState, E : Event> {
    fun create(initialState: State<VS, E>, middlewares: List<Middleware> = emptyList()): Store<I, VS, E>
}
