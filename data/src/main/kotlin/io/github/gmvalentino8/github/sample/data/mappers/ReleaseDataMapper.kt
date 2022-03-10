package io.github.gmvalentino8.github.sample.data.mappers

import io.github.gmvalentino8.github.sample.data.models.ReleaseModel
import io.github.gmvalentino8.github.sample.domain.entities.Release

/**
 * Release data mapper
 *
 * Maps release data models to domain entities
 */
internal object ReleaseDataMapper {
    fun toEntity(model: ReleaseModel) = Release(
        id = model.id,
        name = model.name,
        tag = model.tag,
        description = model.description,
        authorUsername = model.author?.username,
        authorIconUrl = model.author?.iconUrl,
        date = model.createdAt
    )
}
