package jp.co.yumemi.android.code_check.data.mappers

import jp.co.yumemi.android.code_check.data.models.RecentSearchModel
import jp.co.yumemi.android.code_check.domain.entities.RecentSearch

/**
 * Recent search data mapper
 *
 * Maps recent search data models to domain entities
 */
internal object RecentSearchDataMapper {
    fun toEntity(model: RecentSearchModel) = RecentSearch(
        searchText = model.searchText,
        timestamp = model.timestamp
    )
}
