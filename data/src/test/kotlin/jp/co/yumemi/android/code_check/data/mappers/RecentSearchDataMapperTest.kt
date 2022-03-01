package jp.co.yumemi.android.code_check.data.mappers

import io.kotest.matchers.shouldBe
import jp.co.yumemi.android.code_check.data.models.DefaultModel
import jp.co.yumemi.android.code_check.domain.entities.RecentSearch
import org.junit.Test

class RecentSearchDataMapperTest {
    @Test
    fun `test mapping recent search to entity`() {
        val entity = RecentSearchDataMapper.toEntity(DefaultModel.recentSearch)
        entity shouldBe RecentSearch(searchText = "", timestamp = 0)
    }
}
