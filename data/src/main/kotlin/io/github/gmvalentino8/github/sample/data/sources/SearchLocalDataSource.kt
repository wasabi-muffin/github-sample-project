package io.github.gmvalentino8.github.sample.data.sources

import io.github.gmvalentino8.github.sample.data.models.RecentSearchModel

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
