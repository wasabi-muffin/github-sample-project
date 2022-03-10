package io.github.gmvalentino8.github.sample.remote.mappers

import io.github.gmvalentino8.github.sample.data.models.UserModel
import io.github.gmvalentino8.github.sample.remote.models.ContributorApiModel
import io.github.gmvalentino8.github.sample.remote.models.NullableMinusSimpleMinusUserApiModel
import io.github.gmvalentino8.github.sample.remote.models.SimpleMinusUserApiModel
import io.github.gmvalentino8.github.sample.remote.models.UserMinusSearchMinusResultMinusItemApiModel

/**
 * User remote mapper
 *
 * Maps user api models to data models
 */
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
