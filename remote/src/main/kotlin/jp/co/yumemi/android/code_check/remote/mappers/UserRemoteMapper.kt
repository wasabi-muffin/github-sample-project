package jp.co.yumemi.android.code_check.remote.mappers

import jp.co.yumemi.android.code_check.data.models.UserModel
import jp.co.yumemi.android.code_check.remote.models.ContributorApiModel
import jp.co.yumemi.android.code_check.remote.models.NullableMinusSimpleMinusUserApiModel
import jp.co.yumemi.android.code_check.remote.models.SimpleMinusUserApiModel
import jp.co.yumemi.android.code_check.remote.models.UserMinusSearchMinusResultMinusItemApiModel

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

    fun toModel(apiModel: SimpleMinusUserApiModel) = UserModel(
        id = apiModel.id,
        username = apiModel.login,
        iconUrl = apiModel.avatarUrl,
        name = apiModel.name,
        blog = null,
        location = null,
        email = apiModel.email,
        bio = null
    )

    fun toModel(apiModel: ContributorApiModel) = UserModel(
        id = apiModel.id ?: -1,
        username = apiModel.login ?: "",
        iconUrl = apiModel.avatarUrl,
        name = apiModel.name,
        blog = null,
        location = null,
        email = apiModel.email,
        bio = null
    )

    fun toModel(apiModel: UserMinusSearchMinusResultMinusItemApiModel) = UserModel(
        id = apiModel.id,
        name = apiModel.name,
        username = apiModel.login,
        iconUrl = apiModel.avatarUrl,
        bio = apiModel.bio,
        blog = apiModel.blog,
        location = apiModel.location,
        email = apiModel.email,
    )
}
