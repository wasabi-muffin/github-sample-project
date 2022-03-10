package io.github.gmvalentino8.github.sample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import javax.inject.Qualifier
import io.github.gmvalentino8.github.sample.data.core.ExceptionHandler
import io.github.gmvalentino8.github.sample.data.sources.RepositoriesRemoteDataSource
import io.github.gmvalentino8.github.sample.data.sources.SearchRemoteDataSource
import io.github.gmvalentino8.github.sample.remote.apis.PullsApi
import io.github.gmvalentino8.github.sample.remote.apis.ReposApi
import io.github.gmvalentino8.github.sample.remote.apis.SearchApi
import io.github.gmvalentino8.github.sample.remote.core.RemoteExceptionHandler
import io.github.gmvalentino8.github.sample.remote.providers.RepositoriesRemoteDataProvider
import io.github.gmvalentino8.github.sample.remote.providers.SearchRemoteDataProvider

@Module
@InstallIn(ActivityRetainedComponent::class)
class RemoteModule {
    @Provides
    @Remote
    fun provideRemoteExceptionHandler(): ExceptionHandler = RemoteExceptionHandler()

    @Provides
    fun provideSearchRemoteDataSource(
        searchApi: SearchApi,
        @Remote exceptionHandler: ExceptionHandler,
    ): SearchRemoteDataSource = SearchRemoteDataProvider(searchApi, exceptionHandler)

    @Provides
    fun provideRepositoriesRemoteDataSource(
        reposApi: ReposApi,
        pullsApi: PullsApi,
        @Remote exceptionHandler: ExceptionHandler,
    ): RepositoriesRemoteDataSource = RepositoriesRemoteDataProvider(reposApi, pullsApi, exceptionHandler)
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Remote
