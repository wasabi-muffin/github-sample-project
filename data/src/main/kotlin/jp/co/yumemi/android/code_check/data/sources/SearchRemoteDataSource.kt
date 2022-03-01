package jp.co.yumemi.android.code_check.data.sources

import jp.co.yumemi.android.code_check.data.models.IssueModel
import jp.co.yumemi.android.code_check.data.models.OrganizationModel
import jp.co.yumemi.android.code_check.data.models.PullRequestModel
import jp.co.yumemi.android.code_check.data.models.RepositoryModel
import jp.co.yumemi.android.code_check.data.models.SearchResultModel
import jp.co.yumemi.android.code_check.data.models.UserModel

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
