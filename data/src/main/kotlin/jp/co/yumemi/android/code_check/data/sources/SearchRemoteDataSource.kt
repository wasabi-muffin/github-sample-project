package jp.co.yumemi.android.code_check.data.sources

import jp.co.yumemi.android.code_check.data.models.RepoSearchModel

interface SearchRemoteDataSource {
    suspend fun searchRepos(token: String? = null, searchText: String): List<RepoSearchModel>
}
