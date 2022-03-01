package jp.co.yumemi.android.code_check.remote.mappers

import io.kotest.matchers.shouldBe
import jp.co.yumemi.android.code_check.data.models.UserModel
import jp.co.yumemi.android.code_check.remote.models.DefaultModel
import jp.co.yumemi.android.code_check.remote.models.contributor
import jp.co.yumemi.android.code_check.remote.models.nullableSimpleUser
import jp.co.yumemi.android.code_check.remote.models.simpleUser
import jp.co.yumemi.android.code_check.remote.models.userSearchResultItem
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
