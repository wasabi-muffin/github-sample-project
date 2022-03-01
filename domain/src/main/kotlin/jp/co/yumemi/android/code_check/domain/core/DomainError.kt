package jp.co.yumemi.android.code_check.domain.core

/**
 * Domain error
 *
 * Wrapper for throwables
 *
 * [Exception]s should be caught in the domain layer and passed as [DomainError]s to the presentation layer
 */
sealed class DomainError(
    open val throwable: Throwable,
) : Throwable(throwable) {
    data class Network(override val throwable: Throwable) : DomainError(throwable)
    data class Server(override val throwable: Throwable) : DomainError(throwable)
    data class Maintenance(override val throwable: Throwable) : DomainError(throwable)
    data class Unknown(override val throwable: Throwable) : DomainError(throwable)
}

/**
 * Run handling
 *
 * Extension to run a [block] and map exceptions using an [ErrorHandler] on failure
 */
inline fun <T, R> T.runHandling(handler: ErrorHandler, block: T.() -> R): DomainResult<R> {
    return try {
        DomainResult.Success(block())
    } catch (e: Throwable) {
        DomainResult.Failure(handler.handle(e))
    }
}
