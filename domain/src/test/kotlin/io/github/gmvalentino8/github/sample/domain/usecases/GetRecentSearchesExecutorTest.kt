package io.github.gmvalentino8.github.sample.domain.usecases

import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.github.gmvalentino8.github.sample.domain.entities.DefaultEntity
import io.github.gmvalentino8.github.sample.domain.repositories.SearchRepository
import io.github.gmvalentino8.github.sample.test.CoroutineTestRule
import io.github.gmvalentino8.github.sample.test.runBlockingTest
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
