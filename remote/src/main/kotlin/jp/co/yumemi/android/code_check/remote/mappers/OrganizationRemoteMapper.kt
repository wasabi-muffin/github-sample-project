package jp.co.yumemi.android.code_check.remote.mappers

import jp.co.yumemi.android.code_check.data.models.OrganizationModel
import jp.co.yumemi.android.code_check.remote.models.UserMinusSearchMinusResultMinusItemApiModel

/**
 * Organizations remote mapper
 *
 * Maps organization api models to data models
 */
object OrganizationRemoteMapper {
    fun toModel(apiModel: UserMinusSearchMinusResultMinusItemApiModel) = OrganizationModel(
        id = apiModel.id,
        name = apiModel.name,
        username = apiModel.login,
        iconUrl = apiModel.avatarUrl,
        description = apiModel.bio
    )
}
