package jp.co.yumemi.android.code_check.data.repositories

import jp.co.yumemi.android.code_check.data.mappers.RecentSearchMapper
import jp.co.yumemi.android.code_check.data.mappers.SearchMapper
import jp.co.yumemi.android.code_check.data.sources.SearchLocalDataSource
import jp.co.yumemi.android.code_check.data.sources.SearchRemoteDataSource
import jp.co.yumemi.android.code_check.domain.core.Pageable
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.entities.RecentSearch
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository

class SearchDataRepository(
    private val searchRemoteDataSource: SearchRemoteDataSource,
    private val searchLocalDataSource: SearchLocalDataSource
) : SearchRepository {
    override suspend fun searchRepos(searchText: String, pageNumber: Int): Pageable<Repository> {
        searchLocalDataSource.saveRecentSearch(searchText)
        return searchRemoteDataSource
            .searchRepos(searchText = searchText, pageNumber = pageNumber)
            .let { results ->
                Pageable(results.repos.map(SearchMapper::modelToEntity), results.totalCount)
            }
    }

    override suspend fun getRecentSearches(): List<RecentSearch> = searchLocalDataSource
        .getRecentSearches()
        .map(RecentSearchMapper::modelToEntity)

    override suspend fun clearRecentSearches() = searchLocalDataSource.deleteAllRecentSearches()
}
