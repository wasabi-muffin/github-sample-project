package jp.co.yumemi.android.code_check.data.repositories

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import jp.co.yumemi.android.code_check.data.models.RecentSearchModel
import jp.co.yumemi.android.code_check.data.models.RepoSearchModel
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

    @Before
    fun setup() {
        coEvery {
            searchLocalDataSource.saveRecentSearch(any())
        } returns Unit

        coEvery {
            searchLocalDataSource.getRecentSearches()
        } returns listOf(RecentSearchModel("", 1L))
    }

    @Test
    fun `test when search is successful`() {
        coEvery {
            searchRemoteDataSource.searchRepos(any(), any())
        } returns List(5) { index ->
            RepoSearchModel(
                name = "name$index",
                ownerIconUrl = "ownerIconUrl$index",
                language = "language$index",
                stargazersCount = index,
                watchersCount = index,
                forksCount = index,
                openIssuesCount = index,
            )
        }

        coroutineTestRule.runBlockingTest {
            val result = searchRepository.searchRepos("")
            result.size shouldBe 5
            result.forEachIndexed { index, repo ->
                repo.name shouldBe "name$index"
                repo.ownerIconUrl shouldBe "ownerIconUrl$index"
                repo.language shouldBe "language$index"
                repo.stargazersCount shouldBe index
                repo.watchersCount shouldBe index
                repo.forksCount shouldBe index
                repo.openIssuesCount shouldBe index
            }
            coVerify { searchRemoteDataSource.searchRepos(any(), "") }
            coVerify { searchLocalDataSource.saveRecentSearch("") }
        }
    }

    @Test
    fun `test when remote data provider throws an error`() {
        coEvery {
            searchRemoteDataSource.searchRepos(any(), any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = runCatching {
                searchRepository.searchRepos("")
            }.exceptionOrNull()
            result.shouldBeTypeOf<Exception>()
            result shouldBe testException
            coVerify { searchRemoteDataSource.searchRepos(any(), any()) }
        }
    }
}
