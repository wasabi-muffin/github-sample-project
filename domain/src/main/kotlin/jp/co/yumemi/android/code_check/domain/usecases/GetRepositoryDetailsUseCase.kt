package jp.co.yumemi.android.code_check.domain.usecases

import jp.co.yumemi.android.code_check.domain.core.DomainResult
import jp.co.yumemi.android.code_check.domain.core.ErrorHandler
import jp.co.yumemi.android.code_check.domain.core.UseCase
import jp.co.yumemi.android.code_check.domain.core.runHandling
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.entities.RepositoryDetails
import jp.co.yumemi.android.code_check.domain.repositories.RepositoriesRepository
import jp.co.yumemi.android.code_check.domain.utils.asyncGetOrNull
import kotlinx.coroutines.coroutineScope

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
