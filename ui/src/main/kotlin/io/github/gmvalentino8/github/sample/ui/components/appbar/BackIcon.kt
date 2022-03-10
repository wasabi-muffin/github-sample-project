package io.github.gmvalentino8.github.sample.ui.components.appbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import io.github.gmvalentino8.github.sample.ui.R
import io.github.gmvalentino8.github.sample.ui.primitives.Github

@Composable
fun BackIcon(
    onClickBack: () -> Unit
) = Icon(
    painter = painterResource(id = R.drawable.arrow_left),
    contentDescription = "back",
    tint = Github.Black,
    modifier = Modifier
        .clickable { onClickBack() }
        .size(24.dp)
)
