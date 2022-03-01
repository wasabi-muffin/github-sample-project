package jp.co.yumemi.android.code_check.data.mappers

import io.kotest.matchers.shouldBe
import jp.co.yumemi.android.code_check.data.models.DefaultModel
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.entities.User
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
