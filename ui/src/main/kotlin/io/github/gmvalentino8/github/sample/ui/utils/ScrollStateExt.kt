package io.github.gmvalentino8.github.sample.ui.utils

import androidx.compose.foundation.ScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ScrollState.isAtTop(): Boolean {
    val isAtTop = remember {
        derivedStateOf {
            this.value == 0
        }
    }
    return isAtTop.value
}

@Composable
fun ScrollState.elevation(): Dp {
    val elevation = remember {
        derivedStateOf {
            if (value == 0) 0.dp else 4.dp
        }
    }
    return elevation.value
}
