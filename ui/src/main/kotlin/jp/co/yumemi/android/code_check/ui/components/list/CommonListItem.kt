package jp.co.yumemi.android.code_check.ui.components.list

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.co.yumemi.android.code_check.ui.R
import jp.co.yumemi.android.code_check.ui.primitives.Github
import jp.co.yumemi.android.code_check.ui.primitives.GithubTheme

@Composable
fun CommonListItem(
    @DrawableRes icon: Int,
    title: String,
    modifier: Modifier = Modifier,
    iconColor: Color = Github.Black,
    iconBackground: Color = Github.White,
    note: String? = null,
) = Row(
    modifier = modifier.padding(24.dp),
    verticalAlignment = Alignment.CenterVertically
) {
    Box(
        modifier = Modifier
            .size(36.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(iconBackground)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "icon",
            tint = iconColor,
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.Center)
        )
    }
    Text(
        text = title,
        style = MaterialTheme.typography.h4,
        fontWeight = FontWeight.Normal,
        modifier = Modifier.weight(1F)
    )
    if (note != null) {
        Text(
            text = note,
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Preview
@Composable
fun Preview_CommonListItem() {
    GithubTheme {
        CommonListItem(icon = R.drawable.star, title = "stars", modifier = Modifier.background(Color.White))
    }
}
