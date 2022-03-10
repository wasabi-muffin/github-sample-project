package io.github.gmvalentino8.github.sample.remote.mappers

import io.kotest.matchers.shouldBe
import io.github.gmvalentino8.github.sample.data.models.PullRequestModel
import io.github.gmvalentino8.github.sample.data.models.UserModel
import io.github.gmvalentino8.github.sample.remote.models.DefaultModel
import io.github.gmvalentino8.github.sample.remote.models.issueSearchResultItem
import io.github.gmvalentino8.github.sample.remote.models.nullableSimpleUser
import io.github.gmvalentino8.github.sample.remote.models.pullRequestSimple
import org.junit.Test

class PullRequestRemoteMapperTest {
    @Test
    fun `test issue search result item to model`() {
        val model = PullRequestRemoteMapper.toModel(DefaultModel.issueSearchResultItem)
        model shouldBe PullRequestModel(id = 0, title = "", user = null, number = 0, repoName = "", date = "", status = "")
    }

    @Test
    fun `test non null issue search result item to model`() {
        val model = PullRequestRemoteMapper.toModel(DefaultModel.issueSearchResultItem.copy(user = DefaultModel.nullableSimpleUser))
        model shouldBe PullRequestModel(
            id = 0,
            title = "",
            user = UserModel(id = 0, username = "", iconUrl = "", name = null, blog = null, location = null, email = null, bio = null),
            number = 0,
            repoName = "",
            date = "",
            status = ""
        )
    }

    @Test
    fun `test pull request simple to model`() {
        val model = PullRequestRemoteMapper.toModel(DefaultModel.pullRequestSimple)
        model shouldBe PullRequestModel(id = 0, title = "", user = null, number = 0, repoName = "", date = "", status = "")
    }

    @Test
    fun `test non null pull request simple to model`() {
        val model = PullRequestRemoteMapper.toModel(DefaultModel.pullRequestSimple.copy(user = DefaultModel.nullableSimpleUser))
        model shouldBe PullRequestModel(
            id = 0,
            title = "",
            user = UserModel(id = 0, username = "", iconUrl = "", name = null, blog = null, location = null, email = null, bio = null),
            number = 0,
            repoName = "",
            date = "",
            status = ""
        )
    }
}
