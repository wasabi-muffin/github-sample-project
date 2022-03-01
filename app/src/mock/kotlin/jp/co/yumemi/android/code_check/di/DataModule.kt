package jp.co.yumemi.android.code_check.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.android.code_check.data.repositories.RepositoriesMockRepository
import jp.co.yumemi.android.code_check.data.repositories.SearchMockRepository
import jp.co.yumemi.android.code_check.domain.repositories.RepositoriesRepository
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository

@Module
@InstallIn(ActivityRetainedComponent::class)
class DataModule {
    @Provides
    fun provideSearchRepository(): SearchRepository = SearchMockRepository()

    @Provides
    fun provideRepositoriesRepository(): RepositoriesRepository = RepositoriesMockRepository()
}
