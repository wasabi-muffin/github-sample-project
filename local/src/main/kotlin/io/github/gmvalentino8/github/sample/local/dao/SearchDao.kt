package io.github.gmvalentino8.github.sample.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.gmvalentino8.github.sample.local.models.RecentSearchDbModel

@Dao
interface SearchDao {
    /**
     * Insert all
     *
     * Save recent search to database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg recentSearch: RecentSearchDbModel)

    /**
     * Get all
     *
     * Get all recent searches from database
     */
    @Query("SELECT * FROM recentsearchdbmodel")
    suspend fun getAll(): List<RecentSearchDbModel>

    /**
     * Delete all
     *
     * Delete all recent searches from database
     */
    @Query("DELETE FROM recentsearchdbmodel")
    suspend fun deleteAll()
}
