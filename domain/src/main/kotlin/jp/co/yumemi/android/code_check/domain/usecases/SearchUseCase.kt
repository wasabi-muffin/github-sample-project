package jp.co.yumemi.android.code_check.domain.usecases

import android.os.Parcelable
import jp.co.yumemi.android.code_check.domain.core.DomainResult
import jp.co.yumemi.android.code_check.domain.core.ErrorHandler
import jp.co.yumemi.android.code_check.domain.core.Pageable
import jp.co.yumemi.android.code_check.domain.core.UseCase
import jp.co.yumemi.android.code_check.domain.core.toDomainResult
import jp.co.yumemi.android.code_check.domain.entities.Issue
import jp.co.yumemi.android.code_check.domain.entities.Organization
import jp.co.yumemi.android.code_check.domain.entities.PullRequest
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.entities.User
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository

interface SearchRepoUseCase<T : Parcelable> : UseCase<SearchRepoUseCase.Args, DomainResult<Pageable<T>>> {
    data class Args(val searchText: String, val pageNumber: Int)
}

class SearchRepositoryExecutor(
    private val searchRepository: SearchRepository,
    private val errorHandler: ErrorHandler
) : SearchRepoUseCase<Repository> {
    override suspend fun execute(
        arguments: SearchRepoUseCase.Args
    ): DomainResult<Pageable<Repository>> = runCatching {
        searchRepository.searchRepositories(arguments.searchText, arguments.pageNumber)
    }.toDomainResult(errorHandler)
}

class SearchIssuesExecutor(
    private val searchRepository: SearchRepository,
    private val errorHandler: ErrorHandler
) : SearchRepoUseCase<Issue> {
    override suspend fun execute(
        arguments: SearchRepoUseCase.Args
    ): DomainResult<Pageable<Issue>> = runCatching {
        searchRepository.searchIssues(arguments.searchText, arguments.pageNumber)
    }.toDomainResult(errorHandler)
}

class SearchPullRequestsExecutor(
    private val searchRepository: SearchRepository,
    private val errorHandler: ErrorHandler
) : SearchRepoUseCase<PullRequest> {
    override suspend fun execute(
        arguments: SearchRepoUseCase.Args
    ): DomainResult<Pageable<PullRequest>> = runCatching {
        searchRepository.searchPullRequests(arguments.searchText, arguments.pageNumber)
    }.toDomainResult(errorHandler)
}

class SearchUsersExecutor(
    private val searchRepository: SearchRepository,
    private val errorHandler: ErrorHandler
) : SearchRepoUseCase<User> {
    override suspend fun execute(
        arguments: SearchRepoUseCase.Args
    ): DomainResult<Pageable<User>> = runCatching {
        searchRepository.searchUsers(arguments.searchText, arguments.pageNumber)
    }.toDomainResult(errorHandler)
}

class SearchOrganizationExecutor(
    private val searchRepository: SearchRepository,
    private val errorHandler: ErrorHandler
) : SearchRepoUseCase<Organization> {
    override suspend fun execute(
        arguments: SearchRepoUseCase.Args
    ): DomainResult<Pageable<Organization>> = runCatching {
        searchRepository.searchOrganizations(arguments.searchText, arguments.pageNumber)
    }.toDomainResult(errorHandler)
}
