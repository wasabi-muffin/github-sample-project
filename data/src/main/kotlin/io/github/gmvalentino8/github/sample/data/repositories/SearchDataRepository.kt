package io.github.gmvalentino8.github.sample.data.repositories

import io.github.gmvalentino8.github.sample.data.mappers.IssueDataMapper
import io.github.gmvalentino8.github.sample.data.mappers.OrganizationDataMapper
import io.github.gmvalentino8.github.sample.data.mappers.PullRequestDataMapper
import io.github.gmvalentino8.github.sample.data.mappers.RecentSearchDataMapper
import io.github.gmvalentino8.github.sample.data.mappers.RepositoryDataMapper
import io.github.gmvalentino8.github.sample.data.mappers.UserDataMapper
import io.github.gmvalentino8.github.sample.data.sources.SearchLocalDataSource
import io.github.gmvalentino8.github.sample.data.sources.SearchRemoteDataSource
import io.github.gmvalentino8.github.sample.domain.entities.Pageable
import io.github.gmvalentino8.github.sample.domain.entities.Issue
import io.github.gmvalentino8.github.sample.domain.entities.Organization
import io.github.gmvalentino8.github.sample.domain.entities.PullRequest
import io.github.gmvalentino8.github.sample.domain.entities.RecentSearch
import io.github.gmvalentino8.github.sample.domain.entities.Repository
import io.github.gmvalentino8.github.sample.domain.entities.User
import io.github.gmvalentino8.github.sample.domain.repositories.SearchRepository

/**
 * Search data repository
 *
 * Default implementation of [SearchRepository]
 */
class SearchDataRepository(
    private val searchRemoteDataSource: SearchRemoteDataSource,
    private val searchLocalDataSource: SearchLocalDataSource
) : SearchRepository {
    override suspend fun searchRepositories(searchText: String, pageNumber: Int, count: Int): Pageable<Repository> {
        searchLocalDataSource.saveRecentSearch(searchText)
        return searchRemoteDataSource
            .searchRepositories(searchText = searchText, pageNumber = pageNumber, count = count)
            .let { results ->
                Pageable(results.items.map(RepositoryDataMapper::toEntity), results.totalCount)
            }
    }

    override suspend fun searchIssues(searchText: String, pageNumber: Int, count: Int): Pageable<Issue> {
        searchLocalDataSource.saveRecentSearch(searchText)
        return searchRemoteDataSource
            .searchIssues(searchText = searchText, pageNumber = pageNumber, count = count)
            .let { results ->
                Pageable(results.items.map(IssueDataMapper::toEntity), results.totalCount)
            }
    }

    override suspend fun searchPullRequests(searchText: String, pageNumber: Int, count: Int): Pageable<PullRequest> {
        searchLocalDataSource.saveRecentSearch(searchText)
        return searchRemoteDataSource
            .searchPullRequests(searchText = searchText, pageNumber = pageNumber, count = count)
            .let { results ->
                Pageable(results.items.map(PullRequestDataMapper::toEntity), results.totalCount)
            }
    }

    override suspend fun searchUsers(searchText: String, pageNumber: Int, count: Int): Pageable<User> {
        searchLocalDataSource.saveRecentSearch(searchText)
        return searchRemoteDataSource
            .searchUsers(searchText = searchText, pageNumber = pageNumber, count = count)
            .let { results ->
                Pageable(results.items.map(UserDataMapper::toEntity), results.totalCount)
            }
    }

    override suspend fun searchOrganizations(searchText: String, pageNumber: Int, count: Int): Pageable<Organization> {
        searchLocalDataSource.saveRecentSearch(searchText)
        return searchRemoteDataSource
            .searchOrganizations(searchText = searchText, pageNumber = pageNumber, count = count)
            .let { results ->
                Pageable(results.items.map(OrganizationDataMapper::toEntity), results.totalCount)
            }
    }

    override suspend fun getRecentSearches(): List<RecentSearch> = searchLocalDataSource
        .getRecentSearches()
        .map(RecentSearchDataMapper::toEntity)

    override suspend fun clearRecentSearches() = searchLocalDataSource.deleteAllRecentSearches()
}
