package jp.co.yumemi.android.code_check.remote.providers

import jp.co.yumemi.android.code_check.data.models.RepositoryModel
import jp.co.yumemi.android.code_check.data.models.SearchResultModel
import jp.co.yumemi.android.code_check.data.sources.SearchRemoteDataSource
import jp.co.yumemi.android.code_check.remote.apis.SearchApi
import jp.co.yumemi.android.code_check.remote.mappers.SearchRemoteMapper

class SearchRemoteDataProvider(
    private val searchApi: SearchApi
) : SearchRemoteDataSource {
    override suspend fun searchRepos(token: String?, searchText: String, pageNumber: Int): SearchResultModel<RepositoryModel> = searchApi
        .searchRepos(accessToken = token, q = searchText, page = pageNumber)
        .let { response ->
            SearchResultModel(
                response.items.map(SearchRemoteMapper::toModel),
                response.totalCount
            )
        }
}
