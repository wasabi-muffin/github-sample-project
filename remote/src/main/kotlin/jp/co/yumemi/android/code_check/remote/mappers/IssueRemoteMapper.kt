package jp.co.yumemi.android.code_check.remote.mappers

import jp.co.yumemi.android.code_check.data.models.IssueModel
import jp.co.yumemi.android.code_check.remote.models.IssueMinusSearchMinusResultMinusItemApiModel

object IssueRemoteMapper {
    fun toModel(apiModel: IssueMinusSearchMinusResultMinusItemApiModel) = IssueModel(
        id = apiModel.id,
        number = apiModel.number,
        title = apiModel.title,
        createdAt = apiModel.createdAt,
        repository = apiModel.repository?.let(RepositoryRemoteMapper::toModel),
        state = apiModel.state
    )
}
