package io.github.gmvalentino8.github.sample.domain.usecases

import io.github.gmvalentino8.github.sample.domain.core.UseCase
import io.github.gmvalentino8.github.sample.domain.entities.RecentSearch
import io.github.gmvalentino8.github.sample.domain.repositories.SearchRepository

/**
 * Get recent searches use case
 *
 * Get all recent searches
 */
interface GetRecentSearchesUseCase : UseCase<Unit, List<RecentSearch>>

class GetRecentSearchesExecutor(
    private val searchRepository: SearchRepository
) : GetRecentSearchesUseCase {
    override suspend fun execute(arguments: Unit): List<RecentSearch> = searchRepository.getRecentSearches()
}
