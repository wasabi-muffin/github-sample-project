package io.github.gmvalentino8.github.sample.local.mappers

import io.github.gmvalentino8.github.sample.data.models.RecentSearchModel
import io.github.gmvalentino8.github.sample.local.models.RecentSearchDbModel

/**
 * Recent search local mapper
 *
 * Maps recent search database models to/from data models
 */
internal object RecentSearchLocalMapper {
    fun dataToDb(dataModel: RecentSearchModel) = RecentSearchDbModel(
        searchText = dataModel.searchText,
        timestamp = dataModel.timestamp
    )

    fun dbToData(dbModel: RecentSearchDbModel) = RecentSearchModel(
        searchText = dbModel.searchText,
        timestamp = dbModel.timestamp
    )
}
