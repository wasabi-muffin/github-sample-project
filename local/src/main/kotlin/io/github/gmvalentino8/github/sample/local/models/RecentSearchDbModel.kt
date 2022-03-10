package io.github.gmvalentino8.github.sample.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Recent search db model
 *
 * @property searchText search text for the search that was executed
 * @property timestamp time when the search was executed
 */
@Entity
class RecentSearchDbModel(
    @PrimaryKey val searchText: String,
    val timestamp: Long
)
