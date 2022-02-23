package jp.co.yumemi.android.code_check.data.mappers

import jp.co.yumemi.android.code_check.data.models.RepoSearchModel
import jp.co.yumemi.android.code_check.domain.entities.GithubRepo

object SearchMapper {
    fun repoModelToEntity(model: RepoSearchModel): GithubRepo = GithubRepo(
        name = model.name,
        ownerIconUrl = model.ownerIconUrl,
        language = model.language,
        stargazersCount = model.stargazersCount,
        watchersCount = model.watchersCount,
        forksCount = model.forksCount,
        openIssuesCount = model.openIssuesCount
    )
}
