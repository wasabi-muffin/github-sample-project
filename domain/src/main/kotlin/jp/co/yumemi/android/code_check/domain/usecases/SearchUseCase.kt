package jp.co.yumemi.android.code_check.domain.usecases

import android.os.Parcelable
import jp.co.yumemi.android.code_check.domain.core.DomainResult
import jp.co.yumemi.android.code_check.domain.core.ErrorHandler
import jp.co.yumemi.android.code_check.domain.core.Pageable
import jp.co.yumemi.android.code_check.domain.core.UseCase
import jp.co.yumemi.android.code_check.domain.core.runHandling
import jp.co.yumemi.android.code_check.domain.core.toDomainResult
import jp.co.yumemi.android.code_check.domain.entities.Issue
import jp.co.yumemi.android.code_check.domain.entities.Organization
import jp.co.yumemi.android.code_check.domain.entities.PullRequest
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.entities.User
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository

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
