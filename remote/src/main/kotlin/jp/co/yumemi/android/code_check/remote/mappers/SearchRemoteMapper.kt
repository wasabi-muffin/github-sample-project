package jp.co.yumemi.android.code_check.remote.mappers

import jp.co.yumemi.android.code_check.data.models.RepoSearchModel
import jp.co.yumemi.android.code_check.remote.models.RepoMinusSearchMinusResultMinusItemApiModel

object SearchRemoteMapper {
    fun toModel(apiModel: RepoMinusSearchMinusResultMinusItemApiModel) = RepoSearchModel(
        id = apiModel.id,
        name = apiModel.fullName,
        description = apiModel.description,
        owner = apiModel.owner?.let(UserRemoteMapper::toModel),
        homepage = apiModel.homepage,
        language = apiModel.language,
        stargazersCount = apiModel.stargazersCount,
        watchersCount = apiModel.watchersCount,
        forksCount = apiModel.forksCount,
        openIssuesCount = apiModel.openIssuesCount,
        license = apiModel.license?.name,
    )
}
