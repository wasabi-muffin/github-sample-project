package jp.co.yumemi.android.code_check.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.android.code_check.domain.core.ErrorHandler
import jp.co.yumemi.android.code_check.domain.repositories.RepositoriesRepository
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository
import jp.co.yumemi.android.code_check.domain.usecases.ClearRecentSearchesExecutor
import jp.co.yumemi.android.code_check.domain.usecases.ClearRecentSearchesUseCase
import jp.co.yumemi.android.code_check.domain.usecases.GetRecentSearchesExecutor
import jp.co.yumemi.android.code_check.domain.usecases.GetRecentSearchesUseCase
import jp.co.yumemi.android.code_check.domain.usecases.GetRepositoryDetailsExecutor
import jp.co.yumemi.android.code_check.domain.usecases.GetRepositoryDetailsUseCase
import jp.co.yumemi.android.code_check.domain.usecases.SearchRepoExecutor
import jp.co.yumemi.android.code_check.domain.usecases.SearchRepoUseCase

@Module
@InstallIn(ActivityRetainedComponent::class)
class DomainModule {
    @Provides
    fun provideSearchRepoUseCase(
        searchRepository: SearchRepository,
        errorHandler: ErrorHandler
    ): SearchRepoUseCase = SearchRepoExecutor(searchRepository, errorHandler)

    @Provides
    fun provideClearRecentSearchesUseCase(
        searchRepository: SearchRepository
    ): ClearRecentSearchesUseCase = ClearRecentSearchesExecutor(searchRepository)

    @Provides
    fun provideGetRecentSearchesUseCase(
        searchRepository: SearchRepository
    ): GetRecentSearchesUseCase = GetRecentSearchesExecutor(searchRepository)

    @Provides
    fun provideGetRepositoryDetailsUseCase(
        repositoriesRepository: RepositoriesRepository,
        errorHandler: ErrorHandler
    ): GetRepositoryDetailsUseCase = GetRepositoryDetailsExecutor(repositoriesRepository, errorHandler)
}
