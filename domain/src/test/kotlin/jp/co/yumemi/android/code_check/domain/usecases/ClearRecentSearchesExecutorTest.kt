package jp.co.yumemi.android.code_check.domain.usecases

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository
import jp.co.yumemi.android.code_check.test.CoroutineTestRule
import jp.co.yumemi.android.code_check.test.runBlockingTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ClearRecentSearchesExecutorTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()
    private val searchRepository = mockk<SearchRepository>()
    private val clearRecentSearchesUseCase = ClearRecentSearchesExecutor(searchRepository = searchRepository)

    @Test
    fun `test when execute is successful`() {
        coEvery {
            searchRepository.clearRecentSearches()
        } returns Unit

        coroutineTestRule.runBlockingTest {
            clearRecentSearchesUseCase.execute(Unit)
            coVerify { searchRepository.clearRecentSearches() }
        }
    }
}
