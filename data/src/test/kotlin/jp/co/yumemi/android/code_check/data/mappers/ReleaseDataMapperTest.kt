package jp.co.yumemi.android.code_check.data.mappers

import io.kotest.matchers.shouldBe
import jp.co.yumemi.android.code_check.data.models.DefaultModel
import jp.co.yumemi.android.code_check.domain.entities.Release
import org.junit.Test

class ReleaseDataMapperTest {
    @Test
    fun `test mapping release to entity`() {
        val entity = ReleaseDataMapper.toEntity(DefaultModel.release)
        entity shouldBe Release(id = 0, name = null, tag = "", description = null, authorUsername = null, authorIconUrl = null, date = "")
    }

    @Test
    fun `test mapping non null release to entity`() {
        val entity = ReleaseDataMapper.toEntity(DefaultModel.release.copy(author = DefaultModel.user.copy(iconUrl = "")))
        entity shouldBe Release(id = 0, name = null, tag = "", description = null, authorUsername = "", authorIconUrl = "", date = "")
    }
}
