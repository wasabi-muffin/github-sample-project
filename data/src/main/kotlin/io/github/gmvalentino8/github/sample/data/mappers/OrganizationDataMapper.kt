package io.github.gmvalentino8.github.sample.data.mappers

import io.github.gmvalentino8.github.sample.data.models.OrganizationModel
import io.github.gmvalentino8.github.sample.domain.entities.Organization

/**
 * Organization data mapper
 *
 * Maps organization data models to domain entities
 */
internal object OrganizationDataMapper {
    fun toEntity(model: OrganizationModel) = Organization(
        id = model.id,
        name = model.name,
        username = model.username,
        iconUrl = model.iconUrl,
        description = model.description
    )
}
