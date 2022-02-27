package jp.co.yumemi.android.code_check.remote.providers

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import jp.co.yumemi.android.code_check.remote.apis.SearchApi
import jp.co.yumemi.android.code_check.remote.models.InlineResponse20028ApiModel
import jp.co.yumemi.android.code_check.remote.models.RepoMinusSearchMinusResultMinusItemApiModel
import jp.co.yumemi.android.code_check.test.CoroutineTestRule
import jp.co.yumemi.android.code_check.test.runBlockingTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchRemoteDataProviderTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()
    private val searchApi = mockk<SearchApi>()
    private val searchRemoteDataSource = SearchRemoteDataProvider(searchApi)
    private val testException = Exception("test")

    @Test
    fun `test when search is successful`() {
        coEvery {
            searchApi.searchRepos(any(), any(), any(), any(), any(), any())
        } returns InlineResponse20028ApiModel(
            totalCount = 5,
            incompleteResults = false,
            items = List(5) { index ->
                RepoMinusSearchMinusResultMinusItemApiModel(
                    id = index,
                    nodeId = "",
                    name = "",
                    fullName = "name$index",
                    owner = null,
                    private = false,
                    htmlUrl = "",
                    description = null,
                    fork = false,
                    url = "",
                    createdAt = "",
                    updatedAt = "",
                    pushedAt = "",
                    homepage = null,
                    propertySize = 0,
                    stargazersCount = 0,
                    watchersCount = 0,
                    language = null,
                    forksCount = 0,
                    openIssuesCount = 0,
                    defaultBranch = "",
                    score = 0.0,
                    forksUrl = "",
                    keysUrl = "",
                    collaboratorsUrl = "",
                    teamsUrl = "",
                    hooksUrl = "",
                    issueEventsUrl = "",
                    eventsUrl = "",
                    assigneesUrl = "",
                    branchesUrl = "",
                    tagsUrl = "",
                    blobsUrl = "",
                    gitTagsUrl = "",
                    gitRefsUrl = "",
                    treesUrl = "",
                    statusesUrl = "",
                    languagesUrl = "",
                    stargazersUrl = "",
                    contributorsUrl = "",
                    subscribersUrl = "",
                    subscriptionUrl = "",
                    commitsUrl = "",
                    gitCommitsUrl = "",
                    commentsUrl = "",
                    issueCommentUrl = "",
                    contentsUrl = "",
                    compareUrl = "",
                    mergesUrl = "",
                    archiveUrl = "",
                    downloadsUrl = "",
                    issuesUrl = "",
                    pullsUrl = "",
                    milestonesUrl = "",
                    notificationsUrl = "",
                    labelsUrl = "",
                    releasesUrl = "",
                    deploymentsUrl = "",
                    gitUrl = "",
                    sshUrl = "",
                    cloneUrl = "",
                    svnUrl = "",
                    forks = 0,
                    openIssues = 0,
                    watchers = 0,
                    mirrorUrl = null,
                    hasIssues = false,
                    hasProjects = false,
                    hasPages = false,
                    hasWiki = false,
                    hasDownloads = false,
                    archived = false,
                    disabled = false,
                    license = null,
                    masterBranch = null,
                    topics = listOf(),
                    visibility = null,
                    permissions = null,
                    tempCloneToken = null,
                    allowMergeCommit = null,
                    allowSquashMerge = null,
                    allowRebaseMerge = null,
                    allowAutoMerge = null,
                    deleteBranchOnMerge = null,
                    allowForking = null,
                    isTemplate = null
                )
            }
        )

        coroutineTestRule.runBlockingTest {
            val result = searchRemoteDataSource.searchRepositories("", "", 0)
            result.totalCount shouldBe 5
            result.repos.size shouldBe 5
            result.repos.forEachIndexed { index, repo ->
                repo.name shouldBe "name$index"
            }
            coVerify { searchApi.searchRepos(accessToken = "", q = "", page = 0, perPage = any()) }
        }
    }

    @Test
    fun `test when api throws an error`() {
        coEvery {
            searchApi.searchRepos(any(), any(), any(), any(), any(), any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = runCatching {
                searchRemoteDataSource.searchRepositories("", "", 0)
            }.exceptionOrNull()
            result.shouldBeTypeOf<Exception>()
            result shouldBe testException
            coVerify { searchApi.searchRepos(accessToken = "", q = "", page = 0, perPage = any()) }
        }
    }
}
