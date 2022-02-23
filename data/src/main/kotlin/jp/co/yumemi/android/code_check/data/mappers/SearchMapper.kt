package jp.co.yumemi.android.code_check.data.mappers

import jp.co.yumemi.android.code_check.data.models.RepoMinusSearchMinusResultMinusItemModel
import jp.co.yumemi.android.code_check.domain.entities.GithubRepo

object SearchMapper {
    fun repoModelToEntity(model: RepoMinusSearchMinusResultMinusItemModel): GithubRepo = GithubRepo(
        name = model.fullName,
        ownerIconUrl = model.owner?.avatarUrl,
        language = model.language,
        stargazersCount = model.stargazersCount,
        watchersCount = model.watchersCount,
        forksCount = model.forksCount,
        openIssuesCount = model.openIssuesCount
    )
}
