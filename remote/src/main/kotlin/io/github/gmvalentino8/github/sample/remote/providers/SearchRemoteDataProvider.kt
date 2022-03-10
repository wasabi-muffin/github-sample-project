package io.github.gmvalentino8.github.sample.remote.providers

import io.github.gmvalentino8.github.sample.data.core.ExceptionHandler
import io.github.gmvalentino8.github.sample.data.core.runHandling
import io.github.gmvalentino8.github.sample.data.models.IssueModel
import io.github.gmvalentino8.github.sample.data.models.OrganizationModel
import io.github.gmvalentino8.github.sample.data.models.PullRequestModel
import io.github.gmvalentino8.github.sample.data.models.RepositoryModel
import io.github.gmvalentino8.github.sample.data.models.SearchResultModel
import io.github.gmvalentino8.github.sample.data.models.UserModel
import io.github.gmvalentino8.github.sample.data.sources.SearchRemoteDataSource
import io.github.gmvalentino8.github.sample.remote.apis.SearchApi
import io.github.gmvalentino8.github.sample.remote.mappers.IssueRemoteMapper
import io.github.gmvalentino8.github.sample.remote.mappers.OrganizationRemoteMapper
import io.github.gmvalentino8.github.sample.remote.mappers.PullRequestRemoteMapper
import io.github.gmvalentino8.github.sample.remote.mappers.RepositoryRemoteMapper
import io.github.gmvalentino8.github.sample.remote.mappers.UserRemoteMapper

/**
 * Search remote data provider
 *
 * Default implementation of [SearchRemoteDataSource]
 */
class SearchRemoteDataProvider(
    private val searchApi: SearchApi,
    private val exceptionHandler: ExceptionHandler,
) : SearchRemoteDataSource {
    override suspend fun searchRepositories(
        token: String?,
        searchText: String,
        pageNumber: Int,
        count: Int
    ): SearchResultModel<RepositoryModel> = runHandling(exceptionHandler) {
        searchApi
            .searchRepos(accessToken = token, q = searchText, page = pageNumber, perPage = count)
            .let { response ->
                SearchResultModel(
                    response.items.map(RepositoryRemoteMapper::toModel),
                    response.totalCount
                )
            }
    }

    override suspend fun searchIssues(
        token: String?,
        searchText: String,
        pageNumber: Int,
        count: Int
    ): SearchResultModel<IssueModel> = runHandling(exceptionHandler) {
        searchApi
            .searchIssuesAndPullRequests(accessToken = token, q = "$searchText type:issue", page = pageNumber, perPage = count)
            .let { response ->
                SearchResultModel(
                    response.items.map(IssueRemoteMapper::toModel),
                    response.totalCount
                )
            }
    }

    override suspend fun searchPullRequests(
        token: String?,
        searchText: String,
        pageNumber: Int,
        count: Int
    ): SearchResultModel<PullRequestModel> = runHandling(exceptionHandler) {
        searchApi
            .searchIssuesAndPullRequests(accessToken = token, q = "$searchText type:pr", page = pageNumber, perPage = count)
            .let { response ->
                SearchResultModel(
                    response.items.map(PullRequestRemoteMapper::toModel),
                    response.totalCount
                )
            }
    }

    override suspend fun searchUsers(
        token: String?,
        searchText: String,
        pageNumber: Int,
        count: Int
    ): SearchResultModel<UserModel> = runHandling(exceptionHandler) {
        searchApi
            .searchUsers(accessToken = token, q = "$searchText type:user", page = pageNumber, perPage = count)
            .let { response ->
                SearchResultModel(
                    response.items.map(UserRemoteMapper::toModel),
                    response.totalCount
                )
            }
    }

    override suspend fun searchOrganizations(
        token: String?,
        searchText: String,
        pageNumber: Int,
        count: Int
    ): SearchResultModel<OrganizationModel> = runHandling(exceptionHandler) {
        searchApi
            .searchUsers(accessToken = token, q = "$searchText type:organization", page = pageNumber, perPage = count)
            .let { response ->
                SearchResultModel(
                    response.items.map(OrganizationRemoteMapper::toModel),
                    response.totalCount
                )
            }
    }
}
