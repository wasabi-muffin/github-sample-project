package jp.co.yumemi.android.code_check.data.sources

import jp.co.yumemi.android.code_check.data.models.RecentSearchModel

interface SearchLocalDataSource {
    suspend fun saveRecentSearch(searchText: String)
    suspend fun getRecentSearches(): List<RecentSearchModel>
    suspend fun deleteAllRecentSearches()
}
