package io.github.gmvalentino8.github.sample.remote.mappers

import io.kotest.matchers.shouldBe
import io.github.gmvalentino8.github.sample.data.models.OrganizationModel
import io.github.gmvalentino8.github.sample.remote.models.DefaultModel
import io.github.gmvalentino8.github.sample.remote.models.userSearchResultItem
import org.junit.Test

class OrganizationRemoteMapperTest {
    @Test
    fun `test to model`() {
        val model = OrganizationRemoteMapper.toModel(DefaultModel.userSearchResultItem)
        model shouldBe OrganizationModel(id = 0, name = null, username = "", iconUrl = "", description = null)
    }
}
