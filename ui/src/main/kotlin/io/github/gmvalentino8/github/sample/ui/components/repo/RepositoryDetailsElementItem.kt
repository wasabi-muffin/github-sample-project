package io.github.gmvalentino8.github.sample.ui.components.repo

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.gmvalentino8.github.sample.domain.entities.Repository
import io.github.gmvalentino8.github.sample.domain.entities.RepositoryDetails
import io.github.gmvalentino8.github.sample.ui.components.list.CommonListItem
import io.github.gmvalentino8.github.sample.ui.primitives.Github
import io.github.gmvalentino8.github.sample.ui.primitives.GithubTheme
import io.github.gmvalentino8.github.sample.ui.utils.icon
import io.github.gmvalentino8.github.sample.ui.utils.iconBackground
import io.github.gmvalentino8.github.sample.ui.utils.label
import io.github.gmvalentino8.github.sample.ui.utils.note

@Composable
fun RepositoryDetailsElementItem(
    repoDetails: RepositoryDetails,
    element: RepositoryDetails.Element,
    modifier: Modifier = Modifier
) {
    val note = element.note(repoDetails)
    if (note != null) {
        CommonListItem(
            icon = element.icon(),
            title = stringResource(id = element.label()),
            iconColor = Github.White,
            iconBackground = element.iconBackground,
            note = note,
            modifier = modifier
        )
    }
}

@Preview
@Composable
fun Preview_RepositoryDetailsElementItem() {
    GithubTheme {
        RepositoryDetailsElementItem(
            repoDetails = RepositoryDetails(
                repository = Repository(
                    id = 0,
                    name = "",
                    description = null,
                    owner = null,
                    homepage = null,
                    language = null,
                    stargazersCount = 0,
                    watchersCount = 0,
                    forksCount = 0,
                    openIssuesCount = 2000,
                    license = null
                ),
                releases = emptyList(),
                contributors = emptyList(),
                pullRequests = emptyList()
            ),
            element = RepositoryDetails.Element.Issues,
            modifier = Modifier.background(Color.White)
        )
    }
}
