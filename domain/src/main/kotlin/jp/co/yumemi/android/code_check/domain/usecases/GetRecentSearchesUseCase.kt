package jp.co.yumemi.android.code_check.domain.usecases

import jp.co.yumemi.android.code_check.domain.core.UseCase
import jp.co.yumemi.android.code_check.domain.entities.RecentSearch
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository

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
