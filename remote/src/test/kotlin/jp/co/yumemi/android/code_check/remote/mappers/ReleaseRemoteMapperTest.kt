package jp.co.yumemi.android.code_check.remote.mappers

import io.kotest.matchers.shouldBe
import jp.co.yumemi.android.code_check.data.models.ReleaseModel
import jp.co.yumemi.android.code_check.data.models.UserModel
import jp.co.yumemi.android.code_check.remote.models.DefaultModel
import jp.co.yumemi.android.code_check.remote.models.release
import org.junit.Test

class ReleaseRemoteMapperTest {
    @Test
    fun `test to model`() {
        val model = ReleaseRemoteMapper.toModel(DefaultModel.release)
        model shouldBe ReleaseModel(
            id = 0,
            name = null,
            tag = "",
            url = "",
            isDraft = false,
            description = null,
            author = UserModel(id = 0, username = "", iconUrl = "", name = null, blog = null, location = null, email = null, bio = null),
            createdAt = "",
            publishedAt = null
        )
    }
}
