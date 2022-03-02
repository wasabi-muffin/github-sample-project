package jp.co.yumemi.android.code_check.local.providers

import jp.co.yumemi.android.code_check.data.core.ExceptionHandler
import jp.co.yumemi.android.code_check.data.core.runHandling
import jp.co.yumemi.android.code_check.data.models.RecentSearchModel
import jp.co.yumemi.android.code_check.data.sources.SearchLocalDataSource
import jp.co.yumemi.android.code_check.data.utils.InstantProvider
import jp.co.yumemi.android.code_check.local.dao.SearchDao
import jp.co.yumemi.android.code_check.local.mappers.RecentSearchLocalMapper
import jp.co.yumemi.android.code_check.local.models.RecentSearchDbModel

/**
 * Search local data provider
 *
 * Default implementation for [SearchLocalDataSource]
 */
class SearchLocalDataProvider(
    private val searchDao: SearchDao,
    private val instantProvider: InstantProvider,
    private val exceptionHandler: ExceptionHandler,
) : SearchLocalDataSource {
    override suspend fun saveRecentSearch(searchText: String) = runHandling(exceptionHandler) {
        searchDao.insertAll(
            RecentSearchDbModel(
                searchText = searchText,
                timestamp = instantProvider.now().epochSeconds
            )
        )
    }

    override suspend fun getRecentSearches(): List<RecentSearchModel> = runHandling(exceptionHandler) {
        searchDao
            .getAll()
            .map(RecentSearchLocalMapper::dbToData)
    }

    override suspend fun deleteAllRecentSearches() = runHandling(exceptionHandler) {
        searchDao.deleteAll()
    }
}
