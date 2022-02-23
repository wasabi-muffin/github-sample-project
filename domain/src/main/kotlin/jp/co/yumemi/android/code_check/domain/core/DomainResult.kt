package jp.co.yumemi.android.code_check.domain.core

/**
 * Wrapper for either Success with data or Failure with error
 */
sealed class DomainResult<out R> {
    data class Success<out T>(val data: T) : DomainResult<T>()
    data class Failure(val error: DomainError) : DomainResult<Nothing>()
}

/**
 * Extension to map kotlin.Result to DomainResult
 */
fun <T> Result<T>.toDomainResult(errorHandler: ErrorHandler) = this.fold(
    onSuccess = { DomainResult.Success(it) },
    onFailure = { DomainResult.Failure(errorHandler.handleError(it)) }
)
