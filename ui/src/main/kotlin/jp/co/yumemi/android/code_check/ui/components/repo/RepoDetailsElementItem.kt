package jp.co.yumemi.android.code_check.ui.components.repo

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.domain.entities.RepositoryDetails
import jp.co.yumemi.android.code_check.ui.components.list.CommonListItem
import jp.co.yumemi.android.code_check.ui.primitives.Github
import jp.co.yumemi.android.code_check.ui.primitives.GithubTheme
import jp.co.yumemi.android.code_check.ui.utils.icon
import jp.co.yumemi.android.code_check.ui.utils.iconBackground
import jp.co.yumemi.android.code_check.ui.utils.label
import jp.co.yumemi.android.code_check.ui.utils.note

@Composable
fun RepoDetailsElementItem(
    repoDetails: RepositoryDetails,
    element: RepositoryDetails.Element,
    modifier: Modifier = Modifier
) = CommonListItem(
    icon = element.icon(),
    title = stringResource(id = element.label()),
    iconColor = Github.White,
    iconBackground = element.iconBackground,
    note = element.note(repoDetails),
    modifier = modifier
)

@Preview
@Composable
fun Preview_RepoDetailsElementItem() {
    GithubTheme {
        RepoDetailsElementItem(
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
                contributors = emptyList()
            ),
            element = RepositoryDetails.Element.Issues,
            modifier = Modifier.background(Color.White)
        )
    }
}
