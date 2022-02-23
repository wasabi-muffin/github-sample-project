package jp.co.yumemi.android.code_check.local.mappers

import io.kotest.matchers.shouldBe
import jp.co.yumemi.android.code_check.data.models.RecentSearchModel
import jp.co.yumemi.android.code_check.local.models.RecentSearchDbModel
import org.junit.Test

class RecentSearchMapperTest {
    @Test
    fun `test mapping from data model to db model`() {
        RecentSearchMapper.dataToDb(
            RecentSearchModel(searchText = "", timestamp = 0L)
        ).run {
            searchText shouldBe ""
            timestamp shouldBe 0L
        }
    }

    @Test
    fun `test mapping from db model to data model`() {
        RecentSearchMapper.dbToData(
            RecentSearchDbModel(searchText = "", timestamp = 0L)
        ).run {
            searchText shouldBe ""
            timestamp shouldBe 0L
        }
    }
}
