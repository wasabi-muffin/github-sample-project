package io.github.gmvalentino8.github.sample.domain.utils

import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async

/**
 * Async get or null
 *
 * Helper function that asynchronously perferms a [block] and returns the result if success and null if failure
 *
 * @return [Deferred] result if success and null if failure
 */
fun <T> CoroutineScope.asyncGetOrNull(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> T
): Deferred<T?> = async(context, start) {
    runCatching {
        block()
    }.getOrNull()
}
