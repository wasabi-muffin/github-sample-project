package jp.co.yumemi.android.code_check.remote.mappers

import jp.co.yumemi.android.code_check.data.models.IssueModel
import jp.co.yumemi.android.code_check.remote.models.IssueMinusSearchMinusResultMinusItemApiModel
import jp.co.yumemi.android.code_check.remote.utils.filterRepoName

object IssueRemoteMapper {
    fun toModel(apiModel: IssueMinusSearchMinusResultMinusItemApiModel) = IssueModel(
        id = apiModel.id,
        number = apiModel.number,
        title = apiModel.title,
        createdAt = apiModel.createdAt,
        repoName = apiModel.url.filterRepoName(endPathDelimiter = "issues"),
        state = apiModel.state
    )
}
