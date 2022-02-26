package jp.co.yumemi.android.code_check.data.repositories

import jp.co.yumemi.android.code_check.data.mappers.ReleaseDataMapper
import jp.co.yumemi.android.code_check.data.mappers.UserDataMapper
import jp.co.yumemi.android.code_check.data.sources.RepositoriesRemoteDataSource
import jp.co.yumemi.android.code_check.domain.entities.Release
import jp.co.yumemi.android.code_check.domain.entities.User
import jp.co.yumemi.android.code_check.domain.repositories.RepositoriesRepository

class RepositoriesDataRepository(
    private val repositoriesRemoteDataSource: RepositoriesRemoteDataSource
) : RepositoriesRepository {
    override suspend fun getContributors(name: String): List<User> = repositoriesRemoteDataSource
        .getContributors(name)
        .map(UserDataMapper::toEntity)

    override suspend fun getReleases(name: String): List<Release> = repositoriesRemoteDataSource
        .getReleases(name)
        .map(ReleaseDataMapper::toEntity)
}
