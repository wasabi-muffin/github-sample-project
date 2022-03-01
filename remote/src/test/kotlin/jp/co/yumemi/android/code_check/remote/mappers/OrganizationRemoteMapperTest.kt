package jp.co.yumemi.android.code_check.remote.mappers

import io.kotest.matchers.shouldBe
import jp.co.yumemi.android.code_check.data.models.OrganizationModel
import jp.co.yumemi.android.code_check.remote.models.DefaultModel
import jp.co.yumemi.android.code_check.remote.models.userSearchResultItem
import org.junit.Test

class OrganizationRemoteMapperTest {
    @Test
    fun `test to model`() {
        val model = OrganizationRemoteMapper.toModel(DefaultModel.userSearchResultItem)
        model shouldBe OrganizationModel(id = 0, name = null, username = "", iconUrl = "", description = null)
    }
}
