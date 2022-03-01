package jp.co.yumemi.android.code_check.data.sources

import jp.co.yumemi.android.code_check.data.models.RecentSearchModel

interface SearchLocalDataSource {
    /**
     * Save recent search
     *
     * @param searchText text to save
     */
    suspend fun saveRecentSearch(searchText: String)

    /**
     * Get recent searches
     *
     * @return list of recent searches
     */
    suspend fun getRecentSearches(): List<RecentSearchModel>

    /**
     * Delete all recent searches
     */
    suspend fun deleteAllRecentSearches()
}
