package io.github.gmvalentino8.github.sample.local.providers

import io.github.gmvalentino8.github.sample.data.core.ExceptionHandler
import io.github.gmvalentino8.github.sample.data.core.runHandling
import io.github.gmvalentino8.github.sample.data.models.RecentSearchModel
import io.github.gmvalentino8.github.sample.data.sources.SearchLocalDataSource
import io.github.gmvalentino8.github.sample.data.utils.InstantProvider
import io.github.gmvalentino8.github.sample.local.dao.SearchDao
import io.github.gmvalentino8.github.sample.local.mappers.RecentSearchLocalMapper
import io.github.gmvalentino8.github.sample.local.models.RecentSearchDbModel

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
