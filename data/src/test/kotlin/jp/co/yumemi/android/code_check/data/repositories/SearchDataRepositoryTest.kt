package jp.co.yumemi.android.code_check.data.repositories

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import jp.co.yumemi.android.code_check.data.models.RepoMinusSearchMinusResultMinusItemModel
import jp.co.yumemi.android.code_check.data.sources.SearchRemoteDataSource
import jp.co.yumemi.android.code_check.domain.core.DomainError
import jp.co.yumemi.android.code_check.domain.core.DomainResult
import jp.co.yumemi.android.code_check.domain.core.ErrorHandler
import jp.co.yumemi.android.code_check.domain.entities.GithubRepo
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository
import jp.co.yumemi.android.code_check.domain.usecases.SearchRepoExecutor
import jp.co.yumemi.android.code_check.domain.usecases.SearchRepoUseCase
import jp.co.yumemi.android.code_check.test.CoroutineTestRule
import jp.co.yumemi.android.code_check.test.runBlockingTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchDataRepositoryTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()
    private val searchRemoteDataSource = mockk<SearchRemoteDataSource>()
    private val searchRepository = SearchDataRepository(searchRemoteDataSource)
    private val testException = Exception("test")

    @Test
    fun `test when search is successful`() {
        coEvery {
            searchRemoteDataSource.searchRepos(any(), any())
        } returns List(5) { index ->
            RepoMinusSearchMinusResultMinusItemModel(
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

        coroutineTestRule.runBlockingTest {
            val result = searchRepository.searchRepos("")
            result.size shouldBe 5
            result.forEachIndexed { index, repo ->
                repo.name shouldBe "name$index"
            }
            coVerify { searchRemoteDataSource.searchRepos(any(), any()) }
        }
    }

    @Test
    fun `test when remote data provider throws an error`() {
        coEvery {
            searchRemoteDataSource.searchRepos(any(), any())
        } throws testException

        coroutineTestRule.runBlockingTest {
            val result = runCatching {
                searchRepository.searchRepos("")
            }.exceptionOrNull()
            result.shouldBeTypeOf<Exception>()
            result shouldBe testException
            coVerify { searchRemoteDataSource.searchRepos(any(), any()) }
        }
    }
}
