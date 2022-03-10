package io.github.gmvalentino8.github.sample.data.mappers

import io.github.gmvalentino8.github.sample.data.models.RecentSearchModel
import io.github.gmvalentino8.github.sample.domain.entities.RecentSearch

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
