package jp.co.yumemi.android.code_check.remote.providers

import jp.co.yumemi.android.code_check.data.models.RepoSearchResultModel
import jp.co.yumemi.android.code_check.data.sources.SearchRemoteDataSource
import jp.co.yumemi.android.code_check.remote.apis.SearchApi
import jp.co.yumemi.android.code_check.remote.mappers.SearchMapper

class SearchRemoteDataProvider(
    private val searchApi: SearchApi
) : SearchRemoteDataSource {
    override suspend fun searchRepos(token: String?, searchText: String, pageNumber: Int): RepoSearchResultModel = searchApi
        .searchRepos(accessToken = token, q = searchText, page = pageNumber)
        .let { response ->
            RepoSearchResultModel(
                response.items.map(SearchMapper::apiToData),
                response.totalCount
            )
        }
}
