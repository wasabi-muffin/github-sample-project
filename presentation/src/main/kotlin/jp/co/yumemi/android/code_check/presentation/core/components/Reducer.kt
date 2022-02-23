package jp.co.yumemi.android.code_check.presentation.core.components

import jp.co.yumemi.android.code_check.presentation.core.contract.Event
import jp.co.yumemi.android.code_check.presentation.core.contract.Result
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.contract.ViewState

/**
 * [Reducer] receives [Result]s from the [Processor] and creates a new [State]
 */
fun interface Reducer<in R : Result, VS : ViewState, E : Event> {
    /**
     * A pure function that applies a [Result] to the current [State] and returns a new [State]
     */
    suspend fun reduce(result: R, state: State<VS, E>): State<VS, E>?
}
