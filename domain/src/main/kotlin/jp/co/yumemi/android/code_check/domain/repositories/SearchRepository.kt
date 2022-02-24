package jp.co.yumemi.android.code_check.domain.repositories

import jp.co.yumemi.android.code_check.domain.entities.GithubRepo
import jp.co.yumemi.android.code_check.domain.entities.RecentSearch

interface SearchRepository {
    suspend fun searchRepos(searchText: String): List<GithubRepo>
    suspend fun getRecentSearches(): List<RecentSearch>
    suspend fun clearRecentSearches()
}
