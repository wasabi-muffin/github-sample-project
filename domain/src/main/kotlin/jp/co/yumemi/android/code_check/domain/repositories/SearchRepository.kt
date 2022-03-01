package jp.co.yumemi.android.code_check.domain.repositories

import jp.co.yumemi.android.code_check.domain.entities.Issue
import jp.co.yumemi.android.code_check.domain.entities.Organization
import jp.co.yumemi.android.code_check.domain.entities.Pageable
import jp.co.yumemi.android.code_check.domain.entities.PullRequest
import jp.co.yumemi.android.code_check.domain.entities.RecentSearch
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.entities.User

interface SearchRepository {
    /**
     * Search repositories
     *
     * @param searchText text to search for
     * @param pageNumber page number of the results to get
     * @param count number of results to get
     * @return total count and list of repositories
     */
    suspend fun searchRepositories(searchText: String, pageNumber: Int = 0, count: Int = 30): Pageable<Repository>

    /**
     * Search issues
     *
     * @param searchText text to search for
     * @param pageNumber page number of the results to get
     * @param count number of results to get
     * @return total count and list of issues
     */
    suspend fun searchIssues(searchText: String, pageNumber: Int = 0, count: Int = 30): Pageable<Issue>

    /**
     * Search pull requests
     *
     * @param searchText text to search for
     * @param pageNumber page number of the results to get
     * @param count number of results to get
     * @return total count and list of pull requests
     */
    suspend fun searchPullRequests(searchText: String, pageNumber: Int = 0, count: Int = 30): Pageable<PullRequest>

    /**
     * Search users
     *
     * @param searchText text to search for
     * @param pageNumber page number of the results to get
     * @param count number of results to get
     * @return total count and list of users
     */
    suspend fun searchUsers(searchText: String, pageNumber: Int = 0, count: Int = 30): Pageable<User>

    /**
     * Search organizations
     *
     * @param searchText text to search for
     * @param pageNumber page number of the results to get
     * @param count number of results to get
     * @return total count and list of organizations
     */
    suspend fun searchOrganizations(searchText: String, pageNumber: Int = 0, count: Int = 30): Pageable<Organization>

    /**
     * Get recent searches
     *
     * @return list of the saved recent searches
     */
    suspend fun getRecentSearches(): List<RecentSearch>

    /**
     * Clear recent searches
     *
     * Deletes all recent searches
     */
    suspend fun clearRecentSearches()
}
