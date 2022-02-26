package jp.co.yumemi.android.code_check.data.mappers

import jp.co.yumemi.android.code_check.data.models.RepoSearchModel
import jp.co.yumemi.android.code_check.domain.entities.SimpleGithubRepo

object SearchMapper {
    fun modelToEntity(model: RepoSearchModel): SimpleGithubRepo = SimpleGithubRepo(
        id = model.id,
        name = model.name,
        description = model.description,
        ownerName = model.ownerName,
        ownerIconUrl = model.ownerIconUrl,
        language = model.language,
        stargazersCount = model.stargazersCount,
    )
}
