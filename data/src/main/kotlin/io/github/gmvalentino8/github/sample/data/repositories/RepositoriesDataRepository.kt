package io.github.gmvalentino8.github.sample.data.repositories

import io.github.gmvalentino8.github.sample.data.mappers.PullRequestDataMapper
import io.github.gmvalentino8.github.sample.data.mappers.ReleaseDataMapper
import io.github.gmvalentino8.github.sample.data.mappers.UserDataMapper
import io.github.gmvalentino8.github.sample.data.sources.RepositoriesRemoteDataSource
import io.github.gmvalentino8.github.sample.domain.entities.PullRequest
import io.github.gmvalentino8.github.sample.domain.entities.Release
import io.github.gmvalentino8.github.sample.domain.entities.User
import io.github.gmvalentino8.github.sample.domain.repositories.RepositoriesRepository

/**
 * Repositories data repository
 *
 * Default implementation of [RepositoriesRepository]
 */
class RepositoriesDataRepository(
    private val repositoriesRemoteDataSource: RepositoriesRemoteDataSource
) : RepositoriesRepository {
    override suspend fun getContributors(name: String): List<User> = repositoriesRemoteDataSource
        .getContributors(name)
        .map(UserDataMapper::toEntity)

    override suspend fun getReleases(name: String): List<Release> = repositoriesRemoteDataSource
        .getReleases(name)
        .map(ReleaseDataMapper::toEntity)

    override suspend fun getPulls(name: String): List<PullRequest> = repositoriesRemoteDataSource
        .getPulls(name)
        .map(PullRequestDataMapper::toEntity)
}
