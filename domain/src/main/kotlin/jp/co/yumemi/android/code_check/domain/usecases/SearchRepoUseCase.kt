package jp.co.yumemi.android.code_check.domain.usecases

import jp.co.yumemi.android.code_check.domain.core.DomainResult
import jp.co.yumemi.android.code_check.domain.core.ErrorHandler
import jp.co.yumemi.android.code_check.domain.core.UseCase
import jp.co.yumemi.android.code_check.domain.core.toDomainResult
import jp.co.yumemi.android.code_check.domain.entities.GithubRepo
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository

interface SearchRepoUseCase : UseCase<SearchRepoUseCase.Args, DomainResult<List<GithubRepo>>> {
    data class Args(val searchText: String)
}

class SearchRepoExecutor(
    private val searchRepository: SearchRepository,
    private val errorHandler: ErrorHandler
) : SearchRepoUseCase {
    override suspend fun execute(
        arguments: SearchRepoUseCase.Args
    ): DomainResult<List<GithubRepo>> = runCatching {
        searchRepository.searchRepos(arguments.searchText)
    }.toDomainResult(errorHandler)
}
