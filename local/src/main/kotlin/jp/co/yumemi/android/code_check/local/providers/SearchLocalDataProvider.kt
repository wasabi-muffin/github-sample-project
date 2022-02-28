package jp.co.yumemi.android.code_check.local.providers

import jp.co.yumemi.android.code_check.data.models.RecentSearchModel
import jp.co.yumemi.android.code_check.data.sources.SearchLocalDataSource
import jp.co.yumemi.android.code_check.local.dao.SearchDao
import jp.co.yumemi.android.code_check.local.error.runHandling
import jp.co.yumemi.android.code_check.local.mappers.RecentSearchLocalMapper
import jp.co.yumemi.android.code_check.local.models.RecentSearchDbModel
import kotlinx.datetime.Clock

class SearchLocalDataProvider(
    private val searchDao: SearchDao
) : SearchLocalDataSource {
    override suspend fun saveRecentSearch(searchText: String) = runHandling {
        searchDao.insertAll(
            RecentSearchDbModel(
                searchText = searchText,
                timestamp = Clock.System.now().epochSeconds
            )
        )
    }

    override suspend fun getRecentSearches(): List<RecentSearchModel> = runHandling {
        searchDao
            .getAll()
            .map(RecentSearchLocalMapper::dbToData)
    }

    override suspend fun deleteAllRecentSearches() = runHandling {
        searchDao.deleteAll()
    }
}
