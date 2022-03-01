package jp.co.yumemi.android.code_check.data.repositories

import jp.co.yumemi.android.code_check.data.mappers.PullRequestDataMapper
import jp.co.yumemi.android.code_check.data.mappers.ReleaseDataMapper
import jp.co.yumemi.android.code_check.data.mappers.UserDataMapper
import jp.co.yumemi.android.code_check.data.sources.RepositoriesRemoteDataSource
import jp.co.yumemi.android.code_check.domain.entities.PullRequest
import jp.co.yumemi.android.code_check.domain.entities.Release
import jp.co.yumemi.android.code_check.domain.entities.User
import jp.co.yumemi.android.code_check.domain.repositories.RepositoriesRepository

class RepositoriesMockRepository: RepositoriesRepository {
    override suspend fun getContributors(name: String): List<User> = listOf()
    override suspend fun getReleases(name: String): List<Release> = listOf()
    override suspend fun getPulls(name: String): List<PullRequest> = listOf()
}
