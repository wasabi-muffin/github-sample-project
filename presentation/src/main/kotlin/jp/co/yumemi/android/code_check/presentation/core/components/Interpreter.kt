package jp.co.yumemi.android.code_check.presentation.core.components

import jp.co.yumemi.android.code_check.presentation.core.contract.Action
import jp.co.yumemi.android.code_check.presentation.core.contract.Event
import jp.co.yumemi.android.code_check.presentation.core.contract.Intent
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.contract.ViewState

/**
 * Interpreter
 *
 * Interpreters receive [Intent] from user input and maps it to an [Action]
 */
fun interface Interpreter<in I : Intent, out A : Action, VS : ViewState, E : Event> {
    suspend fun interpret(intent: I, state: State<VS, E>): A?
}
