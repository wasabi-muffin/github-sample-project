package jp.co.yumemi.android.code_check.data.repositories

import jp.co.yumemi.android.code_check.domain.core.Pageable
import jp.co.yumemi.android.code_check.domain.entities.Issue
import jp.co.yumemi.android.code_check.domain.entities.Organization
import jp.co.yumemi.android.code_check.domain.entities.PullRequest
import jp.co.yumemi.android.code_check.domain.entities.RecentSearch
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.entities.User
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository

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
