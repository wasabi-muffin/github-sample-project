package io.github.gmvalentino8.github.sample.domain.usecases

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.github.gmvalentino8.github.sample.domain.core.DomainError
import io.github.gmvalentino8.github.sample.domain.core.DomainResult
import io.github.gmvalentino8.github.sample.domain.core.ErrorHandler
import io.github.gmvalentino8.github.sample.domain.entities.Pageable
import io.github.gmvalentino8.github.sample.domain.entities.DefaultEntity
import io.github.gmvalentino8.github.sample.domain.entities.PullRequest
import io.github.gmvalentino8.github.sample.domain.repositories.SearchRepository
import io.github.gmvalentino8.github.sample.test.CoroutineTestRule
import io.github.gmvalentino8.github.sample.test.runBlockingTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchPullRequestsExecutorTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()
    private val searchRepository = mockk<SearchRepository>()
    private val errorHandler = mockk<ErrorHandler>()
    private val testException = Exception("test")
    private val searchPullRequestsUseCase = SearchPullRequestsExecutor(searchRepository = searchRepository, errorHandler = errorHandler)
    private val listSize = 5

    @Test
    fun `test when execute is successful`() {
        coEvery {
            searchRepository.searchPullRequests(searchText = any(), pageNumber = any(), count = any())
        } returns Pageable(
            items = List(listSize) { index ->
                DefaultEntity.pullRequest.copy(id = index)
            },
            totalCount = listSize
        )

        coroutineTestRule.runBlockingTest {
            val result = searchPullRequestsUseCase.execute(arguments = SearchUseCase.Args(searchText = "", pageNumber = 0))
            result.shouldBeTypeOf<DomainResult.Success<Pageable<PullRequest>>>()
            result.data.totalCount shouldBe listSize
            result.data.items.size shouldBe listSize
            result.data.items.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            coVerify { searchRepository.searchPullRequests("") }
            coVerify(inverse = true) { errorHandler.handle(throwable = any()) }
        }
    }

    @Test
    fun `test when search repository throws an error and execute fails`() {
        coEvery {
            searchRepository.searchPullRequests(
                searchText = any(),
                pageNumber = any(),
                count = any()
            )
        } throws testException

        every { errorHandler.handle(throwable = any()) } returns DomainError.Unknown(testException)

        coroutineTestRule.runBlockingTest {
            val result = searchPullRequestsUseCase.execute(arguments = SearchUseCase.Args(searchText = "", pageNumber = 0))
            result.shouldBeTypeOf<DomainResult.Failure>()
            result.error.shouldBeTypeOf<DomainError.Unknown>()
            result.error.throwable shouldBe testException
            result.error.throwable.message shouldBe "test"
            coVerify { searchRepository.searchPullRequests(searchText = "") }
            coVerify { errorHandler.handle(throwable = testException) }
        }
    }
}
