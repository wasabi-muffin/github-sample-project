package jp.co.yumemi.android.code_check.domain.usecases

import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import jp.co.yumemi.android.code_check.domain.entities.DefaultEntity
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository
import jp.co.yumemi.android.code_check.test.CoroutineTestRule
import jp.co.yumemi.android.code_check.test.runBlockingTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class GetRecentSearchesExecutorTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()
    private val searchRepository = mockk<SearchRepository>()
    private val getRecentSearchesUseCase = GetRecentSearchesExecutor(searchRepository = searchRepository)
    private val listSize = 5

    @Test
    fun `test when execute is successful`() {
        coEvery {
            searchRepository.getRecentSearches()
        } returns List(listSize) { index ->
            DefaultEntity.recentSearch.copy(searchText = "$index")
        }

        coroutineTestRule.runBlockingTest {
            val result = getRecentSearchesUseCase.execute(Unit)
            result.size shouldBe listSize
            result.forEachIndexed { index, item ->
                item.searchText shouldBe "$index"
            }
            coVerify { searchRepository.getRecentSearches() }
        }
    }
}
