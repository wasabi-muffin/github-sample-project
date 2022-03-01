package jp.co.yumemi.android.code_check.data.models

/**
 * Recent Search Data Model
 *
 * @property searchText search text for the search that was executed
 * @property timestamp time when the search was executed
 */
data class RecentSearchModel(
    val searchText: String,
    val timestamp: Long
)
