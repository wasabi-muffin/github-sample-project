package jp.co.yumemi.android.code_check.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.android.code_check.data.repositories.RepositoriesDataRepository
import jp.co.yumemi.android.code_check.data.sources.RepositoriesRemoteDataSource
import jp.co.yumemi.android.code_check.data.sources.SearchLocalDataSource
import jp.co.yumemi.android.code_check.data.sources.SearchRemoteDataSource
import jp.co.yumemi.android.code_check.domain.repositories.RepositoriesRepository
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository

@Module
@InstallIn(ActivityRetainedComponent::class)
class DataModule {
    @Provides
    fun provideSearchRepository(
        searchRemoteDataSource: SearchRemoteDataSource,
        searchLocalDataSource: SearchLocalDataSource,
    ): SearchRepository = SearchDataRepository(searchRemoteDataSource, searchLocalDataSource)

    @Provides
    fun provideRepositoriesRepository(
        repositoriesRemoteDataSource: RepositoriesRemoteDataSource
    ): RepositoriesRepository = RepositoriesDataRepository(repositoriesRemoteDataSource)
}