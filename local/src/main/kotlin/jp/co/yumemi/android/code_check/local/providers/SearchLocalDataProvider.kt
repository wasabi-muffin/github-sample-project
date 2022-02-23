package jp.co.yumemi.android.code_check.local.providers

import jp.co.yumemi.android.code_check.data.models.RecentSearchModel
import jp.co.yumemi.android.code_check.data.sources.SearchLocalDataSource
import jp.co.yumemi.android.code_check.local.dao.SearchDao
import jp.co.yumemi.android.code_check.local.mappers.RecentSearchMapper
import jp.co.yumemi.android.code_check.local.models.RecentSearchDbModel
import kotlinx.datetime.Clock

class SearchLocalDataProvider(
    private val searchDao: SearchDao
) : SearchLocalDataSource {
    override suspend fun saveRecentSearch(searchText: String) {
        searchDao.insertAll(
            RecentSearchDbModel(
                searchText = searchText,
                timestamp = Clock.System.now().epochSeconds
            )
        )
    }

    override suspend fun getRecentSearches(): List<RecentSearchModel> = searchDao
        .getAll()
        .map(RecentSearchMapper::dbToData)
}
