package jp.co.yumemi.android.code_check.data.repositories

import jp.co.yumemi.android.code_check.data.mappers.RecentSearchDataMapper
import jp.co.yumemi.android.code_check.data.mappers.RepositoryDataMapper
import jp.co.yumemi.android.code_check.data.sources.SearchLocalDataSource
import jp.co.yumemi.android.code_check.data.sources.SearchRemoteDataSource
import jp.co.yumemi.android.code_check.domain.core.Pageable
import jp.co.yumemi.android.code_check.domain.entities.Issue
import jp.co.yumemi.android.code_check.domain.entities.Organization
import jp.co.yumemi.android.code_check.domain.entities.PullRequest
import jp.co.yumemi.android.code_check.domain.entities.RecentSearch
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.entities.User
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository

class SearchDataRepository(
    private val searchRemoteDataSource: SearchRemoteDataSource,
    private val searchLocalDataSource: SearchLocalDataSource
) : SearchRepository {
    override suspend fun searchRepositories(searchText: String, pageNumber: Int): Pageable<Repository> {
        searchLocalDataSource.saveRecentSearch(searchText)
        return searchRemoteDataSource
            .searchRepos(searchText = searchText, pageNumber = pageNumber)
            .let { results ->
                Pageable(results.repos.map(RepositoryDataMapper::toEntity), results.totalCount)
            }
    }

    override suspend fun searchIssues(searchText: String, pageNumber: Int): Pageable<Issue> {
        TODO("Not yet implemented")
    }

    override suspend fun searchPullRequests(searchText: String, pageNumber: Int): Pageable<PullRequest> {
        TODO("Not yet implemented")
    }

    override suspend fun searchUsers(searchText: String, pageNumber: Int): Pageable<User> {
        TODO("Not yet implemented")
    }

    override suspend fun searchOrganizations(searchText: String, pageNumber: Int): Pageable<Organization> {
        TODO("Not yet implemented")
    }

    override suspend fun getRecentSearches(): List<RecentSearch> = searchLocalDataSource
        .getRecentSearches()
        .map(RecentSearchDataMapper::toEntity)

    override suspend fun clearRecentSearches() = searchLocalDataSource.deleteAllRecentSearches()
}
