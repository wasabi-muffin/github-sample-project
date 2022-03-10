package io.github.gmvalentino8.github.sample.data.mappers

import io.github.gmvalentino8.github.sample.data.models.IssueModel
import io.github.gmvalentino8.github.sample.domain.entities.Issue

/**
 * Issue data mapper
 *
 * Maps issue data models to domain entities
 */
internal object IssueDataMapper {
    fun toEntity(model: IssueModel) = Issue(
        id = model.id,
        number = model.number,
        title = model.title,
        createdAt = model.createdAt,
        repoName = model.repoName,
        status = model.state
    )
}
