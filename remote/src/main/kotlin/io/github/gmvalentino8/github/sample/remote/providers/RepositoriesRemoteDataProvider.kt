package io.github.gmvalentino8.github.sample.remote.providers

import io.github.gmvalentino8.github.sample.data.core.ExceptionHandler
import io.github.gmvalentino8.github.sample.data.core.runHandling
import io.github.gmvalentino8.github.sample.data.models.PullRequestModel
import io.github.gmvalentino8.github.sample.data.models.ReleaseModel
import io.github.gmvalentino8.github.sample.data.models.UserModel
import io.github.gmvalentino8.github.sample.data.sources.RepositoriesRemoteDataSource
import io.github.gmvalentino8.github.sample.remote.apis.PullsApi
import io.github.gmvalentino8.github.sample.remote.apis.ReposApi
import io.github.gmvalentino8.github.sample.remote.mappers.PullRequestRemoteMapper
import io.github.gmvalentino8.github.sample.remote.mappers.ReleaseRemoteMapper
import io.github.gmvalentino8.github.sample.remote.mappers.UserRemoteMapper

/**
 * Repositories remote data provider
 *
 * Default implementation of [RepositoriesRemoteDataSource]
 */
class RepositoriesRemoteDataProvider(
    private val reposApi: ReposApi,
    private val pullsApi: PullsApi,
    private val exceptionHandler: ExceptionHandler,
) : RepositoriesRemoteDataSource {
    override suspend fun getContributors(
        name: String,
        pageNumber: Int,
        perPage: Int,
        token: String?
    ): List<UserModel> = runHandling(exceptionHandler) {
        reposApi
            .reposListContributors(accessToken = token, repoName = name, page = pageNumber, perPage = perPage)
            .map(UserRemoteMapper::toModel)
    }

    override suspend fun getReleases(
        name: String,
        pageNumber: Int,
        perPage: Int,
        token: String?
    ): List<ReleaseModel> = runHandling(exceptionHandler) {
        reposApi
            .reposListReleases(accessToken = token, repoName = name, page = pageNumber, perPage = perPage)
            .map(ReleaseRemoteMapper::toModel)
    }

    override suspend fun getPulls(
        name: String,
        pageNumber: Int,
        perPage: Int,
        token: String?
    ): List<PullRequestModel> = runHandling(exceptionHandler) {
        pullsApi
            .pullsList(accessToken = token, repoName = name, page = pageNumber, perPage = perPage)
            .map(PullRequestRemoteMapper::toModel)
    }
}
