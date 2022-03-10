package io.github.gmvalentino8.github.sample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import io.github.gmvalentino8.github.sample.data.repositories.RepositoriesMockRepository
import io.github.gmvalentino8.github.sample.data.repositories.SearchMockRepository
import io.github.gmvalentino8.github.sample.domain.repositories.RepositoriesRepository
import io.github.gmvalentino8.github.sample.domain.repositories.SearchRepository

@Module
@InstallIn(ActivityRetainedComponent::class)
class DataModule {
    @Provides
    fun provideSearchRepository(): SearchRepository = SearchMockRepository()

    @Provides
    fun provideRepositoriesRepository(): RepositoriesRepository = RepositoriesMockRepository()
}
