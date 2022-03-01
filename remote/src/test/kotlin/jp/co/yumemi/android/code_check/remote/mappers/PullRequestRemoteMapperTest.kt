package jp.co.yumemi.android.code_check.remote.mappers

import io.kotest.matchers.shouldBe
import jp.co.yumemi.android.code_check.data.models.PullRequestModel
import jp.co.yumemi.android.code_check.data.models.UserModel
import jp.co.yumemi.android.code_check.remote.models.DefaultModel
import jp.co.yumemi.android.code_check.remote.models.issueSearchResultItem
import jp.co.yumemi.android.code_check.remote.models.nullableSimpleUser
import jp.co.yumemi.android.code_check.remote.models.pullRequestSimple
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
