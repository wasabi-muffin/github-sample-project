package jp.co.yumemi.android.code_check.data.sources

import jp.co.yumemi.android.code_check.data.models.ReleaseModel
import jp.co.yumemi.android.code_check.data.models.UserModel
import jp.co.yumemi.android.code_check.domain.entities.Release

interface RepositoriesRemoteDataSource {
    suspend fun getContributors(name: String, pageNumber: Int = 0, perPage: Int = 100, token: String? = null): List<UserModel>
    suspend fun getReleases(name: String, pageNumber: Int = 0, perPage: Int = 100, token: String? = null): List<ReleaseModel>
}
