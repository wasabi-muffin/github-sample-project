package io.github.gmvalentino8.github.sample.data.repositories

import io.github.gmvalentino8.github.sample.domain.entities.Issue
import io.github.gmvalentino8.github.sample.domain.entities.Organization
import io.github.gmvalentino8.github.sample.domain.entities.Pageable
import io.github.gmvalentino8.github.sample.domain.entities.PullRequest
import io.github.gmvalentino8.github.sample.domain.entities.RecentSearch
import io.github.gmvalentino8.github.sample.domain.entities.Repository
import io.github.gmvalentino8.github.sample.domain.entities.User
import io.github.gmvalentino8.github.sample.domain.repositories.SearchRepository

class SearchMockRepository : SearchRepository {
    override suspend fun searchRepositories(searchText: String, pageNumber: Int, count: Int): Pageable<Repository> = Pageable(
        items = emptyList(),
        totalCount = 0
    )

    override suspend fun searchIssues(searchText: String, pageNumber: Int, count: Int): Pageable<Issue> = Pageable(
        items = emptyList(),
        totalCount = 0
    )

    override suspend fun searchPullRequests(searchText: String, pageNumber: Int, count: Int): Pageable<PullRequest> = Pageable(
        items = emptyList(),
        totalCount = 0
    )

    override suspend fun searchUsers(searchText: String, pageNumber: Int, count: Int): Pageable<User> = Pageable(
        items = emptyList(),
        totalCount = 0
    )

    override suspend fun searchOrganizations(searchText: String, pageNumber: Int, count: Int): Pageable<Organization> = Pageable(
        items = emptyList(),
        totalCount = 0
    )

    override suspend fun getRecentSearches(): List<RecentSearch> = listOf()

    override suspend fun clearRecentSearches() = Unit
}
