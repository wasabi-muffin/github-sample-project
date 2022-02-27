package jp.co.yumemi.android.code_check.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import jp.co.yumemi.android.code_check.ui.R
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

data class DateString(val value: String) {
    @Composable
    fun toDurationUntilToday(): String {
        val date = Instant.parse(value)
        val now = Clock.System.now()
        val duration = (now - date).absoluteValue
        return when {
            duration.inWholeMinutes < nowMinutes -> stringResource(id = R.string.common_time_now)
            duration.inWholeMinutes < minutesInHour -> "${duration.inWholeMinutes}${stringResource(id = R.string.common_time_minutes)}"
            duration.inWholeHours < hoursInDay -> "${duration.inWholeHours}${stringResource(id = R.string.common_time_hours)}"
            duration.inWholeDays < daysInWeek -> "${duration.inWholeDays}${stringResource(id = R.string.common_time_days)}"
            duration.inWholeDays < daysInMonth -> "${duration.inWholeDays / daysInWeek}${stringResource(id = R.string.common_time_weeks)}"
            duration.inWholeDays < daysInYear -> "${duration.inWholeDays / daysInMonth}${stringResource(id = R.string.common_time_months)}"
            else -> "${duration.inWholeDays / daysInYear}${stringResource(id = R.string.common_time_minutes)}"
        }
    }

    companion object {
        private const val nowMinutes = 2
        private const val minutesInHour = 60
        private const val hoursInDay = 24
        private const val daysInWeek = 7
        private const val daysInMonth = 30
        private const val daysInYear = 365
    }
}
