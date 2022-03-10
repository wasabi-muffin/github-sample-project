package io.github.gmvalentino8.github.sample.domain.usecases

import io.github.gmvalentino8.github.sample.domain.core.UseCase
import io.github.gmvalentino8.github.sample.domain.repositories.SearchRepository

/**
 * Clear recent searches use case
 *
 * Deletes all recent searches
 */
interface ClearRecentSearchesUseCase : UseCase<Unit, Unit>

class ClearRecentSearchesExecutor(
    private val searchRepository: SearchRepository
) : ClearRecentSearchesUseCase {
    override suspend fun execute(arguments: Unit): Unit = searchRepository.clearRecentSearches()
}
