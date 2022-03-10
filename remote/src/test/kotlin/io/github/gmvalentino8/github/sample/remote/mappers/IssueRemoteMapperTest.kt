package io.github.gmvalentino8.github.sample.remote.mappers

import io.kotest.matchers.shouldBe
import io.github.gmvalentino8.github.sample.data.models.IssueModel
import io.github.gmvalentino8.github.sample.remote.models.DefaultModel
import io.github.gmvalentino8.github.sample.remote.models.issueSearchResultItem
import org.junit.Test

class IssueRemoteMapperTest {
    @Test
    fun `test to model`() {
        val model = IssueRemoteMapper.toModel(DefaultModel.issueSearchResultItem)
        model shouldBe IssueModel(id = 0, number = 0, title = "", createdAt = "", repoName = "", state = "")
    }
}
