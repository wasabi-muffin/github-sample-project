package jp.co.yumemi.android.code_check.data.mappers

import jp.co.yumemi.android.code_check.data.models.ReleaseModel
import jp.co.yumemi.android.code_check.domain.entities.Release

object ReleaseDataMapper {
    fun toEntity(model: ReleaseModel) = Release(
        id = model.id,
        name = model.name,
        tag = model.tag,
        description = model.description,
        authorUsername = model.author?.username,
        authorIconUrl = model.author?.iconUrl,
        date = model.createdAt
    )
}
