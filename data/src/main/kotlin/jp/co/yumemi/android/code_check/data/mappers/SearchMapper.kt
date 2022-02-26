package jp.co.yumemi.android.code_check.data.mappers

import jp.co.yumemi.android.code_check.data.models.RepoSearchModel
import jp.co.yumemi.android.code_check.domain.entities.Repository

object SearchMapper {
    fun modelToEntity(model: RepoSearchModel): Repository = Repository(
        id = model.id,
        name = model.name,
        description = model.description,
        ownerName = model.ownerName,
        ownerIconUrl = model.ownerIconUrl,
        homepage = model.homepage,
        language = model.language,
        stargazersCount = model.stargazersCount,
        watchersCount = model.watchersCount,
        forksCount = model.forksCount,
        openIssuesCount = model.openIssuesCount,
        license = model.license,
    )
}
