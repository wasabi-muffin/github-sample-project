package io.github.gmvalentino8.domain.core

fun interface ErrorHandler {
    fun handleError(throwable: Throwable): DomainError
}
