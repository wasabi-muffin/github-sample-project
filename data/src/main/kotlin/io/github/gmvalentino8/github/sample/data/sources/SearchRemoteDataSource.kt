package io.github.gmvalentino8.github.sample.data.sources

import io.github.gmvalentino8.github.sample.data.models.IssueModel
import io.github.gmvalentino8.github.sample.data.models.OrganizationModel
import io.github.gmvalentino8.github.sample.data.models.PullRequestModel
import io.github.gmvalentino8.github.sample.data.models.RepositoryModel
import io.github.gmvalentino8.github.sample.data.models.SearchResultModel
import io.github.gmvalentino8.github.sample.data.models.UserModel

interface SearchRemoteDataSource {
    /**
     * Search repositories
     *
     * @param searchText text to search for
     * @param pageNumber page number of the results to get
     * @param count number of results to get
     * @param token access token
     * @return total count and list of repositories
     */
    suspend fun searchRepositories(token: String? = null, searchText: String, pageNumber: Int = 0, count: Int = 30): SearchResultModel<RepositoryModel>

    /**
     * Search issues
     *
     * @param searchText text to search for
     * @param pageNumber page number of the results to get
     * @param count number of results to get
     * @param token access token
     * @return total count and list of issues
     */
    suspend fun searchIssues(token: String? = null, searchText: String, pageNumber: Int = 0, count: Int = 30): SearchResultModel<IssueModel>

    /**
     * Search pull requests
     *
     * @param searchText text to search for
     * @param pageNumber page number of the results to get
     * @param count number of results to get
     * @param token access token
     * @return total count and list of pull requests
     */
    suspend fun searchPullRequests(token: String? = null, searchText: String, pageNumber: Int = 0, count: Int = 30): SearchResultModel<PullRequestModel>

    /**
     * Search users
     *
     * @param token
     * @param searchText text to search for
     * @param pageNumber page number of the results to get
     * @param count number of results to get
     * @param token access token
     * @return total count and list of users
     */
    suspend fun searchUsers(token: String? = null, searchText: String, pageNumber: Int = 0, count: Int = 30): SearchResultModel<UserModel>

    /**
     * Search organizations
     *
     * @param searchText text to search for
     * @param pageNumber page number of the results to get
     * @param count number of results to get
     * @param token access token
     * @return total count and list of organizations
     */
    suspend fun searchOrganizations(token: String? = null, searchText: String, pageNumber: Int = 0, count: Int = 30): SearchResultModel<OrganizationModel>
}
