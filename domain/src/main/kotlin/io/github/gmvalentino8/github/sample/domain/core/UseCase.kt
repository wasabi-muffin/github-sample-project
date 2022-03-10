package io.github.gmvalentino8.github.sample.domain.core

/**
 * Use case
 *
 * Executes a unit of business logic
 */
fun interface UseCase<in Arguments, out ReturnType> {
    suspend fun execute(arguments: Arguments): ReturnType
}
