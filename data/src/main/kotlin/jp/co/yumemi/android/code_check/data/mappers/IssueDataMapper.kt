package jp.co.yumemi.android.code_check.data.mappers

import jp.co.yumemi.android.code_check.data.models.IssueModel
import jp.co.yumemi.android.code_check.domain.entities.Issue

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
