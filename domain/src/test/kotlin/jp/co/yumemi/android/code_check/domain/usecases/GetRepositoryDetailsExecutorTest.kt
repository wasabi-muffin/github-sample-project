package jp.co.yumemi.android.code_check.domain.usecases

import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import jp.co.yumemi.android.code_check.domain.core.DomainError
import jp.co.yumemi.android.code_check.domain.core.DomainResult
import jp.co.yumemi.android.code_check.domain.core.ErrorHandler
import jp.co.yumemi.android.code_check.domain.entities.DefaultEntity
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.entities.RepositoryDetails
import jp.co.yumemi.android.code_check.domain.repositories.RepositoriesRepository
import jp.co.yumemi.android.code_check.test.CoroutineTestRule
import jp.co.yumemi.android.code_check.test.runBlockingTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class GetRepositoryDetailsExecutorTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()
    private val repositoriesRepository = mockk<RepositoriesRepository>()
    private val errorHandler = mockk<ErrorHandler>()
    private val getRepositoryDetailsUseCase = GetRepositoryDetailsExecutor(repositoriesRepository = repositoriesRepository, errorHandler = errorHandler)
    private val testException = Exception("test")
    private val defaultRepository = Repository(
        id = 0,
        name = "",
        description = null,
        owner = null,
        homepage = null,
        language = null,
        stargazersCount = 0,
        watchersCount = 0,
        forksCount = 0,
        openIssuesCount = 0,
        license = null
    )
    private val listSize = 3

    @Before
    fun setup() {
        coEvery {
            repositoriesRepository.getContributors(name = any())
        } returns List(listSize) { index ->
            DefaultEntity.user.copy(id = index)
        }

        coEvery {
            repositoriesRepository.getReleases(name = any())
        } returns List(listSize) { index ->
            DefaultEntity.release.copy(id = index)
        }

        coEvery {
            repositoriesRepository.getPulls(name = any())
        } returns List(listSize) { index ->
            DefaultEntity.pullRequest.copy(id = index)
        }

        coEvery {
            errorHandler.handle(any())
        } returns DomainError.Unknown(throwable = testException)
    }

    @Test
    fun `test when all repository calls are successful`() {
        coroutineTestRule.runBlockingTest {
            val result = getRepositoryDetailsUseCase.execute(arguments = GetRepositoryDetailsUseCase.Args(repository = defaultRepository))
            result.shouldBeTypeOf<DomainResult.Success<RepositoryDetails>>()
            result.data.repository shouldBe defaultRepository
            val contributors = result.data.contributors
            contributors.shouldNotBeNull()
            contributors.size shouldBe listSize
            contributors.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            val releases = result.data.releases
            releases.shouldNotBeNull()
            releases.size shouldBe listSize
            releases.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            val pullRequests = result.data.pullRequests
            pullRequests.shouldNotBeNull()
            pullRequests.size shouldBe listSize
            pullRequests.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            coVerify { repositoriesRepository.getContributors(name = "") }
            coVerify { repositoriesRepository.getReleases(name = "") }
            coVerify { repositoriesRepository.getPulls(name = "") }
            coVerify(inverse = true) { errorHandler.handle(throwable = any()) }
        }
    }

    @Test
    fun `test when get contributors fails`() {
        coEvery {
            repositoriesRepository.getContributors(name = any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = getRepositoryDetailsUseCase.execute(arguments = GetRepositoryDetailsUseCase.Args(repository = defaultRepository))
            result.shouldBeTypeOf<DomainResult.Success<RepositoryDetails>>()
            result.data.repository shouldBe defaultRepository
            result.data.contributors.shouldBeNull()
            val releases = result.data.releases
            releases.shouldNotBeNull()
            releases.size shouldBe listSize
            releases.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            val pullRequests = result.data.pullRequests
            pullRequests.shouldNotBeNull()
            pullRequests.size shouldBe listSize
            pullRequests.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            coVerify { repositoriesRepository.getContributors(name = "") }
            coVerify { repositoriesRepository.getReleases(name = "") }
            coVerify { repositoriesRepository.getPulls(name = "") }
            coVerify(inverse = true) { errorHandler.handle(throwable = any()) }
        }
    }

    @Test
    fun `test when get releases fails`() {
        coEvery {
            repositoriesRepository.getReleases(name = any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = getRepositoryDetailsUseCase.execute(arguments = GetRepositoryDetailsUseCase.Args(repository = defaultRepository))
            result.shouldBeTypeOf<DomainResult.Success<RepositoryDetails>>()
            result.data.repository shouldBe defaultRepository
            val contributors = result.data.contributors
            contributors.shouldNotBeNull()
            contributors.size shouldBe listSize
            contributors.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            result.data.releases.shouldBeNull()
            val pullRequests = result.data.pullRequests
            pullRequests.shouldNotBeNull()
            pullRequests.size shouldBe listSize
            pullRequests.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            coVerify { repositoriesRepository.getContributors(name = "") }
            coVerify { repositoriesRepository.getReleases(name = "") }
            coVerify { repositoriesRepository.getPulls(name = "") }
            coVerify(inverse = true) { errorHandler.handle(throwable = any()) }
        }
    }

    @Test
    fun `test when get pull requests fails`() {
        coEvery {
            repositoriesRepository.getPulls(name = any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = getRepositoryDetailsUseCase.execute(arguments = GetRepositoryDetailsUseCase.Args(repository = defaultRepository))
            result.shouldBeTypeOf<DomainResult.Success<RepositoryDetails>>()
            result.data.repository shouldBe defaultRepository
            val contributors = result.data.contributors
            contributors.shouldNotBeNull()
            contributors.size shouldBe listSize
            contributors.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            val releases = result.data.releases
            releases.shouldNotBeNull()
            releases.size shouldBe listSize
            releases.forEachIndexed { index, item ->
                item.id shouldBe index
            }
            result.data.pullRequests.shouldBeNull()
            coVerify { repositoriesRepository.getContributors(name = "") }
            coVerify { repositoriesRepository.getReleases(name = "") }
            coVerify { repositoriesRepository.getPulls(name = "") }
            coVerify(inverse = true) { errorHandler.handle(throwable = any()) }
        }
    }

    @Test
    fun `test when all requests fail`() {
        coEvery {
            repositoriesRepository.getContributors(name = any())
        } throws testException

        coEvery {
            repositoriesRepository.getReleases(name = any())
        } throws testException

        coEvery {
            repositoriesRepository.getPulls(name = any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = getRepositoryDetailsUseCase.execute(arguments = GetRepositoryDetailsUseCase.Args(repository = defaultRepository))
            result.shouldBeTypeOf<DomainResult.Success<RepositoryDetails>>()
            result.data.repository shouldBe defaultRepository
            result.data.contributors.shouldBeNull()
            result.data.releases.shouldBeNull()
            result.data.pullRequests.shouldBeNull()
            coVerify { repositoriesRepository.getContributors(name = "") }
            coVerify { repositoriesRepository.getReleases(name = "") }
            coVerify { repositoriesRepository.getPulls(name = "") }
            coVerify(inverse = true) { errorHandler.handle(throwable = any()) }
        }
    }
}
