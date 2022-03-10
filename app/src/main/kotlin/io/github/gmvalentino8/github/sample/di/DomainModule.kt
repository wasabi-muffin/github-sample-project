package io.github.gmvalentino8.github.sample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import io.github.gmvalentino8.github.sample.domain.core.ErrorHandler
import io.github.gmvalentino8.github.sample.domain.entities.Issue
import io.github.gmvalentino8.github.sample.domain.entities.Organization
import io.github.gmvalentino8.github.sample.domain.entities.PullRequest
import io.github.gmvalentino8.github.sample.domain.entities.Repository
import io.github.gmvalentino8.github.sample.domain.entities.User
import io.github.gmvalentino8.github.sample.domain.repositories.RepositoriesRepository
import io.github.gmvalentino8.github.sample.domain.repositories.SearchRepository
import io.github.gmvalentino8.github.sample.domain.usecases.ClearRecentSearchesExecutor
import io.github.gmvalentino8.github.sample.domain.usecases.ClearRecentSearchesUseCase
import io.github.gmvalentino8.github.sample.domain.usecases.GetRecentSearchesExecutor
import io.github.gmvalentino8.github.sample.domain.usecases.GetRecentSearchesUseCase
import io.github.gmvalentino8.github.sample.domain.usecases.GetRepositoryDetailsExecutor
import io.github.gmvalentino8.github.sample.domain.usecases.GetRepositoryDetailsUseCase
import io.github.gmvalentino8.github.sample.domain.usecases.SearchAllExecutor
import io.github.gmvalentino8.github.sample.domain.usecases.SearchAllUseCase
import io.github.gmvalentino8.github.sample.domain.usecases.SearchIssuesExecutor
import io.github.gmvalentino8.github.sample.domain.usecases.SearchOrganizationsExecutor
import io.github.gmvalentino8.github.sample.domain.usecases.SearchPullRequestsExecutor
import io.github.gmvalentino8.github.sample.domain.usecases.SearchRepositoriesExecutor
import io.github.gmvalentino8.github.sample.domain.usecases.SearchUseCase
import io.github.gmvalentino8.github.sample.domain.usecases.SearchUsersExecutor

@Module
@InstallIn(ActivityRetainedComponent::class)
class DomainModule {
    @Provides
    fun provideSearchRepositoryUseCase(
        searchRepository: SearchRepository,
        errorHandler: ErrorHandler
    ): SearchUseCase<Repository> = SearchRepositoriesExecutor(searchRepository, errorHandler)

    @Provides
    fun provideSearchIssueUseCase(
        searchRepository: SearchRepository,
        errorHandler: ErrorHandler
    ): SearchUseCase<Issue> = SearchIssuesExecutor(searchRepository, errorHandler)

    @Provides
    fun provideSearchPullRequestUseCase(
        searchRepository: SearchRepository,
        errorHandler: ErrorHandler
    ): SearchUseCase<PullRequest> = SearchPullRequestsExecutor(searchRepository, errorHandler)

    @Provides
    fun provideSearchUserUseCase(
        searchRepository: SearchRepository,
        errorHandler: ErrorHandler
    ): SearchUseCase<User> = SearchUsersExecutor(searchRepository, errorHandler)

    @Provides
    fun provideSearchOrganizationUseCase(
        searchRepository: SearchRepository,
        errorHandler: ErrorHandler
    ): SearchUseCase<Organization> = SearchOrganizationsExecutor(searchRepository, errorHandler)

    @Provides
    fun provideSearchAllUseCase(
        searchRepository: SearchRepository,
        errorHandler: ErrorHandler,
    ): SearchAllUseCase = SearchAllExecutor(searchRepository, errorHandler)

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
