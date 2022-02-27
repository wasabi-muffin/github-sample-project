package jp.co.yumemi.android.code_check.remote.providers

import jp.co.yumemi.android.code_check.data.models.IssueModel
import jp.co.yumemi.android.code_check.data.models.OrganizationModel
import jp.co.yumemi.android.code_check.data.models.PullRequestModel
import jp.co.yumemi.android.code_check.data.models.RepositoryModel
import jp.co.yumemi.android.code_check.data.models.SearchResultModel
import jp.co.yumemi.android.code_check.data.models.UserModel
import jp.co.yumemi.android.code_check.data.sources.SearchRemoteDataSource
import jp.co.yumemi.android.code_check.remote.apis.SearchApi
import jp.co.yumemi.android.code_check.remote.mappers.SearchRemoteMapper

class SearchRemoteDataProvider(
    private val searchApi: SearchApi
) : SearchRemoteDataSource {
    override suspend fun searchRepositories(token: String?, searchText: String, pageNumber: Int): SearchResultModel<RepositoryModel> = searchApi
        .searchRepos(accessToken = token, q = searchText, page = pageNumber)
        .let { response ->
            SearchResultModel(
                response.items.map(SearchRemoteMapper::toModel),
                response.totalCount
            )
        }

    override suspend fun searchIssues(token: String?, searchText: String, pageNumber: Int): SearchResultModel<IssueModel> {
        TODO("Not yet implemented")
    }

    override suspend fun searchPullRequests(token: String?, searchText: String, pageNumber: Int): SearchResultModel<PullRequestModel> {
        TODO("Not yet implemented")
    }

    override suspend fun searchUsers(token: String?, searchText: String, pageNumber: Int): SearchResultModel<UserModel> {
        TODO("Not yet implemented")
    }

    override suspend fun searchOrganizations(token: String?, searchText: String, pageNumber: Int): SearchResultModel<OrganizationModel> {
        TODO("Not yet implemented")
    }
}
