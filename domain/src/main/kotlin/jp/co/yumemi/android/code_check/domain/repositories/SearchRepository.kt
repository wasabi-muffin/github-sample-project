package jp.co.yumemi.android.code_check.domain.repositories

import jp.co.yumemi.android.code_check.domain.core.Pageable
import jp.co.yumemi.android.code_check.domain.entities.Issue
import jp.co.yumemi.android.code_check.domain.entities.Organization
import jp.co.yumemi.android.code_check.domain.entities.PullRequest
import jp.co.yumemi.android.code_check.domain.entities.RecentSearch
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.entities.User

interface SearchRepository {
    suspend fun searchRepositories(searchText: String, pageNumber: Int = 0): Pageable<Repository>
    suspend fun searchIssues(searchText: String, pageNumber: Int = 0): Pageable<Issue>
    suspend fun searchPullRequests(searchText: String, pageNumber: Int = 0): Pageable<PullRequest>
    suspend fun searchUsers(searchText: String, pageNumber: Int = 0): Pageable<User>
    suspend fun searchOrganizations(searchText: String, pageNumber: Int = 0): Pageable<Organization>
    suspend fun getRecentSearches(): List<RecentSearch>
    suspend fun clearRecentSearches()
}
