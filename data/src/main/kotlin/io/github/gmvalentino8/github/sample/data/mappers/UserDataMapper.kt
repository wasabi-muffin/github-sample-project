package io.github.gmvalentino8.github.sample.data.mappers

import io.github.gmvalentino8.github.sample.data.models.UserModel
import io.github.gmvalentino8.github.sample.domain.entities.User

/**
 * User data mapper
 *
 * Maps data models to domain entities
 */
internal object UserDataMapper {
    fun toEntity(model: UserModel) = User(
        id = model.id,
        name = model.name,
        username = model.username,
        iconUrl = model.iconUrl,
        description = model.bio
    )
}
