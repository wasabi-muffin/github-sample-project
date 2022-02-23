package jp.co.yumemi.android.code_check.data.sources

import jp.co.yumemi.android.code_check.data.models.RepoMinusSearchMinusResultMinusItemModel

interface SearchRemoteDataSource {
    suspend fun searchRepos(token: String? = null, searchText: String): List<RepoMinusSearchMinusResultMinusItemModel>
}
