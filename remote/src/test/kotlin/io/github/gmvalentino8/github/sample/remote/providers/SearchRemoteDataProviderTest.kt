package io.github.gmvalentino8.github.sample.remote.providers

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.github.gmvalentino8.github.sample.data.core.DataException
import io.github.gmvalentino8.github.sample.data.core.ExceptionHandler
import io.github.gmvalentino8.github.sample.remote.apis.SearchApi
import io.github.gmvalentino8.github.sample.remote.models.DefaultModel
import io.github.gmvalentino8.github.sample.remote.models.InlineResponse20026ApiModel
import io.github.gmvalentino8.github.sample.remote.models.InlineResponse20028ApiModel
import io.github.gmvalentino8.github.sample.remote.models.InlineResponse20030ApiModel
import io.github.gmvalentino8.github.sample.remote.models.issueSearchResultItem
import io.github.gmvalentino8.github.sample.remote.models.repoSearchResultItem
import io.github.gmvalentino8.github.sample.remote.models.userSearchResultItem
import io.github.gmvalentino8.github.sample.test.CoroutineTestRule
import io.github.gmvalentino8.github.sample.test.runBlockingTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchRemoteDataProviderTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()
    private val searchApi = mockk<SearchApi>()
    private val exceptionHandler = mockk<ExceptionHandler>()
    private val searchRemoteDataSource = SearchRemoteDataProvider(searchApi = searchApi, exceptionHandler = exceptionHandler)
    private val testException = Exception("test")
    private val listSize = 5

    @Before
    fun setup() {
        every { exceptionHandler.handle(throwable = any()) } returns DataException.Unknown()
    }

    @Test
    fun `test when search repos is successful`() {
        coEvery {
            searchApi.searchRepos(accessToken = any(), q = any(), sort = any(), order = any(), perPage = any(), page = any())
        } returns InlineResponse20028ApiModel(
            totalCount = listSize,
            incompleteResults = false,
            items = List(listSize) { index ->
                DefaultModel.repoSearchResultItem.copy(id = index)
            }
        )

        coroutineTestRule.runBlockingTest {
            val result = searchRemoteDataSource.searchRepositories(token = "", searchText = "", pageNumber = 0, count = 0)
            result.totalCount shouldBe listSize
            result.items.size shouldBe listSize
            result.items.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            coVerify { searchApi.searchRepos(accessToken = "", q = "", page = 0, perPage = 0, sort = any(), order = any()) }
            coVerify(inverse = true) { exceptionHandler.handle(throwable = any()) }
        }
    }

    @Test
    fun `test when search repos throws an error`() {
        coEvery {
            searchApi.searchRepos(accessToken = any(), q = any(), sort = any(), order = any(), perPage = any(), page = any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = runCatching {
                searchRemoteDataSource.searchRepositories(token = "", searchText = "", pageNumber = 0, count = 0)
            }.exceptionOrNull()
            result.shouldBeTypeOf<DataException.Unknown>()
            coVerify { searchApi.searchRepos(accessToken = "", q = "", page = 0, perPage = 0) }
            coVerify { exceptionHandler.handle(throwable = testException) }
        }
    }

    @Test
    fun `test when search issues and pull requests is successful`() {
        coEvery {
            searchApi.searchIssuesAndPullRequests(accessToken = any(), q = any(), sort = any(), order = any(), perPage = any(), page = any())
        } returns InlineResponse20026ApiModel(
            totalCount = listSize,
            incompleteResults = false,
            items = List(listSize) { index ->
                DefaultModel.issueSearchResultItem.copy(id = index)
            }
        )

        coroutineTestRule.runBlockingTest {
            val issuesResult = searchRemoteDataSource.searchIssues(token = "", searchText = "", pageNumber = 0, count = 0)
            val pullRequestsResult = searchRemoteDataSource.searchPullRequests(token = "", searchText = "", pageNumber = 0, count = 0)
            issuesResult.totalCount shouldBe listSize
            issuesResult.items.size shouldBe listSize
            issuesResult.items.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            pullRequestsResult.totalCount shouldBe listSize
            pullRequestsResult.items.size shouldBe listSize
            pullRequestsResult.items.forEachIndexed { index, item ->
                item.id shouldBe index
            }

            coVerify(exactly = 2) { searchApi.searchIssuesAndPullRequests(accessToken = "", q = any(), page = 0, perPage = 0, sort = any(), order = any()) }
            coVerify(inverse = true) { exceptionHandler.handle(throwable = any()) }
        }
    }

    @Test
    fun `test when search issues and pull requests throws an error`() {
        coEvery {
            searchApi.searchIssuesAndPullRequests(accessToken = any(), q = any(), sort = any(), order = any(), perPage = any(), page = any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val issuesResult = shouldThrowAny { searchRemoteDataSource.searchIssues(token = "", searchText = "", pageNumber = 0, count = 0) }
            val pullRequestsResult = shouldThrowAny { searchRemoteDataSource.searchPullRequests(token = "", searchText = "", pageNumber = 0, count = 0) }
            issuesResult.shouldBeTypeOf<DataException.Unknown>()
            pullRequestsResult.shouldBeTypeOf<DataException.Unknown>()
            coVerify(exactly = 2) { searchApi.searchIssuesAndPullRequests(accessToken = "", q = any(), page = 0, perPage = 0, sort = any(), order = any()) }
            coVerify(exactly = 2) { exceptionHandler.handle(throwable = testException) }
        }
    }

    @Test
    fun `test when search users is successful`() {
        coEvery {
            searchApi.searchUsers(accessToken = any(), q = any(), sort = any(), order = any(), perPage = any(), page = any())
        } returns InlineResponse20030ApiModel(
            totalCount = listSize,
            incompleteResults = false,
            items = List(listSize) { index ->
                DefaultModel.userSearchResultItem.copy(id = index)
            }
        )

        coroutineTestRule.runBlockingTest {
            val usersResult = searchRemoteDataSource.searchUsers(token = "", searchText = "", pageNumber = 0, count = 0)
            val organizationsResult = searchRemoteDataSource.searchOrganizations(token = "", searchText = "", pageNumber = 0, count = 0)
            usersResult.totalCount shouldBe listSize
            usersResult.items.size shouldBe listSize
            usersResult.items.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            organizationsResult.totalCount shouldBe listSize
            organizationsResult.items.size shouldBe listSize
            organizationsResult.items.forEachIndexed { index, item ->
                item.id shouldBe index
            }

            coVerify(exactly = 2) { searchApi.searchUsers(accessToken = "", q = any(), page = 0, perPage = 0, sort = any(), order = any()) }
            coVerify(inverse = true) { exceptionHandler.handle(throwable = any()) }
        }
    }

    @Test
    fun `test when search users throws an error`() {
        coEvery {
            searchApi.searchUsers(accessToken = any(), q = any(), sort = any(), order = any(), perPage = any(), page = any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val usersResult = shouldThrowAny { searchRemoteDataSource.searchUsers(token = "", searchText = "", pageNumber = 0, count = 0) }
            val organizationsResult = shouldThrowAny { searchRemoteDataSource.searchOrganizations(token = "", searchText = "", pageNumber = 0, count = 0) }
            usersResult.shouldBeTypeOf<DataException.Unknown>()
            organizationsResult.shouldBeTypeOf<DataException.Unknown>()
            coVerify(exactly = 2) { searchApi.searchUsers(accessToken = "", q = any(), page = 0, perPage = 0, sort = any(), order = any()) }
            coVerify(exactly = 2) { exceptionHandler.handle(throwable = testException) }
        }
    }
}
