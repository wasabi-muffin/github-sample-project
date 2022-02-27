package jp.co.yumemi.android.code_check.data.mappers

import jp.co.yumemi.android.code_check.data.models.IssueModel
import jp.co.yumemi.android.code_check.domain.entities.Issue

object IssueDataMapper {
    fun toEntity(model: IssueModel) = Issue(
        id = model.id,
        number = model.number,
        title = model.title,
        createdAt = model.createdAt,
        repository = model.repository?.let(RepositoryDataMapper::toEntity),
        status = model.state
    )
}
