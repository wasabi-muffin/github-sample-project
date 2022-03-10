package io.github.gmvalentino8.github.sample.data.mappers

import io.github.gmvalentino8.github.sample.data.models.PullRequestModel
import io.github.gmvalentino8.github.sample.domain.entities.PullRequest

/**
 * Pull request data mapper
 *
 * Maps pull request data models to domain entities
 */
internal object PullRequestDataMapper {
    fun toEntity(model: PullRequestModel) =
        PullRequest(
            id = model.id,
            title = model.title,
            user = model.user?.let(UserDataMapper::toEntity),
            number = model.number,
            repoName = model.repoName,
            createdAt = model.date,
            status = model.status
        )
}
