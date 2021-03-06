package io.github.gmvalentino8.github.sample.domain.usecases

import io.github.gmvalentino8.github.sample.domain.core.DomainResult
import io.github.gmvalentino8.github.sample.domain.core.ErrorHandler
import io.github.gmvalentino8.github.sample.domain.core.UseCase
import io.github.gmvalentino8.github.sample.domain.core.runHandling
import io.github.gmvalentino8.github.sample.domain.entities.SearchAll
import io.github.gmvalentino8.github.sample.domain.repositories.SearchRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

/**
 * Search all use case
 *
 * Perform a search for each search option and return the aggregated results
 */
interface SearchAllUseCase : UseCase<SearchAllUseCase.Args, DomainResult<SearchAll>> {
    data class Args(val searchText: String)
}

class SearchAllExecutor(
    private val searchRepository: SearchRepository,
    private val errorHandler: ErrorHandler,
) : SearchAllUseCase {
    override suspend fun execute(arguments: SearchAllUseCase.Args): DomainResult<SearchAll> = runHandling(errorHandler) {
        coroutineScope {
            val itemCount = 3
            val repositories = async { searchRepository.searchRepositories(searchText = arguments.searchText, count = itemCount) }
            val issues = async { searchRepository.searchIssues(searchText = arguments.searchText, count = itemCount) }
            val pullRequests = async { searchRepository.searchPullRequests(searchText = arguments.searchText, count = itemCount) }
            val users = async { searchRepository.searchUsers(searchText = arguments.searchText, count = itemCount) }
            val organizations = async { searchRepository.searchOrganizations(searchText = arguments.searchText, count = itemCount) }
            SearchAll(
                repositories = repositories.await(),
                issues = issues.await(),
                pullRequests = pullRequests.await(),
                people = users.await(),
                organizations = organizations.await()
            )
        }
    }
}
