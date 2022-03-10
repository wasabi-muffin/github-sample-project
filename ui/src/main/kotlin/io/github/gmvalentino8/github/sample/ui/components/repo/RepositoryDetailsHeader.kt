package io.github.gmvalentino8.github.sample.ui.components.repo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import io.github.gmvalentino8.github.sample.domain.entities.Repository
import io.github.gmvalentino8.github.sample.domain.entities.User
import io.github.gmvalentino8.github.sample.ui.R
import io.github.gmvalentino8.github.sample.ui.primitives.Github
import io.github.gmvalentino8.github.sample.ui.primitives.GithubTheme
import io.github.gmvalentino8.github.sample.ui.primitives.Gray
import io.github.gmvalentino8.github.sample.ui.utils.toShortedString

@Composable
fun RepositoryDetailsHeader(
    ownerIconUrl: String?,
    ownerName: String?,
    repoName: String,
    repoDescription: String?,
    homepage: String?,
    stargazersCount: Int,
    forksCount: Int,
    modifier: Modifier = Modifier
) = Column(
    verticalArrangement = Arrangement.spacedBy(8.dp),
    modifier = modifier
        .fillMaxWidth()
        .padding(16.dp)
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        if (ownerIconUrl != null) {
            Image(
                painter = rememberImagePainter(
                    data = ownerIconUrl,
                    builder = {
                        transformations(CircleCropTransformation())
                    }
                ),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
        if (ownerName != null) {
            Text(
                text = ownerName,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Normal,
                color = Gray.v500,
            )
        }
    }
    Text(
        text = repoName,
        style = MaterialTheme.typography.h2,
        fontWeight = FontWeight.Bold,
        color = Github.Black,
        modifier = Modifier.fillMaxWidth(),
    )
    if (repoDescription != null) {
        Text(
            text = repoDescription,
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Normal,
            color = Gray.v700,
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
    if (homepage != null) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.link),
                contentDescription = "star",
                tint = Gray.v600
            )
            Text(
                text = homepage,
                style = MaterialTheme.typography.h3,
                fontWeight = FontWeight.SemiBold,
                color = Github.Black,
            )
        }
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth(),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.star),
            contentDescription = "star",
            tint = Gray.v600
        )
        Text(
            text = stargazersCount.toShortedString(),
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.SemiBold,
            color = Github.Black,
        )
        Text(
            text = stringResource(R.string.common_stars),
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Normal,
            color = Gray.v600,
        )
        Icon(
            painter = painterResource(id = R.drawable.repo_forked),
            contentDescription = "forked",
            tint = Gray.v600,
        )
        Text(
            text = forksCount.toShortedString(),
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.SemiBold,
            color = Github.Black,
        )
        Text(
            text = stringResource(R.string.common_forks),
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Normal,
            color = Gray.v600,
        )
    }
}

@Composable
fun RepositoryDetailsHeader(
    repository: Repository,
    modifier: Modifier = Modifier
) = RepositoryDetailsHeader(
    ownerIconUrl = repository.owner?.iconUrl,
    ownerName = repository.owner?.username,
    repoName = repository.name,
    homepage = repository.homepage,
    repoDescription = repository.description,
    stargazersCount = repository.stargazersCount,
    forksCount = repository.forksCount,
    modifier = modifier,
)

@Preview
@Composable
fun Preview_RepositoryDetailsHeader() {
    GithubTheme {
        RepositoryDetailsHeader(
            repository = Repository(
                id = 1,
                name = "name",
                description = "description",
                owner = User(id = 0, name = "name", username = "", iconUrl = null, description = null),
                homepage = "url",
                language = "Kotlin",
                stargazersCount = 1,
                watchersCount = 1,
                forksCount = 1,
                openIssuesCount = 1,
                license = null
            ),
            modifier = Modifier
                .background(Color.White)
        )
    }
}
