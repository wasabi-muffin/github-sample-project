package jp.co.yumemi.android.code_check.data.repositories

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import jp.co.yumemi.android.code_check.data.models.DefaultModel
import jp.co.yumemi.android.code_check.data.models.SearchResultModel
import jp.co.yumemi.android.code_check.data.sources.SearchLocalDataSource
import jp.co.yumemi.android.code_check.data.sources.SearchRemoteDataSource
import jp.co.yumemi.android.code_check.test.CoroutineTestRule
import jp.co.yumemi.android.code_check.test.runBlockingTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchDataRepositoryTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()
    private val searchRemoteDataSource = mockk<SearchRemoteDataSource>()
    private val searchLocalDataSource = mockk<SearchLocalDataSource>()
    private val searchRepository = SearchDataRepository(searchRemoteDataSource, searchLocalDataSource)
    private val testException = Exception("test")
    private val listSize = 5

    @Before
    fun setup() {
        coEvery {
            searchLocalDataSource.saveRecentSearch(searchText = any())
        } returns Unit

        coEvery {
            searchLocalDataSource.getRecentSearches()
        } returns List(listSize) { index ->
            DefaultModel.recentSearch.copy(timestamp = index.toLong())
        }
    }

    @Test
    fun `test when search repositories is successful`() {
        coEvery {
            searchRemoteDataSource.searchRepositories(token = any(), searchText = any(), pageNumber = any(), count = any())
        } returns SearchResultModel(
            items = List(listSize) { index ->
                DefaultModel.repository.copy(id = index)
            },
            totalCount = listSize
        )

        coroutineTestRule.runBlockingTest {
            val result = searchRepository.searchRepositories(searchText = "")
            result.totalCount shouldBe listSize
            result.items.size shouldBe listSize
            result.items.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            coVerify { searchRemoteDataSource.searchRepositories(token = any(), searchText = "", pageNumber = any(), count = any()) }
            coVerify { searchLocalDataSource.saveRecentSearch(searchText = "") }
        }
    }

    @Test
    fun `test when search repositories throws an error`() {
        coEvery {
            searchRemoteDataSource.searchRepositories(token = any(), searchText = any(), pageNumber = any(), count = any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = shouldThrowAny { searchRepository.searchRepositories("") }
            result.shouldBeTypeOf<Exception>()
            result shouldBe testException
            coVerify { searchRemoteDataSource.searchRepositories(token = any(), searchText = "", pageNumber = any(), count = any()) }
            coVerify { searchRemoteDataSource.searchRepositories(token = any(), any()) }
        }
    }

    @Test
    fun `test when search issues is successful`() {
        coEvery {
            searchRemoteDataSource.searchIssues(token = any(), searchText = any(), pageNumber = any(), count = any())
        } returns SearchResultModel(
            items = List(listSize) { index ->
                DefaultModel.issue.copy(id = index)
            },
            totalCount = listSize
        )

        coroutineTestRule.runBlockingTest {
            val result = searchRepository.searchIssues(searchText = "")
            result.totalCount shouldBe listSize
            result.items.size shouldBe listSize
            result.items.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            coVerify { searchRemoteDataSource.searchIssues(token = any(), searchText = "", pageNumber = any(), count = any()) }
            coVerify { searchLocalDataSource.saveRecentSearch(searchText = "") }
        }
    }

    @Test
    fun `test when search issues throws an error`() {
        coEvery {
            searchRemoteDataSource.searchIssues(token = any(), searchText = any(), pageNumber = any(), count = any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = shouldThrowAny { searchRepository.searchIssues("") }
            result.shouldBeTypeOf<Exception>()
            result shouldBe testException
            coVerify { searchRemoteDataSource.searchIssues(token = any(), searchText = "", pageNumber = any(), count = any()) }
            coVerify { searchRemoteDataSource.searchIssues(token = any(), any()) }
        }
    }

    @Test
    fun `test when search pull requests is successful`() {
        coEvery {
            searchRemoteDataSource.searchPullRequests(token = any(), searchText = any(), pageNumber = any(), count = any())
        } returns SearchResultModel(
            items = List(listSize) { index ->
                DefaultModel.pullRequest.copy(id = index)
            },
            totalCount = listSize
        )

        coroutineTestRule.runBlockingTest {
            val result = searchRepository.searchPullRequests(searchText = "")
            result.totalCount shouldBe listSize
            result.items.size shouldBe listSize
            result.items.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            coVerify { searchRemoteDataSource.searchPullRequests(token = any(), searchText = "", pageNumber = any(), count = any()) }
            coVerify { searchLocalDataSource.saveRecentSearch(searchText = "") }
        }
    }

    @Test
    fun `test when search pull requests throws an error`() {
        coEvery {
            searchRemoteDataSource.searchPullRequests(token = any(), searchText = any(), pageNumber = any(), count = any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = shouldThrowAny { searchRepository.searchPullRequests("") }
            result.shouldBeTypeOf<Exception>()
            result shouldBe testException
            coVerify { searchRemoteDataSource.searchPullRequests(token = any(), searchText = "", pageNumber = any(), count = any()) }
            coVerify { searchRemoteDataSource.searchPullRequests(token = any(), any()) }
        }
    }

    @Test
    fun `test when search users is successful`() {
        coEvery {
            searchRemoteDataSource.searchUsers(token = any(), searchText = any(), pageNumber = any(), count = any())
        } returns SearchResultModel(
            items = List(listSize) { index ->
                DefaultModel.user.copy(id = index)
            },
            totalCount = listSize
        )

        coroutineTestRule.runBlockingTest {
            val result = searchRepository.searchUsers(searchText = "")
            result.totalCount shouldBe listSize
            result.items.size shouldBe listSize
            result.items.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            coVerify { searchRemoteDataSource.searchUsers(token = any(), searchText = "", pageNumber = any(), count = any()) }
            coVerify { searchLocalDataSource.saveRecentSearch(searchText = "") }
        }
    }

    @Test
    fun `test when search users throws an error`() {
        coEvery {
            searchRemoteDataSource.searchUsers(token = any(), searchText = any(), pageNumber = any(), count = any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = shouldThrowAny { searchRepository.searchUsers("") }
            result.shouldBeTypeOf<Exception>()
            result shouldBe testException
            coVerify { searchRemoteDataSource.searchUsers(token = any(), searchText = "", pageNumber = any(), count = any()) }
            coVerify { searchRemoteDataSource.searchUsers(token = any(), any()) }
        }
    }

    @Test
    fun `test when search organizations is successful`() {
        coEvery {
            searchRemoteDataSource.searchOrganizations(token = any(), searchText = any(), pageNumber = any(), count = any())
        } returns SearchResultModel(
            items = List(listSize) { index ->
                DefaultModel.organization.copy(id = index)
            },
            totalCount = listSize
        )

        coroutineTestRule.runBlockingTest {
            val result = searchRepository.searchOrganizations(searchText = "")
            result.totalCount shouldBe listSize
            result.items.size shouldBe listSize
            result.items.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            coVerify { searchRemoteDataSource.searchOrganizations(token = any(), searchText = "", pageNumber = any(), count = any()) }
            coVerify { searchLocalDataSource.saveRecentSearch(searchText = "") }
        }
    }

    @Test
    fun `test when search organizations throws an error`() {
        coEvery {
            searchRemoteDataSource.searchOrganizations(token = any(), searchText = any(), pageNumber = any(), count = any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = shouldThrowAny { searchRepository.searchOrganizations("") }
            result.shouldBeTypeOf<Exception>()
            result shouldBe testException
            coVerify { searchRemoteDataSource.searchOrganizations(token = any(), searchText = "", pageNumber = any(), count = any()) }
            coVerify { searchRemoteDataSource.searchOrganizations(token = any(), any()) }
        }
    }
}
