package jp.co.yumemi.android.code_check.domain.usecases

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import jp.co.yumemi.android.code_check.domain.core.DomainError
import jp.co.yumemi.android.code_check.domain.core.DomainResult
import jp.co.yumemi.android.code_check.domain.core.ErrorHandler
import jp.co.yumemi.android.code_check.domain.core.Pageable
import jp.co.yumemi.android.code_check.domain.entities.SimpleGithubRepo
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository
import jp.co.yumemi.android.code_check.test.CoroutineTestRule
import jp.co.yumemi.android.code_check.test.runBlockingTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchRepoExecutorTest {
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
        } returns Pageable(
            items = List(5) { index ->
                SimpleGithubRepo(
                    name = "name$index",
                    ownerName = "ownerName$index",
                    ownerIconUrl = "ownerIconUrl$index",
                    language = "language$index",
                    stargazersCount = index,
                )
            },
            totalCount = 5
        )

        coroutineTestRule.runBlockingTest {
            val result = searchRepoUseCase.execute(SearchRepoUseCase.Args("", 0))
            result.shouldBeTypeOf<DomainResult.Success<Pageable<SimpleGithubRepo>>>()
            result.data.totalCount shouldBe 5
            result.data.items.size shouldBe 5
            result.data.items.forEachIndexed { index, repo ->
                repo.name shouldBe "name$index"
                repo.ownerName shouldBe "ownerName$index"
                repo.ownerIconUrl shouldBe "ownerIconUrl$index"
                repo.language shouldBe "language$index"
                repo.stargazersCount shouldBe index
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
            val result = searchRepoUseCase.execute(SearchRepoUseCase.Args("", 0))
            result.shouldBeTypeOf<DomainResult.Failure>()
            result.error.shouldBeTypeOf<DomainError.Unknown>()
            result.error.throwable shouldBe testException
            result.error.throwable.message shouldBe "test"
            coVerify { searchRepository.searchRepos("") }
            coVerify { errorHandler.handleError(testException) }
        }
    }
}
