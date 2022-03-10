package io.github.gmvalentino8.github.sample.data.repositories

import io.github.gmvalentino8.github.sample.domain.entities.PullRequest
import io.github.gmvalentino8.github.sample.domain.entities.Release
import io.github.gmvalentino8.github.sample.domain.entities.User
import io.github.gmvalentino8.github.sample.domain.repositories.RepositoriesRepository

class RepositoriesMockRepository : RepositoriesRepository {
    override suspend fun getContributors(name: String): List<User> = listOf()
    override suspend fun getReleases(name: String): List<Release> = listOf()
    override suspend fun getPulls(name: String): List<PullRequest> = listOf()
}
