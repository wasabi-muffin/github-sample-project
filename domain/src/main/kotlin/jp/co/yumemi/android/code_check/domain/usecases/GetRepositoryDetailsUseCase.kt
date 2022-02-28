package jp.co.yumemi.android.code_check.domain.usecases

import jp.co.yumemi.android.code_check.domain.core.DomainResult
import jp.co.yumemi.android.code_check.domain.core.ErrorHandler
import jp.co.yumemi.android.code_check.domain.core.UseCase
import jp.co.yumemi.android.code_check.domain.core.runHandling
import jp.co.yumemi.android.code_check.domain.core.toDomainResult
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.entities.RepositoryDetails
import jp.co.yumemi.android.code_check.domain.repositories.RepositoriesRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

interface GetRepositoryDetailsUseCase : UseCase<GetRepositoryDetailsUseCase.Args, DomainResult<RepositoryDetails>> {
    data class Args(val repo: Repository)
}

class GetRepositoryDetailsExecutor(
    private val repositoriesRepository: RepositoriesRepository,
    private val errorHandler: ErrorHandler,
) : GetRepositoryDetailsUseCase {
    override suspend fun execute(arguments: GetRepositoryDetailsUseCase.Args): DomainResult<RepositoryDetails> = runHandling(errorHandler) {
        val (contributors, releases, pullRequests) = coroutineScope {
            val contributors = async {
                runCatching {
                    repositoriesRepository.getContributors(name = arguments.repo.name)
                }.getOrNull()
            }
            val releases = async {
                runCatching {
                    repositoriesRepository.getReleases(name = arguments.repo.name)
                }.getOrNull()
            }
            val pullRequests = async {
                runCatching {
                    repositoriesRepository.getPulls(name = arguments.repo.name)
                }.getOrNull()
            }
            Triple(contributors.await(), releases.await(), pullRequests.await())
        }
        RepositoryDetails(repository = arguments.repo, releases = releases, contributors = contributors, pullRequests = pullRequests)
    }
}
