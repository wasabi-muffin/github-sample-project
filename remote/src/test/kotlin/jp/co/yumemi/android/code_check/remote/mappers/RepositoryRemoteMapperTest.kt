package jp.co.yumemi.android.code_check.remote.mappers

import io.kotest.matchers.shouldBe
import jp.co.yumemi.android.code_check.data.models.RepositoryModel
import jp.co.yumemi.android.code_check.data.models.UserModel
import jp.co.yumemi.android.code_check.remote.models.DefaultModel
import jp.co.yumemi.android.code_check.remote.models.nullableLicenseSimple
import jp.co.yumemi.android.code_check.remote.models.nullableSimpleUser
import jp.co.yumemi.android.code_check.remote.models.repoSearchResultItem
import jp.co.yumemi.android.code_check.remote.models.repository
import org.junit.Test

class RepositoryRemoteMapperTest {
    @Test
    fun `test repo search result item to model`() {
        val model = RepositoryRemoteMapper.toModel(DefaultModel.repoSearchResultItem)
        model shouldBe RepositoryModel(
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
    fun `test non null repo search result item to model`() {
        val model = RepositoryRemoteMapper.toModel(
            DefaultModel.repoSearchResultItem.copy(
                owner = DefaultModel.nullableSimpleUser,
                license = DefaultModel.nullableLicenseSimple
            )
        )
        model shouldBe RepositoryModel(
            id = 0,
            name = "",
            description = null,
            owner = UserModel(id = 0, username = "", iconUrl = "", name = null, blog = null, location = null, email = null, bio = null),
            homepage = null,
            language = null,
            stargazersCount = 0,
            watchersCount = 0,
            forksCount = 0,
            openIssuesCount = 0,
            license = ""
        )
    }

    @Test
    fun `test repository to model`() {
        val model = RepositoryRemoteMapper.toModel(DefaultModel.repository)
        model shouldBe RepositoryModel(
            id = 0,
            name = "",
            description = null,
            owner = UserModel(id = 0, username = "", iconUrl = "", name = null, blog = null, location = null, email = null, bio = null),
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
    fun `test non null repository to model`() {
        val model = RepositoryRemoteMapper.toModel(DefaultModel.repository.copy(license = DefaultModel.nullableLicenseSimple))
        model shouldBe RepositoryModel(
            id = 0,
            name = "",
            description = null,
            owner = UserModel(id = 0, username = "", iconUrl = "", name = null, blog = null, location = null, email = null, bio = null),
            homepage = null,
            language = null,
            stargazersCount = 0,
            watchersCount = 0,
            forksCount = 0,
            openIssuesCount = 0,
            license = ""
        )
    }
}
