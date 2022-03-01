package jp.co.yumemi.android.code_check.data.mappers

import io.kotest.matchers.shouldBe
import jp.co.yumemi.android.code_check.data.models.DefaultModel
import jp.co.yumemi.android.code_check.domain.entities.User
import org.junit.Test

class UserDataMapperTest {
    @Test
    fun `test mapping user to entity`() {
        val entity = UserDataMapper.toEntity(DefaultModel.user)
        entity shouldBe User(id = 0, name = null, username = "", iconUrl = null, description = null)
    }
}
