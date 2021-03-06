package io.github.gmvalentino8.github.sample.domain.core

/**
 * Domain result
 *
 * Wrapper for either Success with data or Failure with error
 *
 * Use where [Exception]s could be thrown
 */
sealed class DomainResult<out R> {
    data class Success<out T>(val data: T) : DomainResult<T>()
    data class Failure(val error: DomainError) : DomainResult<Nothing>()
}

/**
 * To domain result
 *
 * Extension to map kotlin.Result to DomainResult
 */
fun <T> Result<T>.toDomainResult(errorHandler: ErrorHandler) = this.fold(
    onSuccess = { DomainResult.Success(it) },
    onFailure = { DomainResult.Failure(errorHandler.handle(it)) }
)

/**
 * Success or null
 *
 * Extension to get the value if success
 */
fun <T> DomainResult<T>.successOrNull() = when (this) {
    is DomainResult.Success<T> -> data
    is DomainResult.Failure -> null
}

/**
 * Error or null
 *
 * Extension to get the error if failure
 */
fun <T> DomainResult<T>.errorOrNull() = when (this) {
    is DomainResult.Success<T> -> null
    is DomainResult.Failure -> error
}
