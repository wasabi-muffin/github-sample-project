package jp.co.yumemi.android.code_check.local.mappers

import jp.co.yumemi.android.code_check.data.models.RecentSearchModel
import jp.co.yumemi.android.code_check.local.models.RecentSearchDbModel

object RecentSearchMapper {
    fun dataToDb(dataModel: RecentSearchModel) = RecentSearchDbModel(
        searchText = dataModel.searchText,
        timestamp = dataModel.timestamp
    )

    fun dbToData(dbModel: RecentSearchDbModel) = RecentSearchModel(
        searchText = dbModel.searchText,
        timestamp = dbModel.timestamp
    )
}
