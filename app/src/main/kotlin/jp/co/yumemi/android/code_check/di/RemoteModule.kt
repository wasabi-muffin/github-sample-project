package jp.co.yumemi.android.code_check.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.android.code_check.data.sources.RepositoriesRemoteDataSource
import jp.co.yumemi.android.code_check.data.sources.SearchRemoteDataSource
import jp.co.yumemi.android.code_check.remote.apis.ReposApi
import jp.co.yumemi.android.code_check.remote.apis.SearchApi
import jp.co.yumemi.android.code_check.remote.providers.RepositoriesRemoteDataProvider
import jp.co.yumemi.android.code_check.remote.providers.SearchRemoteDataProvider

@Module
@InstallIn(ActivityRetainedComponent::class)
class RemoteModule {
    @Provides
    fun provideSearchRemoteDataSource(
        searchApi: SearchApi
    ): SearchRemoteDataSource = SearchRemoteDataProvider(searchApi)

    @Provides
    fun provideRepositoriesRemoteDataSource(
        reposApi: ReposApi
    ): RepositoriesRemoteDataSource = RepositoriesRemoteDataProvider(reposApi)
}
