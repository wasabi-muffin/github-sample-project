package jp.co.yumemi.android.code_check.domain.usecases

import jp.co.yumemi.android.code_check.domain.core.DomainResult
import jp.co.yumemi.android.code_check.domain.core.ErrorHandler
import jp.co.yumemi.android.code_check.domain.core.Pageable
import jp.co.yumemi.android.code_check.domain.core.UseCase
import jp.co.yumemi.android.code_check.domain.core.toDomainResult
import jp.co.yumemi.android.code_check.domain.entities.SimpleGithubRepo
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository

interface SearchRepoUseCase : UseCase<SearchRepoUseCase.Args, DomainResult<Pageable<SimpleGithubRepo>>> {
    data class Args(val searchText: String, val pageNumber: Int)
}

class SearchRepoExecutor(
    private val searchRepository: SearchRepository,
    private val errorHandler: ErrorHandler
) : SearchRepoUseCase {
    override suspend fun execute(
        arguments: SearchRepoUseCase.Args
    ): DomainResult<Pageable<SimpleGithubRepo>> = runCatching {
        searchRepository.searchRepos(arguments.searchText, arguments.pageNumber)
    }.toDomainResult(errorHandler)
}
