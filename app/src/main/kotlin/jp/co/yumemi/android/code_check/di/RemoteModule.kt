package jp.co.yumemi.android.code_check.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import javax.inject.Qualifier
import jp.co.yumemi.android.code_check.data.error.ExceptionHandler
import jp.co.yumemi.android.code_check.data.sources.RepositoriesRemoteDataSource
import jp.co.yumemi.android.code_check.data.sources.SearchRemoteDataSource
import jp.co.yumemi.android.code_check.remote.apis.PullsApi
import jp.co.yumemi.android.code_check.remote.apis.ReposApi
import jp.co.yumemi.android.code_check.remote.apis.SearchApi
import jp.co.yumemi.android.code_check.remote.core.RemoteExceptionHandler
import jp.co.yumemi.android.code_check.remote.providers.RepositoriesRemoteDataProvider
import jp.co.yumemi.android.code_check.remote.providers.SearchRemoteDataProvider

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
