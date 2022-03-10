package io.github.gmvalentino8.github.sample.data.mappers

import io.kotest.matchers.shouldBe
import io.github.gmvalentino8.github.sample.data.models.DefaultModel
import io.github.gmvalentino8.github.sample.domain.entities.PullRequest
import io.github.gmvalentino8.github.sample.domain.entities.User
import org.junit.Test

class PullRequestDataMapperTest {
    @Test
    fun `test mapping pull request to entity`() {
        val entity = PullRequestDataMapper.toEntity(DefaultModel.pullRequest)
        entity shouldBe PullRequest(id = 0, number = 0, title = "", createdAt = "", repoName = "", status = "", user = null)
    }

    @Test
    fun `test mapping non null pull request to entity`() {
        val entity = PullRequestDataMapper.toEntity(DefaultModel.pullRequest.copy(user = DefaultModel.user))
        entity shouldBe PullRequest(
            id = 0,
            number = 0,
            title = "",
            createdAt = "",
            repoName = "",
            status = "",
            user = User(id = 0, name = null, username = "", iconUrl = null, description = null)
        )
    }
}
