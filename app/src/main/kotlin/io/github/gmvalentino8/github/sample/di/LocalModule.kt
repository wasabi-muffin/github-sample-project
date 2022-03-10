package io.github.gmvalentino8.github.sample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import javax.inject.Qualifier
import io.github.gmvalentino8.github.sample.data.core.ExceptionHandler
import io.github.gmvalentino8.github.sample.data.sources.SearchLocalDataSource
import io.github.gmvalentino8.github.sample.data.utils.InstantProvider
import io.github.gmvalentino8.github.sample.local.core.AppDatabase
import io.github.gmvalentino8.github.sample.local.providers.SearchLocalDataProvider
import io.github.gmvalentino8.github.sample.remote.core.RemoteExceptionHandler

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
