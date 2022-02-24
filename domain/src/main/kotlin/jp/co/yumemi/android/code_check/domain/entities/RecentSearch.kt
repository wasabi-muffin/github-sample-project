package jp.co.yumemi.android.code_check.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecentSearch(
    val searchText: String,
    val timestamp: Long
) : Parcelable
