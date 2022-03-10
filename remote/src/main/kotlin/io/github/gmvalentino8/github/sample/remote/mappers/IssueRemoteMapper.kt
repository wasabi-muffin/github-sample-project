package io.github.gmvalentino8.github.sample.remote.mappers

import io.github.gmvalentino8.github.sample.data.models.IssueModel
import io.github.gmvalentino8.github.sample.remote.models.IssueMinusSearchMinusResultMinusItemApiModel
import io.github.gmvalentino8.github.sample.remote.utils.filterRepoName

/**
 * Issue remote mapper
 *
 * Maps issue api models to data models
 */
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
