package jp.co.yumemi.android.code_check.remote.mappers

import jp.co.yumemi.android.code_check.data.models.UserModel
import jp.co.yumemi.android.code_check.remote.models.NullableMinusSimpleMinusUserApiModel

object UserRemoteMapper {
    fun toModel(apiModel: NullableMinusSimpleMinusUserApiModel) = UserModel(
        id = apiModel.id,
        username = apiModel.login,
        iconUrl = apiModel.avatarUrl,
        name = apiModel.name,
        blog = null,
        location = null,
        email = apiModel.email,
        bio = null
    )
}
