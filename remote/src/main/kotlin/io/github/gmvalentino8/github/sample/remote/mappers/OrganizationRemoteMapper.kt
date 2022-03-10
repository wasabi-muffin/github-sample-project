package io.github.gmvalentino8.github.sample.remote.mappers

import io.github.gmvalentino8.github.sample.data.models.OrganizationModel
import io.github.gmvalentino8.github.sample.remote.models.UserMinusSearchMinusResultMinusItemApiModel

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
