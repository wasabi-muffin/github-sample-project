package jp.co.yumemi.android.code_check.data.repositories

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import jp.co.yumemi.android.code_check.data.models.DefaultModel
import jp.co.yumemi.android.code_check.data.sources.RepositoriesRemoteDataSource
import jp.co.yumemi.android.code_check.test.CoroutineTestRule
import jp.co.yumemi.android.code_check.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

class RepositoriesDataRepositoryTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()
    private val repositoriesRemoteDataSource = mockk<RepositoriesRemoteDataSource>()
    private val repositoriesRepository = RepositoriesDataRepository(repositoriesRemoteDataSource)
    private val testException = Exception("test")
    private val listSize = 5

    @Test
    fun `test when get contributors is successful`() {
        coEvery {
            repositoriesRemoteDataSource.getContributors(name = any())
        } returns List(listSize) { index ->
            DefaultModel.user.copy(id = index)
        }

        coroutineTestRule.runBlockingTest {
            val result = repositoriesRepository.getContributors(name = "")
            result.size shouldBe listSize
            result.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            coVerify { repositoriesRemoteDataSource.getContributors(name = "") }
        }
    }

    @Test
    fun `test when get contributors throws an error`() {
        coEvery {
            repositoriesRemoteDataSource.getContributors(name = any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = shouldThrowAny { repositoriesRepository.getContributors(name = "") }
            result.shouldBeTypeOf<Exception>()
            result shouldBe testException
            coVerify { repositoriesRemoteDataSource.getContributors(name = "") }
        }
    }

    @Test
    fun `test when get releases is successful`() {
        coEvery {
            repositoriesRemoteDataSource.getReleases(name = any())
        } returns List(listSize) { index ->
            DefaultModel.release.copy(id = index)
        }

        coroutineTestRule.runBlockingTest {
            val result = repositoriesRepository.getReleases(name = "")
            result.size shouldBe listSize
            result.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            coVerify { repositoriesRemoteDataSource.getReleases(name = "") }
        }
    }

    @Test
    fun `test when get releases throws an error`() {
        coEvery {
            repositoriesRemoteDataSource.getReleases(name = any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = shouldThrowAny { repositoriesRepository.getReleases(name = "") }
            result.shouldBeTypeOf<Exception>()
            result shouldBe testException
            coVerify { repositoriesRemoteDataSource.getReleases(name = "") }
        }
    }

    @Test
    fun `test when get pulls is successful`() {
        coEvery {
            repositoriesRemoteDataSource.getPulls(name = any())
        } returns List(listSize) { index ->
            DefaultModel.pullRequest.copy(id = index)
        }

        coroutineTestRule.runBlockingTest {
            val result = repositoriesRepository.getPulls(name = "")
            result.size shouldBe listSize
            result.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            coVerify { repositoriesRemoteDataSource.getPulls(name = "") }
        }
    }

    @Test
    fun `test when get pulls throws an error`() {
        coEvery {
            repositoriesRemoteDataSource.getPulls(name = any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = shouldThrowAny { repositoriesRepository.getPulls(name = "") }
            result.shouldBeTypeOf<Exception>()
            result shouldBe testException
            coVerify { repositoriesRemoteDataSource.getPulls(name = "") }
        }
    }
}
