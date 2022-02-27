package jp.co.yumemi.android.code_check.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.android.code_check.domain.core.ErrorHandler
import jp.co.yumemi.android.code_check.domain.entities.Issue
import jp.co.yumemi.android.code_check.domain.entities.PullRequest
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.repositories.RepositoriesRepository
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository
import jp.co.yumemi.android.code_check.domain.usecases.ClearRecentSearchesExecutor
import jp.co.yumemi.android.code_check.domain.usecases.ClearRecentSearchesUseCase
import jp.co.yumemi.android.code_check.domain.usecases.GetRecentSearchesExecutor
import jp.co.yumemi.android.code_check.domain.usecases.GetRecentSearchesUseCase
import jp.co.yumemi.android.code_check.domain.usecases.GetRepositoryDetailsExecutor
import jp.co.yumemi.android.code_check.domain.usecases.GetRepositoryDetailsUseCase
import jp.co.yumemi.android.code_check.domain.usecases.SearchIssuesExecutor
import jp.co.yumemi.android.code_check.domain.usecases.SearchPullRequestsExecutor
import jp.co.yumemi.android.code_check.domain.usecases.SearchRepoUseCase
import jp.co.yumemi.android.code_check.domain.usecases.SearchRepositoryExecutor

@Module
@InstallIn(ActivityRetainedComponent::class)
class DomainModule {
    @Provides
    fun provideSearchRepositoryUseCase(
        searchRepository: SearchRepository,
        errorHandler: ErrorHandler
    ): SearchRepoUseCase<Repository> = SearchRepositoryExecutor(searchRepository, errorHandler)

    @Provides
    fun provideSearchIssueUseCase(
        searchRepository: SearchRepository,
        errorHandler: ErrorHandler
    ): SearchRepoUseCase<Issue> = SearchIssuesExecutor(searchRepository, errorHandler)

    @Provides
    fun provideSearchPullRequestUseCase(
        searchRepository: SearchRepository,
        errorHandler: ErrorHandler
    ): SearchRepoUseCase<PullRequest> = SearchPullRequestsExecutor(searchRepository, errorHandler)

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
