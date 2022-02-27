package jp.co.yumemi.android.code_check.remote.mappers

import jp.co.yumemi.android.code_check.data.models.PullRequestModel
import jp.co.yumemi.android.code_check.remote.models.PullMinusRequestMinusSimpleApiModel

object PullRequestRemoteMapper {
    fun toModel(apiModel: PullMinusRequestMinusSimpleApiModel) =
        PullRequestModel(
            id = apiModel.id,
            title = apiModel.title,
            user = apiModel.user?.let(UserRemoteMapper::toModel),
            repository = null,
            date = apiModel.createdAt,
            isDraft = apiModel.draft ?: false
        )
}
