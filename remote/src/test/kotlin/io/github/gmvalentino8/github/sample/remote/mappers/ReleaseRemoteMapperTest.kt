package io.github.gmvalentino8.github.sample.remote.mappers

import io.kotest.matchers.shouldBe
import io.github.gmvalentino8.github.sample.data.models.ReleaseModel
import io.github.gmvalentino8.github.sample.data.models.UserModel
import io.github.gmvalentino8.github.sample.remote.models.DefaultModel
import io.github.gmvalentino8.github.sample.remote.models.release
import org.junit.Test

class ReleaseRemoteMapperTest {
    @Test
    fun `test to model`() {
        val model = ReleaseRemoteMapper.toModel(DefaultModel.release)
        model shouldBe ReleaseModel(
            id = 0,
            name = null,
            tag = "",
            url = "",
            isDraft = false,
            description = null,
            author = UserModel(id = 0, username = "", iconUrl = "", name = null, blog = null, location = null, email = null, bio = null),
            createdAt = "",
            publishedAt = null
        )
    }
}
