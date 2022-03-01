package jp.co.yumemi.android.code_check.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Recent Search Entity
 *
 * @property searchText search text for the search that was executed
 * @property timestamp time when the search was executed
 */
@Parcelize
data class RecentSearch(
    val searchText: String,
    val timestamp: Long
) : Parcelable
