package jp.co.yumemi.android.code_check.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.android.code_check.data.sources.SearchLocalDataSource
import jp.co.yumemi.android.code_check.local.core.AppDatabase
import jp.co.yumemi.android.code_check.local.providers.SearchLocalDataProvider

@Module
@InstallIn(ActivityRetainedComponent::class)
class LocalModule {
    @Provides
    fun provideLocalDataSource(
        database: AppDatabase
    ): SearchLocalDataSource = SearchLocalDataProvider(database.searchDao())
}
