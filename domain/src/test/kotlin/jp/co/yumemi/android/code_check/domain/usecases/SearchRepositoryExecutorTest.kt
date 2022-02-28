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
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.entities.User
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository
import jp.co.yumemi.android.code_check.test.CoroutineTestRule
import jp.co.yumemi.android.code_check.test.runBlockingTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchRepositoryExecutorTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()
    private val searchRepository = mockk<SearchRepository>()
    private val errorHandler = mockk<ErrorHandler>()
    private val testException = Exception("test")
    private val searchRepoUseCase = SearchRepositoriesExecutor(searchRepository, errorHandler)

    @Test
    fun `test when execute is successful`() {
        coEvery {
            searchRepository.searchRepositories(any())
        } returns Pageable(
            items = List(5) { index ->
                Repository(
                    id = index,
                    name = "name$index",
                    description = "description$index",
                    owner = User(id = 0, name = null, username = "", iconUrl = null, description = null),
                    homepage = "homepage$index",
                    language = "language$index",
                    stargazersCount = index,
                    watchersCount = index,
                    forksCount = index,
                    openIssuesCount = index,
                    license = "license$index",
                )
            },
            totalCount = 5
        )

        coroutineTestRule.runBlockingTest {
            val result = searchRepoUseCase.execute(SearchUseCase.Args("", 0))
            result.shouldBeTypeOf<DomainResult.Success<Pageable<Repository>>>()
            result.data.totalCount shouldBe 5
            result.data.items.size shouldBe 5
            result.data.items.forEachIndexed { index, repo ->
                repo.id shouldBe index
                repo.name shouldBe "name$index"
                repo.description shouldBe "description$index"
                repo.homepage shouldBe "homepage$index"
                repo.language shouldBe "language$index"
                repo.stargazersCount shouldBe index
                repo.watchersCount shouldBe index
                repo.forksCount shouldBe index
                repo.openIssuesCount shouldBe index
                repo.license shouldBe "license$index"
            }
            coVerify { searchRepository.searchRepositories("") }
            coVerify(inverse = true) { errorHandler.handle(any()) }
        }
    }

    @Test
    fun `test when repository throws an error and execute fails`() {
        coEvery {
            searchRepository.searchRepositories(any())
        } throws testException

        every { errorHandler.handle(any()) } returns DomainError.Unknown(testException)

        coroutineTestRule.runBlockingTest {
            val result = searchRepoUseCase.execute(SearchUseCase.Args("", 0))
            result.shouldBeTypeOf<DomainResult.Failure>()
            result.error.shouldBeTypeOf<DomainError.Unknown>()
            result.error.throwable shouldBe testException
            result.error.throwable.message shouldBe "test"
            coVerify { searchRepository.searchRepositories("") }
            coVerify { errorHandler.handle(testException) }
        }
    }
}
