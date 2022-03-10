package io.github.gmvalentino8.github.sample.ui.components.paging

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.gmvalentino8.github.sample.presentation.core.contract.ViewState
import io.github.gmvalentino8.github.sample.ui.core.render
import io.github.gmvalentino8.github.sample.ui.primitives.Blue
import io.github.gmvalentino8.github.sample.ui.primitives.Github

@Composable
inline fun <T, reified Loading : ViewState, reified Error : ViewState> PagingColumn(
    items: List<T>,
    viewState: ViewState,
    noinline onClickRetry: () -> Unit,
    modifier: Modifier = Modifier,
    footerBackground: Color = Github.White,
    state: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    reverseLayout: Boolean = false,
    verticalArrangement: Arrangement.Vertical = if (!reverseLayout) Arrangement.Top else Arrangement.Bottom,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    flingBehavior: FlingBehavior = ScrollableDefaults.flingBehavior(),
    userScrollEnabled: Boolean = true,
    crossinline content: @Composable LazyItemScope.(Int, T) -> Unit
) = LazyColumn(
    modifier = modifier, state = state,
    contentPadding = contentPadding,
    reverseLayout = reverseLayout,
    verticalArrangement = verticalArrangement,
    horizontalAlignment = horizontalAlignment,
    flingBehavior = flingBehavior,
    userScrollEnabled = userScrollEnabled,
) {
    itemsIndexed(items) { index, item ->
        content(index, item)
        if (index == items.lastIndex) {
            Box(
                modifier = Modifier
                    .background(footerBackground)
                    .fillMaxWidth()
                    .height(64.dp)
            ) {
                viewState.render<Loading> {
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopCenter)
                    )
                    CircularProgressIndicator(
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
                viewState.render<Error> {
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopCenter)
                    )
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .align(Alignment.Center)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "An error has occurred",
                            style = MaterialTheme.typography.h4,
                            color = Github.Black,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = "Retry",
                            style = MaterialTheme.typography.h4,
                            fontWeight = FontWeight.Bold,
                            color = Blue.v500,
                            modifier = Modifier.clickable { onClickRetry() }
                        )
                    }
                }
            }
        }
    }
}
