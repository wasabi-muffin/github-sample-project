package jp.co.yumemi.android.code_check.data.sources

import jp.co.yumemi.android.code_check.data.models.RepositoryModel
import jp.co.yumemi.android.code_check.data.models.SearchResultModel

interface SearchRemoteDataSource {
    suspend fun searchRepos(token: String? = null, searchText: String, pageNumber: Int = 0): SearchResultModel<RepositoryModel>
}
