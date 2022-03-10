package io.github.gmvalentino8.github.sample.data.mappers

import io.kotest.matchers.shouldBe
import io.github.gmvalentino8.github.sample.data.models.DefaultModel
import io.github.gmvalentino8.github.sample.domain.entities.Issue
import org.junit.Test

class IssueDataMapperTest {
    @Test
    fun `test mapping issue to entity`() {
        val entity = IssueDataMapper.toEntity(DefaultModel.issue)
        entity shouldBe Issue(id = 0, number = 0, title = "", createdAt = "", repoName = "", status = "")
    }
}
