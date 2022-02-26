package jp.co.yumemi.android.code_check.ui.core

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.collect

// ref: https://manavtamboli.medium.com/infinite-list-paged-list-in-jetpack-compose-b10fc7e74768
@Composable
fun LazyListState.onScrolledToBottom(
    buffer: Int = 0,
    onNotify: (Boolean) -> Unit
) {
    require(buffer >= 0) { "buffer cannot be negative, but was $buffer" }
    val shouldLoadMore = remember {
        derivedStateOf {
            val lastVisibleItem = layoutInfo.visibleItemsInfo.lastOrNull() ?: return@derivedStateOf true
            lastVisibleItem.index >= layoutInfo.totalItemsCount - 1 - buffer
        }
    }

    LaunchedEffect(shouldLoadMore) {
        snapshotFlow { shouldLoadMore.value }
            .distinctUntilChanged()
            .collect { onNotify(it) }
    }
}

@Composable
fun LazyListState.onScrolledToBottom(
    buffer: Int = 0,
    onTrue: () -> Unit
) = onScrolledToBottom(buffer = buffer) { value -> if (value) onTrue() }

@Composable
fun LazyListState.onScrolledToTop(
    buffer: Int = 0,
    onNotify: (Boolean) -> Unit
) {
    require(buffer >= 0) { "buffer cannot be negative, but was $buffer" }
    val shouldLoadMore = remember {
        derivedStateOf {
            val lastVisibleItem = layoutInfo.visibleItemsInfo.lastOrNull() ?: return@derivedStateOf true
            lastVisibleItem.index <= buffer
        }
    }

    LaunchedEffect(shouldLoadMore) {
        snapshotFlow { shouldLoadMore.value }
            .distinctUntilChanged()
            .collect { onNotify(it) }
    }
}

@Composable
fun LazyListState.onScrolledToTop(
    buffer: Int = 0,
    onTrue: () -> Unit
) = onScrolledToTop(buffer = buffer) { value -> if (value) onTrue() }
