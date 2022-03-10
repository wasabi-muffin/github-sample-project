package io.github.gmvalentino8.github.sample.remote.mappers

import io.kotest.matchers.shouldBe
import io.github.gmvalentino8.github.sample.data.models.RepositoryModel
import io.github.gmvalentino8.github.sample.data.models.UserModel
import io.github.gmvalentino8.github.sample.remote.models.DefaultModel
import io.github.gmvalentino8.github.sample.remote.models.nullableLicenseSimple
import io.github.gmvalentino8.github.sample.remote.models.nullableSimpleUser
import io.github.gmvalentino8.github.sample.remote.models.repoSearchResultItem
import io.github.gmvalentino8.github.sample.remote.models.repository
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
