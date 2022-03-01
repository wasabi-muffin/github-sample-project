package jp.co.yumemi.android.code_check.domain.usecases

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import jp.co.yumemi.android.code_check.domain.core.DomainError
import jp.co.yumemi.android.code_check.domain.core.DomainResult
import jp.co.yumemi.android.code_check.domain.core.ErrorHandler
import jp.co.yumemi.android.code_check.domain.entities.Pageable
import jp.co.yumemi.android.code_check.domain.entities.DefaultEntity
import jp.co.yumemi.android.code_check.domain.entities.SearchAll
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository
import jp.co.yumemi.android.code_check.test.CoroutineTestRule
import jp.co.yumemi.android.code_check.test.runBlockingTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchAllExecutorTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()
    private val searchRepository = mockk<SearchRepository>()
    private val errorHandler = mockk<ErrorHandler>()
    private val testException = Exception("test")
    private val searchAllExecutor = SearchAllExecutor(searchRepository = searchRepository, errorHandler = errorHandler)
    private val listSize = 5

    @Before
    fun setup() {
        coEvery {
            searchRepository.searchRepositories(searchText = any(), pageNumber = any(), count = any())
        } returns Pageable(
            items = List(listSize) { index ->
                DefaultEntity.repository.copy(id = index)
            },
            totalCount = listSize
        )

        coEvery {
            searchRepository.searchIssues(searchText = any(), pageNumber = any(), count = any())
        } returns Pageable(
            items = List(listSize) { index ->
                DefaultEntity.issue.copy(id = index)
            },
            totalCount = listSize
        )

        coEvery {
            searchRepository.searchPullRequests(searchText = any(), pageNumber = any(), count = any())
        } returns Pageable(
            items = List(listSize) { index ->
                DefaultEntity.pullRequest.copy(id = index)
            },
            totalCount = listSize
        )

        coEvery {
            searchRepository.searchUsers(searchText = any(), pageNumber = any(), count = any())
        } returns Pageable(
            items = List(listSize) { index ->
                DefaultEntity.user.copy(id = index)
            },
            totalCount = listSize
        )

        coEvery {
            searchRepository.searchOrganizations(searchText = any(), pageNumber = any(), count = any())
        } returns Pageable(
            items = List(listSize) { index ->
                DefaultEntity.organization.copy(id = index)
            },
            totalCount = listSize
        )

        coEvery {
            errorHandler.handle(throwable = any())
        } returns DomainError.Unknown(testException)
    }

    @Test
    fun `test when all searches are successful`() {
        coroutineTestRule.runBlockingTest {
            val result = searchAllExecutor.execute(arguments = SearchAllUseCase.Args(searchText = ""))
            result.shouldBeTypeOf<DomainResult.Success<SearchAll>>()
            result.data.repositories.totalCount shouldBe listSize
            result.data.repositories.items.size shouldBe listSize
            result.data.repositories.items.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            result.data.issues.totalCount shouldBe listSize
            result.data.issues.items.size shouldBe listSize
            result.data.issues.items.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            result.data.pullRequests.totalCount shouldBe listSize
            result.data.pullRequests.items.size shouldBe listSize
            result.data.pullRequests.items.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            result.data.people.totalCount shouldBe listSize
            result.data.people.items.size shouldBe listSize
            result.data.people.items.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            result.data.organizations.totalCount shouldBe listSize
            result.data.organizations.items.size shouldBe listSize
            result.data.organizations.items.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            coVerify { searchRepository.searchRepositories(searchText = "", pageNumber = any(), count = any()) }
            coVerify { searchRepository.searchIssues(searchText = "", pageNumber = any(), count = any()) }
            coVerify { searchRepository.searchPullRequests(searchText = "", pageNumber = any(), count = any()) }
            coVerify { searchRepository.searchUsers(searchText = "", pageNumber = any(), count = any()) }
            coVerify { searchRepository.searchOrganizations(searchText = "", pageNumber = any(), count = any()) }
            coVerify(inverse = true) { errorHandler.handle(throwable = any()) }
        }
    }

    @Test
    fun `test when search repositories fails`() {
        coEvery {
            searchRepository.searchRepositories(searchText = any(), pageNumber = any(), count = any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = searchAllExecutor.execute(arguments = SearchAllUseCase.Args(searchText = ""))
            result.shouldBeTypeOf<DomainResult.Failure>()
            result.error shouldBe DomainError.Unknown(testException)
            result.error.throwable shouldBe testException
            coVerify { searchRepository.searchRepositories(searchText = "", pageNumber = any(), count = any()) }
            coVerify { errorHandler.handle(throwable = any()) }
        }
    }

    @Test
    fun `test when search issues fails`() {
        coEvery {
            searchRepository.searchIssues(searchText = any(), pageNumber = any(), count = any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = searchAllExecutor.execute(arguments = SearchAllUseCase.Args(searchText = ""))
            result.shouldBeTypeOf<DomainResult.Failure>()
            result.error shouldBe DomainError.Unknown(testException)
            result.error.throwable shouldBe testException
            coVerify { searchRepository.searchIssues(searchText = "", pageNumber = any(), count = any()) }
            coVerify { errorHandler.handle(throwable = any()) }
        }
    }

    @Test
    fun `test when search pull requests fails`() {
        coEvery {
            searchRepository.searchPullRequests(searchText = any(), pageNumber = any(), count = any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = searchAllExecutor.execute(arguments = SearchAllUseCase.Args(searchText = ""))
            result.shouldBeTypeOf<DomainResult.Failure>()
            result.error shouldBe DomainError.Unknown(testException)
            result.error.throwable shouldBe testException
            coVerify { searchRepository.searchPullRequests(searchText = "", pageNumber = any(), count = any()) }
            coVerify { errorHandler.handle(throwable = any()) }
        }
    }

    @Test
    fun `test when search users fails`() {
        coEvery {
            searchRepository.searchUsers(searchText = any(), pageNumber = any(), count = any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = searchAllExecutor.execute(arguments = SearchAllUseCase.Args(searchText = ""))
            result.shouldBeTypeOf<DomainResult.Failure>()
            result.error shouldBe DomainError.Unknown(testException)
            result.error.throwable shouldBe testException
            coVerify { searchRepository.searchUsers(searchText = "", pageNumber = any(), count = any()) }
            coVerify { errorHandler.handle(throwable = any()) }
        }
    }

    @Test
    fun `test when search organizations fails`() {
        coEvery {
            searchRepository.searchOrganizations(searchText = any(), pageNumber = any(), count = any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = searchAllExecutor.execute(arguments = SearchAllUseCase.Args(searchText = ""))
            result.shouldBeTypeOf<DomainResult.Failure>()
            result.error shouldBe DomainError.Unknown(testException)
            result.error.throwable shouldBe testException
            coVerify { searchRepository.searchOrganizations(searchText = "", pageNumber = any(), count = any()) }
            coVerify { errorHandler.handle(throwable = any()) }
        }
    }
}
