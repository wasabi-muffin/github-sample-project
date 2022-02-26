package jp.co.yumemi.android.code_check.data.mappers

import io.kotest.matchers.shouldBe
import jp.co.yumemi.android.code_check.data.models.RepoSearchModel
import jp.co.yumemi.android.code_check.data.models.UserModel
import jp.co.yumemi.android.code_check.domain.entities.User
import org.junit.Test

class RepositoryDataMapperTest {
    @Test
    fun `test for mapping github repo model to entity`() {
        val entity = RepositoryDataMapper.toEntity(
            RepoSearchModel(
                id = 1,
                name = "",
                description = "",
                owner = UserModel(id = 0, name = null, username = "", iconUrl = null, blog = null, location = null, email = null, bio = null),
                language = null,
                homepage = "",
                stargazersCount = 0,
                watchersCount = 0,
                forksCount = 0,
                openIssuesCount = 0,
                license = null,
            )
        )
        entity.id shouldBe 1
        entity.name shouldBe ""
        entity.description shouldBe ""
        entity.homepage shouldBe ""
        entity.language shouldBe null
        entity.stargazersCount shouldBe 0
        entity.watchersCount shouldBe 0
        entity.forksCount shouldBe 0
        entity.openIssuesCount shouldBe 0
        entity.license shouldBe null
    }
}
