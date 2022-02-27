package jp.co.yumemi.android.code_check.data.sources

import jp.co.yumemi.android.code_check.data.models.IssueModel
import jp.co.yumemi.android.code_check.data.models.OrganizationModel
import jp.co.yumemi.android.code_check.data.models.PullRequestModel
import jp.co.yumemi.android.code_check.data.models.RepositoryModel
import jp.co.yumemi.android.code_check.data.models.SearchResultModel
import jp.co.yumemi.android.code_check.data.models.UserModel

interface SearchRemoteDataSource {
    suspend fun searchRepositories(token: String? = null, searchText: String, pageNumber: Int = 0, count: Int = 30): SearchResultModel<RepositoryModel>
    suspend fun searchIssues(token: String? = null, searchText: String, pageNumber: Int = 0, count: Int = 30): SearchResultModel<IssueModel>
    suspend fun searchPullRequests(token: String? = null, searchText: String, pageNumber: Int = 0, count: Int = 30): SearchResultModel<PullRequestModel>
    suspend fun searchUsers(token: String? = null, searchText: String, pageNumber: Int = 0, count: Int = 30): SearchResultModel<UserModel>
    suspend fun searchOrganizations(token: String? = null, searchText: String, pageNumber: Int = 0, count: Int = 30): SearchResultModel<OrganizationModel>
}
