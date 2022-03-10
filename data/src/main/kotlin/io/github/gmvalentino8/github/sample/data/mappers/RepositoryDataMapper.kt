package io.github.gmvalentino8.github.sample.data.mappers

import io.github.gmvalentino8.github.sample.data.models.RepositoryModel
import io.github.gmvalentino8.github.sample.domain.entities.Repository

/**
 * Repository data mapper
 *
 * Maps data models to domain entities
 */
internal object RepositoryDataMapper {
    fun toEntity(model: RepositoryModel): Repository = Repository(
        id = model.id,
        name = model.name,
        description = model.description,
        owner = model.owner?.let(UserDataMapper::toEntity),
        homepage = model.homepage,
        language = model.language,
        stargazersCount = model.stargazersCount,
        watchersCount = model.watchersCount,
        forksCount = model.forksCount,
        openIssuesCount = model.openIssuesCount,
        license = model.license,
    )
}
