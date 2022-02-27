package jp.co.yumemi.android.code_check.remote.mappers

import jp.co.yumemi.android.code_check.data.models.PullRequestModel
import jp.co.yumemi.android.code_check.remote.models.IssueMinusSearchMinusResultMinusItemApiModel
import jp.co.yumemi.android.code_check.remote.models.PullMinusRequestMinusSimpleApiModel

object PullRequestRemoteMapper {
    fun toModel(apiModel: PullMinusRequestMinusSimpleApiModel) =
        PullRequestModel(
            id = apiModel.id,
            title = apiModel.title,
            user = apiModel.user?.let(UserRemoteMapper::toModel),
            number = apiModel.number,
            repository = null,
            date = apiModel.createdAt,
            status = apiModel.state
        )

    fun toModel(apiModel: IssueMinusSearchMinusResultMinusItemApiModel) =
        PullRequestModel(
            id = apiModel.id,
            title = apiModel.title,
            number = apiModel.number,
            user = apiModel.user?.let(UserRemoteMapper::toModel),
            repository = apiModel.repository?.let(RepositoryRemoteMapper::toModel),
            date = apiModel.createdAt,
            status = apiModel.state
        )
}
