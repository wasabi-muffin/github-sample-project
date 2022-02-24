package jp.co.yumemi.android.code_check.data.mappers

import jp.co.yumemi.android.code_check.data.models.RecentSearchModel
import jp.co.yumemi.android.code_check.domain.entities.RecentSearch

object RecentSearchMapper {
    fun modelToEntity(model: RecentSearchModel) = RecentSearch(
        searchText = model.searchText,
        timestamp = model.timestamp
    )
}
