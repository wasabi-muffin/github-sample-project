package jp.co.yumemi.android.code_check.data.mappers

import jp.co.yumemi.android.code_check.data.models.OrganizationModel
import jp.co.yumemi.android.code_check.domain.entities.Organization

object OrganizationDataMapper {
    fun toEntity(model: OrganizationModel) = Organization(
        id = model.id,
        name = model.name,
        username = model.username,
        iconUrl = model.iconUrl,
        description = model.description
    )
}
