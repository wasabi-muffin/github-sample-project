package jp.co.yumemi.android.code_check.remote.mappers

import jp.co.yumemi.android.code_check.data.models.RepoSearchModel
import jp.co.yumemi.android.code_check.remote.models.RepoMinusSearchMinusResultMinusItemApiModel

object SearchMapper {
    fun apiToData(apiModel: RepoMinusSearchMinusResultMinusItemApiModel) = RepoSearchModel(
        id = apiModel.id,
        name = apiModel.fullName,
        description = apiModel.description,
        ownerName = apiModel.owner?.login,
        ownerIconUrl = apiModel.owner?.avatarUrl,
        homepage = apiModel.homepage,
        language = apiModel.language,
        stargazersCount = apiModel.stargazersCount,
        watchersCount = apiModel.watchersCount,
        forksCount = apiModel.forksCount,
        openIssuesCount = apiModel.openIssuesCount,
        license = apiModel.license?.name,
    )
}
