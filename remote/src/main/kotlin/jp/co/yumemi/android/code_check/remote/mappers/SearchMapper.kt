package jp.co.yumemi.android.code_check.remote.mappers

import jp.co.yumemi.android.code_check.data.models.RepoSearchModel
import jp.co.yumemi.android.code_check.remote.models.RepoMinusSearchMinusResultMinusItemApiModel

object SearchMapper {
    fun apiToData(apiModel: RepoMinusSearchMinusResultMinusItemApiModel) = RepoSearchModel(
        name = apiModel.fullName,
        ownerIconUrl = apiModel.owner?.avatarUrl,
        language = apiModel.language,
        stargazersCount = apiModel.stargazersCount,
        watchersCount = apiModel.watchersCount,
        forksCount = apiModel.forksCount,
        openIssuesCount = apiModel.openIssuesCount
    )
}
