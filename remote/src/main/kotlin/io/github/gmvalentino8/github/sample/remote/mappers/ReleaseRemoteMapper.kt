package io.github.gmvalentino8.github.sample.remote.mappers

import io.github.gmvalentino8.github.sample.data.models.ReleaseModel
import io.github.gmvalentino8.github.sample.remote.models.ReleaseApiModel

/**
 * Release remote mapper
 *
 * Maps release api models to data models
 */
object ReleaseRemoteMapper {
    fun toModel(apiModel: ReleaseApiModel) = ReleaseModel(
        id = apiModel.id,
        name = apiModel.name,
        tag = apiModel.tagName,
        url = apiModel.url,
        isDraft = apiModel.draft,
        description = apiModel.body,
        author = apiModel.author.let(UserRemoteMapper::toModel),
        createdAt = apiModel.createdAt,
        publishedAt = apiModel.publishedAt
    )
}
