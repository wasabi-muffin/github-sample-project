package jp.co.yumemi.android.code_check.domain.repositories

import jp.co.yumemi.android.code_check.domain.entities.Release
import jp.co.yumemi.android.code_check.domain.entities.User

interface RepositoriesRepository {
    suspend fun getContributors(name: String): List<User>
    suspend fun getReleases(name: String): List<Release>
}
