package jp.co.yumemi.android.code_check.local.core

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

fun interface DatabaseProvider<T : RoomDatabase> {
    fun provide(klass: Class<T>, name: String): T
}

class DefaultDatabaseProvider<T : RoomDatabase>(
    private val context: Context,
) : DatabaseProvider<T> {
    override fun provide(
        klass: Class<T>,
        name: String
    ): T = Room.databaseBuilder(context, klass, name).build()
}
