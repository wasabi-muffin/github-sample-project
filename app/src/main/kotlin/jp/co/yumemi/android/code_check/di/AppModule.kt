package jp.co.yumemi.android.code_check.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jp.co.yumemi.android.code_check.data.error.DefaultErrorHandler
import jp.co.yumemi.android.code_check.domain.core.ErrorHandler
import jp.co.yumemi.android.code_check.local.core.AppDatabase
import jp.co.yumemi.android.code_check.remote.core.DefaultHttpClientProvider
import jp.co.yumemi.android.code_check.remote.core.HttpClientProvider

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideErrorHandler(): ErrorHandler = DefaultErrorHandler()

    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "app_database").build()

    @Provides
    fun provideHttpClientProvider(): HttpClientProvider = DefaultHttpClientProvider()
}
