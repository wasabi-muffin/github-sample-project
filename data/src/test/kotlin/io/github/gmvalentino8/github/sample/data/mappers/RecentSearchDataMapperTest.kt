package io.github.gmvalentino8.github.sample.data.mappers

import io.kotest.matchers.shouldBe
import io.github.gmvalentino8.github.sample.data.models.DefaultModel
import io.github.gmvalentino8.github.sample.domain.entities.RecentSearch
import org.junit.Test

class RecentSearchDataMapperTest {
    @Test
    fun `test mapping recent search to entity`() {
        val entity = RecentSearchDataMapper.toEntity(DefaultModel.recentSearch)
        entity shouldBe RecentSearch(searchText = "", timestamp = 0)
    }
}
