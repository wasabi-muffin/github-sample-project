package jp.co.yumemi.android.code_check.remote.providers

import jp.co.yumemi.android.code_check.data.error.ExceptionHandler
import jp.co.yumemi.android.code_check.data.error.runHandling
import jp.co.yumemi.android.code_check.data.models.PullRequestModel
import jp.co.yumemi.android.code_check.data.models.ReleaseModel
import jp.co.yumemi.android.code_check.data.models.UserModel
import jp.co.yumemi.android.code_check.data.sources.RepositoriesRemoteDataSource
import jp.co.yumemi.android.code_check.remote.apis.PullsApi
import jp.co.yumemi.android.code_check.remote.apis.ReposApi
import jp.co.yumemi.android.code_check.remote.mappers.PullRequestRemoteMapper
import jp.co.yumemi.android.code_check.remote.mappers.ReleaseRemoteMapper
import jp.co.yumemi.android.code_check.remote.mappers.UserRemoteMapper

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
