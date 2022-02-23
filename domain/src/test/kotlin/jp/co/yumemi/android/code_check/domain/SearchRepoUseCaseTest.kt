package jp.co.yumemi.android.code_check.domain

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import jp.co.yumemi.android.code_check.domain.core.DomainError
import jp.co.yumemi.android.code_check.domain.core.DomainResult
import jp.co.yumemi.android.code_check.domain.core.ErrorHandler
import jp.co.yumemi.android.code_check.domain.entities.GithubRepo
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository
import jp.co.yumemi.android.code_check.domain.usecases.SearchRepoExecutor
import jp.co.yumemi.android.code_check.domain.usecases.SearchRepoUseCase
import jp.co.yumemi.android.code_check.test.CoroutineTestRule
import jp.co.yumemi.android.code_check.test.runBlockingTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchRepoUseCaseTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()
    private val searchRepository = mockk<SearchRepository>()
    private val errorHandler = mockk<ErrorHandler>()
    private val testException = Exception("test")
    private val searchRepoUseCase = SearchRepoExecutor(searchRepository, errorHandler)

    @Test
    fun `test when execute is successful`() {
        coEvery {
            searchRepository.searchRepos(any())
        } returns List(5) { index ->
            GithubRepo(
                "name$index",
                ownerIconUrl = "ownerIconUrl$index",
                language = "language$index",
                stargazersCount = index,
                watchersCount = index,
                forksCount = index,
                openIssuesCount = index
            )
        }

        coroutineTestRule.runBlockingTest {
            val result = searchRepoUseCase.execute(SearchRepoUseCase.Args(""))
            result.shouldBeTypeOf<DomainResult.Success<List<GithubRepo>>>()
            result.data.size shouldBe 5
            result.data.forEachIndexed { index, repo ->
                repo.name shouldBe "name$index"
                repo.ownerIconUrl shouldBe "ownerIconUrl$index"
                repo.language shouldBe "language$index"
                repo.stargazersCount shouldBe index
                repo.watchersCount shouldBe index
                repo.forksCount shouldBe index
                repo.openIssuesCount shouldBe index
            }
            coVerify { searchRepository.searchRepos("") }
            coVerify(inverse = true) { errorHandler.handleError(any()) }
        }
    }

    @Test
    fun `test when repository throws an error and execute fails`() {
        coEvery {
            searchRepository.searchRepos(any())
        } throws testException

        every { errorHandler.handleError(any()) } returns DomainError.Unknown(testException)

        coroutineTestRule.runBlockingTest {
            val result = searchRepoUseCase.execute(SearchRepoUseCase.Args(""))
            result.shouldBeTypeOf<DomainResult.Failure>()
            result.error.shouldBeTypeOf<DomainError.Unknown>()
            result.error.throwable shouldBe testException
            result.error.throwable.message shouldBe "test"
            coVerify { searchRepository.searchRepos("") }
            coVerify { errorHandler.handleError(testException) }
        }
    }
}
