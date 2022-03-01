package jp.co.yumemi.android.code_check.domain.usecases

import jp.co.yumemi.android.code_check.domain.core.UseCase
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository

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
