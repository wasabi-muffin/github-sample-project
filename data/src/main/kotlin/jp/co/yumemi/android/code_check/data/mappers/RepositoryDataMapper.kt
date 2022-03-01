package jp.co.yumemi.android.code_check.data.mappers

import jp.co.yumemi.android.code_check.data.models.RepositoryModel
import jp.co.yumemi.android.code_check.domain.entities.Repository

/**
 * Repository data mapper
 *
 * Maps data models to domain entities
 */
internal object RepositoryDataMapper {
    fun toEntity(model: RepositoryModel): Repository = Repository(
        id = model.id,
        name = model.name,
        description = model.description,
        owner = model.owner?.let(UserDataMapper::toEntity),
        homepage = model.homepage,
        language = model.language,
        stargazersCount = model.stargazersCount,
        watchersCount = model.watchersCount,
        forksCount = model.forksCount,
        openIssuesCount = model.openIssuesCount,
        license = model.license,
    )
}
