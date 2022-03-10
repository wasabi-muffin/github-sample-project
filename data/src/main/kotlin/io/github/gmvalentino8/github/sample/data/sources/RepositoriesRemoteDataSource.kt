package io.github.gmvalentino8.github.sample.data.sources

import io.github.gmvalentino8.github.sample.data.models.PullRequestModel
import io.github.gmvalentino8.github.sample.data.models.ReleaseModel
import io.github.gmvalentino8.github.sample.data.models.UserModel

interface RepositoriesRemoteDataSource {
    /**
     * Get contributors
     *
     * @param name name of repository to get results from
     * @param pageNumber page number of the results to get
     * @param perPage number of results to get
     * @param token access token
     * @return list of contributors
     */
    suspend fun getContributors(name: String, pageNumber: Int = 0, perPage: Int = 100, token: String? = null): List<UserModel>

    /**
     * Get releases
     *
     * @param name name of repository to get results from
     * @param pageNumber page number of the results to get
     * @param perPage number of results to get
     * @param token access token
     * @return list of releases
     */
    suspend fun getReleases(name: String, pageNumber: Int = 0, perPage: Int = 100, token: String? = null): List<ReleaseModel>

    /**
     * Get pulls
     *
     * @param name name of repository to get results from
     * @param pageNumber page number of the results to get
     * @param perPage number of results to get
     * @param token access token
     * @return list of pull requests
     */
    suspend fun getPulls(name: String, pageNumber: Int = 0, perPage: Int = 100, token: String? = null): List<PullRequestModel>
}
