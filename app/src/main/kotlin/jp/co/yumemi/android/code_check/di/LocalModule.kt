package jp.co.yumemi.android.code_check.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import javax.inject.Qualifier
import jp.co.yumemi.android.code_check.data.core.ExceptionHandler
import jp.co.yumemi.android.code_check.data.sources.SearchLocalDataSource
import jp.co.yumemi.android.code_check.data.utils.InstantProvider
import jp.co.yumemi.android.code_check.local.core.AppDatabase
import jp.co.yumemi.android.code_check.local.providers.SearchLocalDataProvider
import jp.co.yumemi.android.code_check.remote.core.RemoteExceptionHandler

@Module
@InstallIn(ActivityRetainedComponent::class)
class LocalModule {
    @Provides
    @Local
    fun provideRemoteExceptionHandler(): ExceptionHandler = RemoteExceptionHandler()

    @Provides
    fun provideLocalDataSource(
        database: AppDatabase,
        instantProvider: InstantProvider,
        @Local exceptionHandler: ExceptionHandler,
    ): SearchLocalDataSource = SearchLocalDataProvider(database.searchDao(), instantProvider, exceptionHandler)
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Local
