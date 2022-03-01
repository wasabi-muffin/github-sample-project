package jp.co.yumemi.android.code_check.data.mappers

import io.kotest.matchers.shouldBe
import jp.co.yumemi.android.code_check.data.models.DefaultModel
import jp.co.yumemi.android.code_check.domain.entities.Organization
import org.junit.Test

class OrganizationDataMapperTest {
    @Test
    fun `test mapping organization to entity`() {
        val entity = OrganizationDataMapper.toEntity(DefaultModel.organization)
        entity shouldBe Organization(id = 0, name = null, username = "", iconUrl = null, description = null)
    }
}
