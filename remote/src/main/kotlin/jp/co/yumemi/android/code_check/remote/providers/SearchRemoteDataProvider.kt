package jp.co.yumemi.android.code_check.remote.providers

import jp.co.yumemi.android.code_check.data.models.IssueModel
import jp.co.yumemi.android.code_check.data.models.OrganizationModel
import jp.co.yumemi.android.code_check.data.models.PullRequestModel
import jp.co.yumemi.android.code_check.data.models.RepositoryModel
import jp.co.yumemi.android.code_check.data.models.SearchResultModel
import jp.co.yumemi.android.code_check.data.models.UserModel
import jp.co.yumemi.android.code_check.data.sources.SearchRemoteDataSource
import jp.co.yumemi.android.code_check.remote.apis.SearchApi
import jp.co.yumemi.android.code_check.remote.mappers.IssueRemoteMapper
import jp.co.yumemi.android.code_check.remote.mappers.OrganizationRemoteMapper
import jp.co.yumemi.android.code_check.remote.mappers.PullRequestRemoteMapper
import jp.co.yumemi.android.code_check.remote.mappers.RepositoryRemoteMapper
import jp.co.yumemi.android.code_check.remote.mappers.UserRemoteMapper

class SearchRemoteDataProvider(
    private val searchApi: SearchApi
) : SearchRemoteDataSource {
    override suspend fun searchRepositories(
        token: String?,
        searchText: String,
        pageNumber: Int,
        count: Int
    ): SearchResultModel<RepositoryModel> = searchApi
        .searchRepositories(accessToken = token, q = searchText, page = pageNumber, perPage = count)
        .let { response ->
            SearchResultModel(
                response.items.map(RepositoryRemoteMapper::toModel),
                response.totalCount
            )
        }

    override suspend fun searchIssues(
        token: String?,
        searchText: String,
        pageNumber: Int,
        count: Int
    ): SearchResultModel<IssueModel> = searchApi
        .searchIssuesAndPullRequests(accessToken = token, q = "$searchText type:issue", page = pageNumber, perPage = count)
        .let { response ->
            SearchResultModel(
                response.items.map(IssueRemoteMapper::toModel),
                response.totalCount
            )
        }

    override suspend fun searchPullRequests(
        token: String?,
        searchText: String,
        pageNumber: Int,
        count: Int
    ): SearchResultModel<PullRequestModel> = searchApi
        .searchIssuesAndPullRequests(accessToken = token, q = "$searchText type:pr", page = pageNumber, perPage = count)
        .let { response ->
            SearchResultModel(
                response.items.map(PullRequestRemoteMapper::toModel),
                response.totalCount
            )
        }

    override suspend fun searchUsers(
        token: String?,
        searchText: String,
        pageNumber: Int,
        count: Int
    ): SearchResultModel<UserModel> = searchApi
        .searchUsers(accessToken = token, q = "$searchText type:user", page = pageNumber, perPage = count)
        .let { response ->
            SearchResultModel(
                response.items.map(UserRemoteMapper::toModel),
                response.totalCount
            )
        }

    override suspend fun searchOrganizations(
        token: String?,
        searchText: String,
        pageNumber: Int,
        count: Int
    ): SearchResultModel<OrganizationModel> = searchApi
        .searchUsers(accessToken = token, q = "$searchText type:organization", page = pageNumber, perPage = count)
        .let { response ->
            SearchResultModel(
                response.items.map(OrganizationRemoteMapper::toModel),
                response.totalCount
            )
        }
}
