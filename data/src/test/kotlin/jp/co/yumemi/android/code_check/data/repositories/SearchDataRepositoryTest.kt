package jp.co.yumemi.android.code_check.data.repositories

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import jp.co.yumemi.android.code_check.data.models.RecentSearchModel
import jp.co.yumemi.android.code_check.data.models.RepoSearchModel
import jp.co.yumemi.android.code_check.data.models.RepoSearchResultModel
import jp.co.yumemi.android.code_check.data.models.UserModel
import jp.co.yumemi.android.code_check.data.sources.SearchLocalDataSource
import jp.co.yumemi.android.code_check.data.sources.SearchRemoteDataSource
import jp.co.yumemi.android.code_check.domain.entities.User
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
        } returns RepoSearchResultModel(
            repos = List(5) { index ->
                RepoSearchModel(
                    id = index,
                    name = "name$index",
                    description = "description$index",
                    owner = UserModel(id = 0, name = null, username = "", iconUrl = null, blog = null, location = null, email = null, bio = null),
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
            val result = searchRepository.searchRepos("")
            result.totalCount shouldBe 5
            result.items.size shouldBe 5
            result.items.forEachIndexed { index, repo ->
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
