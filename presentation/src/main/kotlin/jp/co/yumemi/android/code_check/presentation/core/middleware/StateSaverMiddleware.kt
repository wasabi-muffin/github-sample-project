package jp.co.yumemi.android.code_check.presentation.core.middleware

import jp.co.yumemi.android.code_check.presentation.core.contract.Event
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.contract.ViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class StateSaverMiddleware<VS : ViewState, E : Event>(
    private val save: (state: State<VS, E>) -> Unit,
) : StateMiddleware<VS, E> {
    override fun modifyStates(input: Flow<State<VS, E>>): Flow<State<VS, E>> = input.onEach { state ->
        save(state)
    }
}
