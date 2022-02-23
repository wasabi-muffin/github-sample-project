package jp.co.yumemi.android.code_check.local.core

import androidx.room.Database
import androidx.room.RoomDatabase
import jp.co.yumemi.android.code_check.local.dao.SearchDao
import jp.co.yumemi.android.code_check.local.models.RecentSearchDbModel

@Database(entities = [RecentSearchDbModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun searchDao(): SearchDao
}
