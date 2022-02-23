package jp.co.yumemi.android.code_check.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RecentSearchDbModel(
    @PrimaryKey val searchText: String,
    val timestamp: Long
)
