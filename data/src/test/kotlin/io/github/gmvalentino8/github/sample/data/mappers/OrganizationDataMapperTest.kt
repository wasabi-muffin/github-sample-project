package io.github.gmvalentino8.github.sample.data.mappers

import io.kotest.matchers.shouldBe
import io.github.gmvalentino8.github.sample.data.models.DefaultModel
import io.github.gmvalentino8.github.sample.domain.entities.Organization
import org.junit.Test

class OrganizationDataMapperTest {
    @Test
    fun `test mapping organization to entity`() {
        val entity = OrganizationDataMapper.toEntity(DefaultModel.organization)
        entity shouldBe Organization(id = 0, name = null, username = "", iconUrl = null, description = null)
    }
}
