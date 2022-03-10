package io.github.gmvalentino8.github.sample.domain.repositories

import io.github.gmvalentino8.github.sample.domain.entities.Issue
import io.github.gmvalentino8.github.sample.domain.entities.Organization
import io.github.gmvalentino8.github.sample.domain.entities.Pageable
import io.github.gmvalentino8.github.sample.domain.entities.PullRequest
import io.github.gmvalentino8.github.sample.domain.entities.RecentSearch
import io.github.gmvalentino8.github.sample.domain.entities.Repository
import io.github.gmvalentino8.github.sample.domain.entities.User

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
