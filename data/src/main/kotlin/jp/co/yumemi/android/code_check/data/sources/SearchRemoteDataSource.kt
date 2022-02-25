package jp.co.yumemi.android.code_check.data.sources

import jp.co.yumemi.android.code_check.data.models.RepoSearchResultModel

interface SearchRemoteDataSource {
    suspend fun searchRepos(token: String? = null, searchText: String, pageNumber: Int = 0): RepoSearchResultModel
}
