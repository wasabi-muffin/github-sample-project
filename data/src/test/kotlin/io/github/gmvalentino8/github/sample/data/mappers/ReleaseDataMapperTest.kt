package io.github.gmvalentino8.github.sample.data.mappers

import io.kotest.matchers.shouldBe
import io.github.gmvalentino8.github.sample.data.models.DefaultModel
import io.github.gmvalentino8.github.sample.domain.entities.Release
import org.junit.Test

class ReleaseDataMapperTest {
    @Test
    fun `test mapping release to entity`() {
        val entity = ReleaseDataMapper.toEntity(DefaultModel.release)
        entity shouldBe Release(id = 0, name = null, tag = "", description = null, authorUsername = null, authorIconUrl = null, date = "")
    }

    @Test
    fun `test mapping non null release to entity`() {
        val entity = ReleaseDataMapper.toEntity(DefaultModel.release.copy(author = DefaultModel.user.copy(iconUrl = "")))
        entity shouldBe Release(id = 0, name = null, tag = "", description = null, authorUsername = "", authorIconUrl = "", date = "")
    }
}
