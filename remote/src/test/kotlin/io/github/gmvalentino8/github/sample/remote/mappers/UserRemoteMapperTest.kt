package io.github.gmvalentino8.github.sample.remote.mappers

import io.kotest.matchers.shouldBe
import io.github.gmvalentino8.github.sample.data.models.UserModel
import io.github.gmvalentino8.github.sample.remote.models.DefaultModel
import io.github.gmvalentino8.github.sample.remote.models.contributor
import io.github.gmvalentino8.github.sample.remote.models.nullableSimpleUser
import io.github.gmvalentino8.github.sample.remote.models.simpleUser
import io.github.gmvalentino8.github.sample.remote.models.userSearchResultItem
import org.junit.Test

class UserRemoteMapperTest {
    @Test
    fun `test user search result item to model`() {
        val model = UserRemoteMapper.toModel(DefaultModel.userSearchResultItem)
        model shouldBe UserModel(id = 0, username = "", iconUrl = "", name = null, blog = null, location = null, email = null, bio = null)
    }

    @Test
    fun `test simple user to model`() {
        val model = UserRemoteMapper.toModel(DefaultModel.simpleUser)
        model shouldBe UserModel(id = 0, username = "", iconUrl = "", name = null, blog = null, location = null, email = null, bio = null)
    }

    @Test
    fun `test nullable simple user to model`() {
        val model = UserRemoteMapper.toModel(DefaultModel.nullableSimpleUser)
        model shouldBe UserModel(id = 0, username = "", iconUrl = "", name = null, blog = null, location = null, email = null, bio = null)
    }

    @Test
    fun `test contributor to model`() {
        val model = UserRemoteMapper.toModel(DefaultModel.contributor)
        model shouldBe UserModel(id = -1, username = "", iconUrl = null, name = null, blog = null, location = null, email = null, bio = null)
    }

    @Test
    fun `test non null contributor to model`() {
        val model = UserRemoteMapper.toModel(DefaultModel.contributor.copy(id = 1, login = "login"))
        model shouldBe UserModel(id = 1, username = "login", iconUrl = null, name = null, blog = null, location = null, email = null, bio = null)
    }
}
