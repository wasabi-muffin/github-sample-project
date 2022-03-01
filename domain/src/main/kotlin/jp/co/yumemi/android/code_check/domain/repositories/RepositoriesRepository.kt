package jp.co.yumemi.android.code_check.domain.repositories

import jp.co.yumemi.android.code_check.domain.entities.PullRequest
import jp.co.yumemi.android.code_check.domain.entities.Release
import jp.co.yumemi.android.code_check.domain.entities.User

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
