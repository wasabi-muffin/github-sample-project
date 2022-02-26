package jp.co.yumemi.android.code_check.domain.repositories

import jp.co.yumemi.android.code_check.domain.entities.Release
import jp.co.yumemi.android.code_check.domain.entities.User

interface RepositoriesRepository {
    fun getContributors(name: String): List<User>
    fun getReleases(name: String): List<Release>
}
