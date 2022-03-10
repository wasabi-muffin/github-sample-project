package io.github.gmvalentino8.github.sample.remote.mappers

import io.github.gmvalentino8.github.sample.data.models.PullRequestModel
import io.github.gmvalentino8.github.sample.remote.models.IssueMinusSearchMinusResultMinusItemApiModel
import io.github.gmvalentino8.github.sample.remote.models.PullMinusRequestMinusSimpleApiModel
import io.github.gmvalentino8.github.sample.remote.utils.filterRepoName

/**
 * Pull requests remote mapper
 *
 * Maps pull request api models to data models
 */
object PullRequestRemoteMapper {
    fun toModel(apiModel: PullMinusRequestMinusSimpleApiModel) =
        PullRequestModel(
            id = apiModel.id,
            title = apiModel.title,
            user = apiModel.user?.let(UserRemoteMapper::toModel),
            number = apiModel.number,
            repoName = apiModel.url.filterRepoName(endPathDelimiter = "issues"),
            date = apiModel.createdAt,
            status = apiModel.state
        )

    fun toModel(apiModel: IssueMinusSearchMinusResultMinusItemApiModel) =
        PullRequestModel(
            id = apiModel.id,
            title = apiModel.title,
            number = apiModel.number,
            user = apiModel.user?.let(UserRemoteMapper::toModel),
            repoName = apiModel.url.filterRepoName(endPathDelimiter = "issues"),
            date = apiModel.createdAt,
            status = apiModel.state
        )
}
