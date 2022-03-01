package jp.co.yumemi.android.code_check.remote.providers

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import jp.co.yumemi.android.code_check.data.core.DataException
import jp.co.yumemi.android.code_check.data.core.ExceptionHandler
import jp.co.yumemi.android.code_check.remote.apis.PullsApi
import jp.co.yumemi.android.code_check.remote.apis.ReposApi
import jp.co.yumemi.android.code_check.remote.models.DefaultModel
import jp.co.yumemi.android.code_check.remote.models.contributor
import jp.co.yumemi.android.code_check.remote.models.pullRequestSimple
import jp.co.yumemi.android.code_check.remote.models.release
import jp.co.yumemi.android.code_check.test.CoroutineTestRule
import jp.co.yumemi.android.code_check.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RepositoriesRemoteDataProviderTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()
    private val reposApi = mockk<ReposApi>()
    private val pullsApi = mockk<PullsApi>()
    private val exceptionHandler = mockk<ExceptionHandler>()
    private val searchRemoteDataSource = RepositoriesRemoteDataProvider(reposApi = reposApi, pullsApi = pullsApi, exceptionHandler = exceptionHandler)
    private val testException = Exception("test")
    private val listSize = 5

    @Before
    fun setup() {
        every { exceptionHandler.handle(throwable = any()) } returns DataException.Unknown()
    }

    @Test
    fun `test when repos list contributors is successful`() {
        coEvery {
            reposApi.reposListContributors(accessToken = any(), repoName = any(), perPage = any(), page = any())
        } returns List(listSize) { index ->
            DefaultModel.contributor.copy(id = index)
        }

        coroutineTestRule.runBlockingTest {
            val result = searchRemoteDataSource.getContributors(token = "", name = "", pageNumber = 0, perPage = 0)
            result.size shouldBe listSize
            result.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            coVerify { reposApi.reposListContributors(accessToken = "", repoName = "", perPage = 0, page = 0) }
            coVerify(inverse = true) { exceptionHandler.handle(throwable = any()) }
        }
    }

    @Test
    fun `test when repos list contributors throws an error`() {
        coEvery {
            reposApi.reposListContributors(accessToken = any(), repoName = any(), perPage = any(), page = any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = shouldThrowAny { searchRemoteDataSource.getContributors(token = "", name = "", pageNumber = 0, perPage = 0) }
            result.shouldBeTypeOf<DataException.Unknown>()
            coVerify { reposApi.reposListContributors(accessToken = "", repoName = "", perPage = 0, page = 0) }
            coVerify { exceptionHandler.handle(throwable = testException) }
        }
    }

    @Test
    fun `test when repos list releases is successful`() {
        coEvery {
            reposApi.reposListReleases(accessToken = any(), repoName = any(), perPage = any(), page = any())
        } returns List(listSize) { index ->
            DefaultModel.release.copy(id = index)
        }

        coroutineTestRule.runBlockingTest {
            val result = searchRemoteDataSource.getReleases(token = "", name = "", pageNumber = 0, perPage = 0)
            result.size shouldBe listSize
            result.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            coVerify { reposApi.reposListReleases(accessToken = "", repoName = "", perPage = 0, page = 0) }
            coVerify(inverse = true) { exceptionHandler.handle(throwable = any()) }
        }
    }

    @Test
    fun `test when repos list releases throws an error`() {
        coEvery {
            reposApi.reposListReleases(accessToken = any(), repoName = any(), perPage = any(), page = any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = shouldThrowAny { searchRemoteDataSource.getReleases(token = "", name = "", pageNumber = 0, perPage = 0) }
            result.shouldBeTypeOf<DataException.Unknown>()
            coVerify { reposApi.reposListReleases(accessToken = "", repoName = "", perPage = 0, page = 0) }
            coVerify { exceptionHandler.handle(throwable = testException) }
        }
    }

    @Test
    fun `test when pulls list is successful`() {
        coEvery {
            pullsApi.pullsList(
                accessToken = any(),
                repoName = any(),
                state = any(),
                head = any(),
                base = any(),
                sort = any(),
                direction = any(),
                perPage = any(),
                page = any()
            )
        } returns List(listSize) { index ->
            DefaultModel.pullRequestSimple.copy(id = index)
        }

        coroutineTestRule.runBlockingTest {
            val result = searchRemoteDataSource.getPulls(token = "", name = "", pageNumber = 0, perPage = 0)
            result.size shouldBe listSize
            result.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            coVerify {
                pullsApi.pullsList(
                    accessToken = "",
                    repoName = "",
                    state = any(),
                    head = any(),
                    base = any(),
                    sort = any(),
                    direction = any(),
                    perPage = 0,
                    page = 0
                )
            }
            coVerify(inverse = true) { exceptionHandler.handle(throwable = any()) }
        }
    }

    @Test
    fun `test when pulls list throws an error`() {
        coEvery {
            pullsApi.pullsList(
                accessToken = any(),
                repoName = any(),
                state = any(),
                head = any(),
                base = any(),
                sort = any(),
                direction = any(),
                perPage = any(),
                page = any()
            )
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = shouldThrowAny { searchRemoteDataSource.getPulls(token = "", name = "", pageNumber = 0, perPage = 0) }
            result.shouldBeTypeOf<DataException.Unknown>()
            coVerify {
                pullsApi.pullsList(
                    accessToken = "",
                    repoName = "",
                    state = any(),
                    head = any(),
                    base = any(),
                    sort = any(),
                    direction = any(),
                    perPage = 0,
                    page = 0
                )
            }
            coVerify { exceptionHandler.handle(throwable = testException) }
        }
    }
}
