package jp.co.yumemi.android.code_check.data.repositories

import jp.co.yumemi.android.code_check.data.mappers.SearchMapper
import jp.co.yumemi.android.code_check.data.sources.SearchRemoteDataSource
import jp.co.yumemi.android.code_check.domain.entities.GithubRepo
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository

class SearchDataRepository(
    private val searchRemoteDataSource: SearchRemoteDataSource
) : SearchRepository {
    override suspend fun searchRepos(searchText: String): List<GithubRepo> =
        searchRemoteDataSource
            .searchRepos(searchText = searchText)
            .map(SearchMapper::modelToEntity)
}
