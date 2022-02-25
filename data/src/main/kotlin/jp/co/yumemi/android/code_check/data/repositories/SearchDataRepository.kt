package jp.co.yumemi.android.code_check.data.repositories

import jp.co.yumemi.android.code_check.data.mappers.RecentSearchMapper
import jp.co.yumemi.android.code_check.data.mappers.SearchMapper
import jp.co.yumemi.android.code_check.data.sources.SearchLocalDataSource
import jp.co.yumemi.android.code_check.data.sources.SearchRemoteDataSource
import jp.co.yumemi.android.code_check.domain.entities.SimpleGithubRepo
import jp.co.yumemi.android.code_check.domain.entities.RecentSearch
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository

class SearchDataRepository(
    private val searchRemoteDataSource: SearchRemoteDataSource,
    private val searchLocalDataSource: SearchLocalDataSource
) : SearchRepository {
    override suspend fun searchRepos(searchText: String): List<SimpleGithubRepo> {
        searchLocalDataSource.saveRecentSearch(searchText)
        return searchRemoteDataSource
            .searchRepos(searchText = searchText)
            .map(SearchMapper::modelToEntity)
    }

    override suspend fun getRecentSearches(): List<RecentSearch> = searchLocalDataSource
        .getRecentSearches()
        .map(RecentSearchMapper::modelToEntity)

    override suspend fun clearRecentSearches() = searchLocalDataSource.deleteAllRecentSearches()
}
