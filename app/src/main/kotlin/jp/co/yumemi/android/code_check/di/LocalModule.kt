package jp.co.yumemi.android.code_check.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import javax.inject.Qualifier
import jp.co.yumemi.android.code_check.data.error.ExceptionHandler
import jp.co.yumemi.android.code_check.data.sources.SearchLocalDataSource
import jp.co.yumemi.android.code_check.local.core.AppDatabase
import jp.co.yumemi.android.code_check.local.providers.SearchLocalDataProvider
import jp.co.yumemi.android.code_check.remote.error.RemoteExceptionHandler

@Module
@InstallIn(ActivityRetainedComponent::class)
class LocalModule {
    @Provides
    @Local
    fun provideRemoteExceptionHandler(): ExceptionHandler = RemoteExceptionHandler()

    @Provides
    fun provideLocalDataSource(
        database: AppDatabase,
        @Local exceptionHandler: ExceptionHandler,
    ): SearchLocalDataSource = SearchLocalDataProvider(database.searchDao(), exceptionHandler)
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Local
