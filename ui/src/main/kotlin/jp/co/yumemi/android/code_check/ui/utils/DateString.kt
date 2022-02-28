package jp.co.yumemi.android.code_check.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import jp.co.yumemi.android.code_check.ui.R
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

data class DateString(val value: String) {
    @Composable
    fun toDurationUntilToday(): String {
        val result = remember {
            derivedStateOf {
                val date = Instant.parse(value)
                val now = Clock.System.now()
                (now - date).absoluteValue
            }
        }
        return when {
            result.value.inWholeMinutes < nowMinutes -> stringResource(id = R.string.common_time_now)
            result.value.inWholeMinutes < minutesInHour -> "${result.value.inWholeMinutes}${stringResource(id = R.string.common_time_minutes)}"
            result.value.inWholeHours < hoursInDay -> "${result.value.inWholeHours}${stringResource(id = R.string.common_time_hours)}"
            result.value.inWholeDays < daysInWeek -> "${result.value.inWholeDays}${stringResource(id = R.string.common_time_days)}"
            result.value.inWholeDays < daysInMonth -> "${result.value.inWholeDays / daysInWeek}${stringResource(id = R.string.common_time_weeks)}"
            result.value.inWholeDays < daysInYear -> "${result.value.inWholeDays / daysInMonth}${stringResource(id = R.string.common_time_months)}"
            else -> "${result.value.inWholeDays / daysInYear}${stringResource(id = R.string.common_time_minutes)}"
        }
    }

    companion object {
        private const val nowMinutes = 2L
        private const val minutesInHour = 60
        private const val hoursInDay = 24
        private const val daysInWeek = 7
        private const val daysInMonth = 30
        private const val daysInYear = 365
    }
}
