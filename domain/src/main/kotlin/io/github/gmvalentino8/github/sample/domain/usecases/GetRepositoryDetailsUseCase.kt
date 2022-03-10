package io.github.gmvalentino8.github.sample.domain.usecases

import io.github.gmvalentino8.github.sample.domain.core.DomainResult
import io.github.gmvalentino8.github.sample.domain.core.ErrorHandler
import io.github.gmvalentino8.github.sample.domain.core.UseCase
import io.github.gmvalentino8.github.sample.domain.core.runHandling
import io.github.gmvalentino8.github.sample.domain.entities.Repository
import io.github.gmvalentino8.github.sample.domain.entities.RepositoryDetails
import io.github.gmvalentino8.github.sample.domain.repositories.RepositoriesRepository
import io.github.gmvalentino8.github.sample.domain.utils.asyncGetOrNull
import kotlinx.coroutines.coroutineScope

/**
 * Get repository details use case
 *
 * Get details for a repository
 */
interface GetRepositoryDetailsUseCase : UseCase<GetRepositoryDetailsUseCase.Args, DomainResult<RepositoryDetails>> {
    data class Args(val repository: Repository)
}

class GetRepositoryDetailsExecutor(
    private val repositoriesRepository: RepositoriesRepository,
    private val errorHandler: ErrorHandler,
) : GetRepositoryDetailsUseCase {
    override suspend fun execute(arguments: GetRepositoryDetailsUseCase.Args): DomainResult<RepositoryDetails> = runHandling(errorHandler) {
        val (contributors, releases, pullRequests) = coroutineScope {
            val contributors = asyncGetOrNull { repositoriesRepository.getContributors(name = arguments.repository.name) }
            val releases = asyncGetOrNull { repositoriesRepository.getReleases(name = arguments.repository.name) }
            val pullRequests = asyncGetOrNull { repositoriesRepository.getPulls(name = arguments.repository.name) }
            Triple(contributors.await(), releases.await(), pullRequests.await())
        }
        RepositoryDetails(repository = arguments.repository, releases = releases, contributors = contributors, pullRequests = pullRequests)
    }
}
