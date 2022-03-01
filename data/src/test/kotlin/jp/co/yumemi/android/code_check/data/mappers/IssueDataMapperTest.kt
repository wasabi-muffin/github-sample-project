package jp.co.yumemi.android.code_check.data.mappers

import io.kotest.matchers.shouldBe
import jp.co.yumemi.android.code_check.data.models.DefaultModel
import jp.co.yumemi.android.code_check.domain.entities.Issue
import org.junit.Test

class IssueDataMapperTest {
    @Test
    fun `test mapping issue to entity`() {
        val entity = IssueDataMapper.toEntity(DefaultModel.issue)
        entity shouldBe Issue(id = 0, number = 0, title = "", createdAt = "", repoName = "", status = "")
    }
}
