package io.github.gmvalentino8.github.sample.ui.components.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import io.github.gmvalentino8.github.sample.domain.entities.Organization
import io.github.gmvalentino8.github.sample.domain.entities.User
import io.github.gmvalentino8.github.sample.ui.primitives.Github
import io.github.gmvalentino8.github.sample.ui.primitives.GithubTheme
import io.github.gmvalentino8.github.sample.ui.primitives.Gray

@Composable
fun SearchUserResultItem(
    username: String?,
    name: String?,
    iconUrl: String?,
    description: String?,
    modifier: Modifier = Modifier
) = Row(
    horizontalArrangement = Arrangement.spacedBy(16.dp),
    verticalAlignment = Alignment.Top,
    modifier = modifier
        .fillMaxWidth()
        .padding(24.dp)
) {
    Box(modifier = Modifier.size(32.dp)) {
        if (iconUrl != null) {
            Image(
                painter = rememberImagePainter(
                    data = iconUrl,
                    builder = {
                        transformations(CircleCropTransformation())
                    }
                ),
                contentDescription = null,
            )
        }
    }
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.weight(1f)
    ) {
        if (username != null) {
            Text(
                text = username,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold,
                color = Github.Black,
                modifier = Modifier.fillMaxWidth(),
            )
        }
        if (name != null) {
            Text(
                text = name,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Normal,
                color = Gray.v700,
                modifier = Modifier.fillMaxWidth(),
            )
        }
        if (description != null) {
            Text(
                text = description,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Medium,
                color = Github.Black,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Composable
fun SearchUserResultItem(
    user: User,
    modifier: Modifier = Modifier
) = SearchUserResultItem(
    username = user.username,
    name = user.name,
    iconUrl = user.iconUrl,
    description = user.description,
    modifier = modifier
)

@Composable
fun SearchOrganizationResultItem(
    organization: Organization,
    modifier: Modifier = Modifier
) = SearchUserResultItem(
    username = organization.username,
    name = organization.name,
    iconUrl = organization.iconUrl,
    description = organization.description,
    modifier = modifier
)

@Preview
@Composable
fun Preview_SearchUserResultItem() {
    GithubTheme {
        SearchUserResultItem(
            user = User(id = 0, name = "name", username = "username", iconUrl = null, description = "description"),
            modifier = Modifier
                .background(Color.White)
        )
    }
}
