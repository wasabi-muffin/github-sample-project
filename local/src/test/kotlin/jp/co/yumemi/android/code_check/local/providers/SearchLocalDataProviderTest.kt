package jp.co.yumemi.android.code_check.local.providers

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import jp.co.yumemi.android.code_check.data.core.DataException
import jp.co.yumemi.android.code_check.data.core.ExceptionHandler
import jp.co.yumemi.android.code_check.data.utils.InstantProvider
import jp.co.yumemi.android.code_check.local.dao.SearchDao
import jp.co.yumemi.android.code_check.local.models.RecentSearchDbModel
import jp.co.yumemi.android.code_check.test.CoroutineTestRule
import jp.co.yumemi.android.code_check.test.runBlockingTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.datetime.Instant
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchLocalDataProviderTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()
    private val searchDao = mockk<SearchDao>()
    private val exceptionHandler = mockk<ExceptionHandler>()
    private val instantProvider = mockk<InstantProvider>()
    private val searchLocalDataSource = SearchLocalDataProvider(searchDao, instantProvider, exceptionHandler)
    private val listSize = 5

    @Before
    fun setup() {
        every { exceptionHandler.handle(throwable = any()) } returns DataException.Unknown()
        every { instantProvider.now() } returns Instant.fromEpochSeconds(0)
    }

    @Test
    fun `test getting recent searches`() {
        coEvery {
            searchDao.getAll()
        } returns List(listSize) { index ->
            RecentSearchDbModel("$index", index.toLong())
        }

        coroutineTestRule.runBlockingTest {
            val result = searchLocalDataSource.getRecentSearches()
            result.size shouldBe listSize
            result.forEachIndexed { index, item ->
                item.searchText shouldBe "$index"
                item.timestamp shouldBe index.toLong()
            }
            coVerify { searchDao.getAll() }
            coVerify(inverse = true) { exceptionHandler.handle(throwable = any()) }
        }
    }

    @Test
    fun `test database failure`() {
        coEvery {
            searchDao.getAll()
        } throws Exception()

        coroutineTestRule.runBlockingTest {
            val result = shouldThrow<DataException> { searchLocalDataSource.getRecentSearches() }
            result shouldBe DataException.Unknown()
            coVerify { searchDao.getAll() }
            coVerify { exceptionHandler.handle(throwable = any()) }
        }
    }

    @Test
    fun `test saving recent search`() {
        coEvery {
            searchDao.insertAll(*anyVararg())
        } returns Unit

        coroutineTestRule.runBlockingTest {
            searchLocalDataSource.saveRecentSearch(searchText = "")
            coVerify { searchDao.insertAll(*varargAny { it.searchText == "" && it.timestamp == 0L }) }
            coVerify(inverse = true) { exceptionHandler.handle(throwable = any()) }
        }
    }

    @Test
    fun `test deleting all recent searches`() {
        coEvery {
            searchDao.deleteAll()
        } returns Unit

        coroutineTestRule.runBlockingTest {
            searchLocalDataSource.deleteAllRecentSearches()
            coVerify { searchDao.deleteAll() }
            coVerify(inverse = true) { exceptionHandler.handle(throwable = any()) }
        }
    }
}
