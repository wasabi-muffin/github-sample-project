package io.github.gmvalentino8.github.sample.domain.core

/**
 * Domain error
 *
 * Wrapper for [Throwable]s
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
