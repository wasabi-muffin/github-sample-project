package jp.co.yumemi.android.code_check.data.models

/**
 * Search Results Data Model
 *
 * Wrapper for search results
 *
 * @property items list of results
 * @property totalCount total count of all results (including those of which have not yet been paged)
 */
data class SearchResultModel<T>(
    val items: List<T>,
    val totalCount: Int
)
