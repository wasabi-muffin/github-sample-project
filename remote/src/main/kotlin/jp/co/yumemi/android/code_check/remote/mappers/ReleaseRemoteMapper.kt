package jp.co.yumemi.android.code_check.remote.mappers

import jp.co.yumemi.android.code_check.data.models.ReleaseModel
import jp.co.yumemi.android.code_check.remote.models.ReleaseApiModel

/**
 * Release remote mapper
 *
 * Maps release api models to data models
 */
object ReleaseRemoteMapper {
    fun toModel(apiModel: ReleaseApiModel) = ReleaseModel(
        id = apiModel.id,
        name = apiModel.name,
        tag = apiModel.tagName,
        url = apiModel.url,
        isDraft = apiModel.draft,
        description = apiModel.body,
        author = apiModel.author.let(UserRemoteMapper::toModel),
        createdAt = apiModel.createdAt,
        publishedAt = apiModel.publishedAt
    )
}
