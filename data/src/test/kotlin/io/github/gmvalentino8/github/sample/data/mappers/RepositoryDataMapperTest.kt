package io.github.gmvalentino8.github.sample.data.mappers

import io.kotest.matchers.shouldBe
import io.github.gmvalentino8.github.sample.data.models.DefaultModel
import io.github.gmvalentino8.github.sample.domain.entities.Repository
import io.github.gmvalentino8.github.sample.domain.entities.User
import org.junit.Test

class RepositoryDataMapperTest {
    @Test
    fun `test mapping repository to entity`() {
        val entity = RepositoryDataMapper.toEntity(DefaultModel.repository)
        entity shouldBe Repository(
            id = 0,
            name = "",
            description = null,
            owner = null,
            homepage = null,
            language = null,
            stargazersCount = 0,
            watchersCount = 0,
            forksCount = 0,
            openIssuesCount = 0,
            license = null
        )
    }

    @Test
    fun `test mapping non null repository to entity`() {
        val entity = RepositoryDataMapper.toEntity(DefaultModel.repository.copy(owner = DefaultModel.user))
        entity shouldBe Repository(
            id = 0,
            name = "",
            description = null,
            owner = User(id = 0, name = null, username = "", iconUrl = null, description = null),
            homepage = null,
            language = null,
            stargazersCount = 0,
            watchersCount = 0,
            forksCount = 0,
            openIssuesCount = 0,
            license = null
        )
    }
}
