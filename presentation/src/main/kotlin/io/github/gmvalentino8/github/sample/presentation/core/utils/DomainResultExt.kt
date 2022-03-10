package io.github.gmvalentino8.github.sample.presentation.core.utils

import io.github.gmvalentino8.github.sample.domain.core.DomainError
import io.github.gmvalentino8.github.sample.domain.core.DomainResult
import io.github.gmvalentino8.github.sample.presentation.core.contract.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

/**
 * Process
 *
 * Extension to deconstruct [DomainResult] into a [Flow] with a single value
 */
internal fun <T, R : Result> DomainResult<T>.process(onSuccess: (T) -> R, onError: (DomainError) -> R) = when (this) {
    is DomainResult.Success -> flowOf(onSuccess(data))
    is DomainResult.Failure -> flowOf(onError(error))
}

/**
 * Process flow
 *
 * Extension to deconstruct [DomainResult] into a [Flow] with multiple values
 */
internal fun <T, R : Result> DomainResult<T>.processFlow(onSuccess: (T) -> Flow<R>, onError: (DomainError) -> Flow<R>) = when (this) {
    is DomainResult.Success -> onSuccess(data)
    is DomainResult.Failure -> onError(error)
}
