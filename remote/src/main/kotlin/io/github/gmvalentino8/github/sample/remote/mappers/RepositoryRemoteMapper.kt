package io.github.gmvalentino8.github.sample.remote.mappers

import io.github.gmvalentino8.github.sample.data.models.RepositoryModel
import io.github.gmvalentino8.github.sample.remote.models.RepoMinusSearchMinusResultMinusItemApiModel
import io.github.gmvalentino8.github.sample.remote.models.RepositoryApiModel

/**
 * Issues repository mapper
 *
 * Maps repository api models to data models
 */
object RepositoryRemoteMapper {
    fun toModel(apiModel: RepoMinusSearchMinusResultMinusItemApiModel) = RepositoryModel(
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

    fun toModel(apiModel: RepositoryApiModel) = RepositoryModel(
        id = apiModel.id,
        name = apiModel.fullName,
        description = apiModel.description,
        owner = apiModel.owner.let(UserRemoteMapper::toModel),
        homepage = apiModel.homepage,
        language = apiModel.language,
        stargazersCount = apiModel.stargazersCount,
        watchersCount = apiModel.watchersCount,
        forksCount = apiModel.forksCount,
        openIssuesCount = apiModel.openIssuesCount,
        license = apiModel.license?.name,
    )
}
