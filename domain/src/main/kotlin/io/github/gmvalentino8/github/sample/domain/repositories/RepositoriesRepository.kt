package io.github.gmvalentino8.github.sample.domain.repositories

import io.github.gmvalentino8.github.sample.domain.entities.PullRequest
import io.github.gmvalentino8.github.sample.domain.entities.Release
import io.github.gmvalentino8.github.sample.domain.entities.User

interface RepositoriesRepository {
    /**
     * Get contributors
     **
     * @param name name of the repository
     * @return list of contributors for [name] repository
     */
    suspend fun getContributors(name: String): List<User>

    /**
     * Get releases
     *
     * @param name name of the repository
     * @return list of releases for [name] repository
     */
    suspend fun getReleases(name: String): List<Release>

    /**
     * Get pulls
     *
     * @param name name of the repository
     * @return list of pull requests for [name] repository
     */
    suspend fun getPulls(name: String): List<PullRequest>
}
