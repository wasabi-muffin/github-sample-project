package jp.co.yumemi.android.code_check.remote.providers

import jp.co.yumemi.android.code_check.data.models.RepoMinusSearchMinusResultMinusItemModel
import jp.co.yumemi.android.code_check.data.sources.SearchRemoteDataSource
import jp.co.yumemi.android.code_check.remote.apis.SearchApi

class SearchRemoteDataProvider(
    private val searchApi: SearchApi
) : SearchRemoteDataSource {
    override suspend fun searchRepos(
        token: String?, searchText: String
    ): List<RepoMinusSearchMinusResultMinusItemModel> = searchApi
        .searchRepos(accessToken = token, q = searchText)
        .items
}
