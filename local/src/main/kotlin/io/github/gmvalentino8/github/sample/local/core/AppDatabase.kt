package io.github.gmvalentino8.github.sample.local.core

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.gmvalentino8.github.sample.local.dao.SearchDao
import io.github.gmvalentino8.github.sample.local.models.RecentSearchDbModel

@Database(entities = [RecentSearchDbModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun searchDao(): SearchDao
}
