package jp.co.yumemi.android.code_check.data.mappers

import jp.co.yumemi.android.code_check.data.models.PullRequestModel
import jp.co.yumemi.android.code_check.domain.entities.PullRequest

object PullRequestDataMapper {
    fun toEntity(model: PullRequestModel) =
        PullRequest(
            id = model.id,
            title = model.title,
            user = model.user?.let(UserDataMapper::toEntity),
            repository = model.repository?.let(RepositoryDataMapper::toEntity),
            createdAt = model.date,
            isDraft = model.isDraft
        )
}
