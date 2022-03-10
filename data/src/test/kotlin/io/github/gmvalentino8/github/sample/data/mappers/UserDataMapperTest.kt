package io.github.gmvalentino8.github.sample.data.mappers

import io.kotest.matchers.shouldBe
import io.github.gmvalentino8.github.sample.data.models.DefaultModel
import io.github.gmvalentino8.github.sample.domain.entities.User
import org.junit.Test

class UserDataMapperTest {
    @Test
    fun `test mapping user to entity`() {
        val entity = UserDataMapper.toEntity(DefaultModel.user)
        entity shouldBe User(id = 0, name = null, username = "", iconUrl = null, description = null)
    }
}
