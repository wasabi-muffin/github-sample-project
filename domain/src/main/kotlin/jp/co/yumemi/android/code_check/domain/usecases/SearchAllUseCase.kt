package jp.co.yumemi.android.code_check.domain.usecases

import jp.co.yumemi.android.code_check.domain.core.DomainResult
import jp.co.yumemi.android.code_check.domain.core.ErrorHandler
import jp.co.yumemi.android.code_check.domain.core.UseCase
import jp.co.yumemi.android.code_check.domain.core.toDomainResult
import jp.co.yumemi.android.code_check.domain.entities.SearchAll
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

interface SearchAllUseCase : UseCase<SearchUseCase.Args, DomainResult<SearchAll>> {
    data class Args(val searchText: String)
}

class SearchAllExecutor(
    private val searchRepository: SearchRepository,
    private val errorHandler: ErrorHandler,
) : SearchAllUseCase {
    override suspend fun execute(arguments: SearchUseCase.Args): DomainResult<SearchAll> = runCatching {
        coroutineScope {
            val repositories = async { searchRepository.searchRepositories(arguments.searchText) }
            val issues = async { searchRepository.searchIssues(arguments.searchText) }
            val pullRequests = async { searchRepository.searchPullRequests(arguments.searchText) }
            val users = async { searchRepository.searchUsers(arguments.searchText) }
            val organizations = async { searchRepository.searchOrganizations(arguments.searchText) }
            SearchAll(
                repositories = repositories.await(),
                issues = issues.await(),
                pullRequests = pullRequests.await(),
                people = users.await(),
                organizations = organizations.await()
            )
        }
    }.toDomainResult(errorHandler)
}
