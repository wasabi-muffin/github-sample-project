package io.github.gmvalentino8.github.sample.domain.usecases

import android.os.Parcelable
import io.github.gmvalentino8.github.sample.domain.core.DomainResult
import io.github.gmvalentino8.github.sample.domain.core.ErrorHandler
import io.github.gmvalentino8.github.sample.domain.entities.Pageable
import io.github.gmvalentino8.github.sample.domain.core.UseCase
import io.github.gmvalentino8.github.sample.domain.core.runHandling
import io.github.gmvalentino8.github.sample.domain.entities.Issue
import io.github.gmvalentino8.github.sample.domain.entities.Organization
import io.github.gmvalentino8.github.sample.domain.entities.PullRequest
import io.github.gmvalentino8.github.sample.domain.entities.Repository
import io.github.gmvalentino8.github.sample.domain.entities.User
import io.github.gmvalentino8.github.sample.domain.repositories.SearchRepository

/**
 * Search use case
 *
 * @param T type of the class to search for
 */
interface SearchUseCase<T : Parcelable> : UseCase<SearchUseCase.Args, DomainResult<Pageable<T>>> {
    data class Args(val searchText: String, val pageNumber: Int)
}

class SearchRepositoriesExecutor(
    private val searchRepository: SearchRepository,
    private val errorHandler: ErrorHandler
) : SearchUseCase<Repository> {
    override suspend fun execute(
        arguments: SearchUseCase.Args
    ): DomainResult<Pageable<Repository>> = runHandling(errorHandler) {
        searchRepository.searchRepositories(arguments.searchText, arguments.pageNumber)
    }
}

class SearchIssuesExecutor(
    private val searchRepository: SearchRepository,
    private val errorHandler: ErrorHandler
) : SearchUseCase<Issue> {
    override suspend fun execute(
        arguments: SearchUseCase.Args
    ): DomainResult<Pageable<Issue>> = runHandling(errorHandler) {
        searchRepository.searchIssues(arguments.searchText, arguments.pageNumber)
    }
}

class SearchPullRequestsExecutor(
    private val searchRepository: SearchRepository,
    private val errorHandler: ErrorHandler
) : SearchUseCase<PullRequest> {
    override suspend fun execute(
        arguments: SearchUseCase.Args
    ): DomainResult<Pageable<PullRequest>> = runHandling(errorHandler) {
        searchRepository.searchPullRequests(arguments.searchText, arguments.pageNumber)
    }
}

class SearchUsersExecutor(
    private val searchRepository: SearchRepository,
    private val errorHandler: ErrorHandler
) : SearchUseCase<User> {
    override suspend fun execute(
        arguments: SearchUseCase.Args
    ): DomainResult<Pageable<User>> = runHandling(errorHandler) {
        searchRepository.searchUsers(arguments.searchText, arguments.pageNumber)
    }
}

class SearchOrganizationsExecutor(
    private val searchRepository: SearchRepository,
    private val errorHandler: ErrorHandler
) : SearchUseCase<Organization> {
    override suspend fun execute(
        arguments: SearchUseCase.Args
    ): DomainResult<Pageable<Organization>> = runHandling(errorHandler) {
        searchRepository.searchOrganizations(arguments.searchText, arguments.pageNumber)
    }
}
