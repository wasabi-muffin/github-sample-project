package io.github.gmvalentino8.github.sample.domain.usecases

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.github.gmvalentino8.github.sample.domain.repositories.SearchRepository
import io.github.gmvalentino8.github.sample.test.CoroutineTestRule
import io.github.gmvalentino8.github.sample.test.runBlockingTest
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
