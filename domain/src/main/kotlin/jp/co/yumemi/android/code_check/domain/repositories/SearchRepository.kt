package jp.co.yumemi.android.code_check.domain.repositories

import jp.co.yumemi.android.code_check.domain.core.Pageable
import jp.co.yumemi.android.code_check.domain.entities.SimpleGithubRepo
import jp.co.yumemi.android.code_check.domain.entities.RecentSearch

interface SearchRepository {
    suspend fun searchRepos(searchText: String, pageNumber: Int = 0): Pageable<SimpleGithubRepo>
    suspend fun getRecentSearches(): List<RecentSearch>
    suspend fun clearRecentSearches()
}
