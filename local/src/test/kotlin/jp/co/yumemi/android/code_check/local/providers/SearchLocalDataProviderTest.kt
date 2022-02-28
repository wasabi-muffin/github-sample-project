package jp.co.yumemi.android.code_check.local.providers

import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import jp.co.yumemi.android.code_check.data.error.ExceptionHandler
import jp.co.yumemi.android.code_check.local.dao.SearchDao
import jp.co.yumemi.android.code_check.local.models.RecentSearchDbModel
import jp.co.yumemi.android.code_check.test.CoroutineTestRule
import jp.co.yumemi.android.code_check.test.runBlockingTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchLocalDataProviderTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()
    private val searchDao = mockk<SearchDao>()
    private val exceptionHandler = mockk<ExceptionHandler>()
    private val searchLocalDataSource = SearchLocalDataProvider(searchDao, exceptionHandler)
    private val testException = Exception("test")

    @Test
    fun `test getting recent searches`() {
        coEvery {
            searchDao.getAll()
        } returns List(5) { index ->
            RecentSearchDbModel("$index", index.toLong())
        }

        coroutineTestRule.runBlockingTest {
            val result = searchLocalDataSource.getRecentSearches()
            result.size shouldBe 5
            result.forEachIndexed { index, item ->
                item.searchText shouldBe "$index"
                item.timestamp shouldBe index.toLong()
            }
            coVerify { searchDao.getAll() }
        }
    }

    @Test
    fun `test saving recent search`() {
        coEvery {
            searchDao.insertAll(*anyVararg())
        } returns Unit

        coroutineTestRule.runBlockingTest {
            searchLocalDataSource.saveRecentSearch("")
            coVerify { searchDao.insertAll(*anyVararg()) }
        }
    }
}
