package jp.co.yumemi.android.code_check.data.mappers

import io.kotest.matchers.shouldBe
import org.junit.Test

class SearchMapperTest {
    @Test
    fun `test for mapping github repo model to entity`() {
        val entity = SearchMapper.repoModelToEntity(
            RepoMinusSearchMinusResultMinusItemApiModel(
                id = 0,
                nodeId = "",
                name = "",
                fullName = "",
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
        )
        entity.name shouldBe ""
        entity.ownerIconUrl shouldBe null
        entity.language shouldBe null
        entity.stargazersCount shouldBe 0
        entity.watchersCount shouldBe 0
        entity.forksCount shouldBe 0
        entity.openIssuesCount shouldBe 0
    }
}
