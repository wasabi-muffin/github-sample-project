package io.github.gmvalentino8.github.sample.local.mappers

import io.kotest.matchers.shouldBe
import io.github.gmvalentino8.github.sample.data.models.RecentSearchModel
import io.github.gmvalentino8.github.sample.local.models.RecentSearchDbModel
import org.junit.Test

class RecentSearchLocalMapperTest {
    @Test
    fun `test mapping from data model to db model`() {
        RecentSearchLocalMapper.dataToDb(
            RecentSearchModel(searchText = "", timestamp = 0L)
        ).run {
            searchText shouldBe ""
            timestamp shouldBe 0L
        }
    }

    @Test
    fun `test mapping from db model to data model`() {
        RecentSearchLocalMapper.dbToData(
            RecentSearchDbModel(searchText = "", timestamp = 0L)
        ).run {
            searchText shouldBe ""
            timestamp shouldBe 0L
        }
    }
}
