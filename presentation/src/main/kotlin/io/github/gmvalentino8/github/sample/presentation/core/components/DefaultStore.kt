package io.github.gmvalentino8.github.sample.presentation.core.components

import io.github.gmvalentino8.github.sample.presentation.core.contract.Action
import io.github.gmvalentino8.github.sample.presentation.core.contract.Event
import io.github.gmvalentino8.github.sample.presentation.core.contract.Intent
import io.github.gmvalentino8.github.sample.presentation.core.contract.Result
import io.github.gmvalentino8.github.sample.presentation.core.contract.State
import io.github.gmvalentino8.github.sample.presentation.core.contract.ViewState
import io.github.gmvalentino8.github.sample.presentation.core.middleware.ActionMiddleware
import io.github.gmvalentino8.github.sample.presentation.core.middleware.IntentMiddleware
import io.github.gmvalentino8.github.sample.presentation.core.middleware.Middleware
import io.github.gmvalentino8.github.sample.presentation.core.middleware.ResultMiddleware
import io.github.gmvalentino8.github.sample.presentation.core.middleware.StateMiddleware
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.launch

/**
 * Default store
 *
 * Default implementation of a [Store] that provides unidirectional dataflow logic
 */
@FlowPreview
@ExperimentalCoroutinesApi
class DefaultStore<I : Intent, in A : Action, in R : Result, VS : ViewState, E : Event>(
    initialState: State<VS, E>,
    private val interpreter: Interpreter<I, A, VS, E>,
    private val processor: Processor<A, R, VS, E>,
    private val reducer: Reducer<R, VS, E>,
    private val middlewares: List<Middleware> = emptyList(),
    coroutineContext: CoroutineContext = Dispatchers.Main,
) : Store<I, VS, E> {
    private val scope = CoroutineScope(coroutineContext + Job())
    private val intents = MutableSharedFlow<I>(replay = Int.MAX_VALUE, extraBufferCapacity = Int.MAX_VALUE)
    private val _state = MutableStateFlow(initialState)
    override val state: StateFlow<State<VS, E>> = _state

    init {
        scope.launch {
            intents
                .intentMiddlewares(middlewares)
                .mapNotNull { intent -> interpreter.interpret(intent, _state.value) }
                .actionMiddlewares(middlewares)
                .flatMapMerge { action -> processor.process(action, _state.value) }
                .resultMiddlewares(middlewares)
                .mapNotNull { result -> reducer.reduce(result, _state.value) }
                .stateMiddlewares(middlewares)
                .collect { state -> _state.value = state }
        }
    }

    override fun dispatch(intent: I) {
        scope.launch { intents.emit(intent) }
    }

    override fun dispose() {
        scope.cancel()
    }

    /**
     * Intent middlewares
     *
     * Helper function to apply [IntentMiddleware]
     */
    private fun Flow<I>.intentMiddlewares(
        middlewares: List<Middleware>,
    ): Flow<I> = middlewares.filterIsInstance<IntentMiddleware<I, VS, E>>().fold(this) { intents, modifier ->
        modifier.modifyIntents(intents, _state)
    }

    /**
     * Action middlewares
     *
     * Helper function to apply [ActionMiddleware]
     */
    private fun Flow<A>.actionMiddlewares(
        middlewares: List<Middleware>,
    ): Flow<A> = middlewares.filterIsInstance<ActionMiddleware<A, VS, E>>().fold(this) { actions, modifier ->
        modifier.modifyActions(actions, _state)
    }

    /**
     * Result middlewares
     *
     * Helper function to apply [ResultMiddleware]
     */
    private fun Flow<R>.resultMiddlewares(
        middlewares: List<Middleware>,
    ): Flow<R> = middlewares.filterIsInstance<ResultMiddleware<R, VS, E>>().fold(this) { results, modifier ->
        modifier.modifyResults(results, _state)
    }

    /**
     * State middlewares
     *
     * Helper function to apply [StateMiddleware]
     */
    private fun Flow<State<VS, E>>.stateMiddlewares(
        middlewares: List<Middleware>,
    ): Flow<State<VS, E>> = middlewares.filterIsInstance<StateMiddleware<VS, E>>().fold(this) { states, modifier ->
        modifier.modifyStates(states)
    }
}
