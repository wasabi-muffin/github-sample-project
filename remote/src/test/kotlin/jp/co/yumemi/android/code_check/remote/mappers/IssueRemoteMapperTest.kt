package jp.co.yumemi.android.code_check.remote.mappers

import io.kotest.matchers.shouldBe
import jp.co.yumemi.android.code_check.data.models.IssueModel
import jp.co.yumemi.android.code_check.remote.models.DefaultModel
import jp.co.yumemi.android.code_check.remote.models.issueSearchResultItem
import org.junit.Test

class IssueRemoteMapperTest {
    @Test
    fun `test to model`() {
        val model = IssueRemoteMapper.toModel(DefaultModel.issueSearchResultItem)
        model shouldBe IssueModel(id = 0, number = 0, title = "", createdAt = "", repoName = "", state = "")
    }
}
