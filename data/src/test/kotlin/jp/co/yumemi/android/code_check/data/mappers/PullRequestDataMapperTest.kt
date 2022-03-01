package jp.co.yumemi.android.code_check.data.mappers

import io.kotest.matchers.shouldBe
import jp.co.yumemi.android.code_check.data.models.DefaultModel
import jp.co.yumemi.android.code_check.domain.entities.PullRequest
import jp.co.yumemi.android.code_check.domain.entities.User
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
