/**
 * GitHub v3 REST API
 *
 * GitHub's v3 REST API.
 *
 * The version of the OpenAPI document: 1.1.4
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package jp.co.yumemi.android.code_check.data.models

import jp.co.yumemi.android.code_check.data.models.FullRepositoryPermissionsModel
import jp.co.yumemi.android.code_check.data.models.PullRequestHeadRepoLicenseModel
import jp.co.yumemi.android.code_check.data.models.PullRequestHeadRepoOwnerModel

import kotlinx.serialization.*

/**
 * 
 * @param archiveUrl 
 * @param assigneesUrl 
 * @param blobsUrl 
 * @param branchesUrl 
 * @param collaboratorsUrl 
 * @param commentsUrl 
 * @param commitsUrl 
 * @param compareUrl 
 * @param contentsUrl 
 * @param contributorsUrl 
 * @param deploymentsUrl 
 * @param description 
 * @param downloadsUrl 
 * @param eventsUrl 
 * @param fork 
 * @param forksUrl 
 * @param fullName 
 * @param gitCommitsUrl 
 * @param gitRefsUrl 
 * @param gitTagsUrl 
 * @param hooksUrl 
 * @param htmlUrl 
 * @param id 
 * @param nodeId 
 * @param issueCommentUrl 
 * @param issueEventsUrl 
 * @param issuesUrl 
 * @param keysUrl 
 * @param labelsUrl 
 * @param languagesUrl 
 * @param mergesUrl 
 * @param milestonesUrl 
 * @param name 
 * @param notificationsUrl 
 * @param owner 
 * @param `private` 
 * @param pullsUrl 
 * @param releasesUrl 
 * @param stargazersUrl 
 * @param statusesUrl 
 * @param subscribersUrl 
 * @param subscriptionUrl 
 * @param tagsUrl 
 * @param teamsUrl 
 * @param treesUrl 
 * @param url 
 * @param cloneUrl 
 * @param defaultBranch 
 * @param forks 
 * @param forksCount 
 * @param gitUrl 
 * @param hasDownloads 
 * @param hasIssues 
 * @param hasProjects 
 * @param hasWiki 
 * @param hasPages 
 * @param homepage 
 * @param language 
 * @param archived 
 * @param disabled 
 * @param mirrorUrl 
 * @param openIssues 
 * @param openIssuesCount 
 * @param license 
 * @param pushedAt 
 * @param propertySize 
 * @param sshUrl 
 * @param stargazersCount 
 * @param svnUrl 
 * @param watchers 
 * @param watchersCount 
 * @param createdAt 
 * @param updatedAt 
 * @param masterBranch 
 * @param visibility The repository visibility: public, private, or internal.
 * @param permissions 
 * @param tempCloneToken 
 * @param allowMergeCommit 
 * @param allowSquashMerge 
 * @param allowRebaseMerge 
 * @param topics 
 * @param allowForking 
 * @param isTemplate 
 */
@Serializable
data class PullRequestHeadRepoModel(
    @SerialName(value = "archive_url")
    val archiveUrl: kotlin.String,
    @SerialName(value = "assignees_url")
    val assigneesUrl: kotlin.String,
    @SerialName(value = "blobs_url")
    val blobsUrl: kotlin.String,
    @SerialName(value = "branches_url")
    val branchesUrl: kotlin.String,
    @SerialName(value = "collaborators_url")
    val collaboratorsUrl: kotlin.String,
    @SerialName(value = "comments_url")
    val commentsUrl: kotlin.String,
    @SerialName(value = "commits_url")
    val commitsUrl: kotlin.String,
    @SerialName(value = "compare_url")
    val compareUrl: kotlin.String,
    @SerialName(value = "contents_url")
    val contentsUrl: kotlin.String,
    @SerialName(value = "contributors_url")
    val contributorsUrl: kotlin.String,
    @SerialName(value = "deployments_url")
    val deploymentsUrl: kotlin.String,
    @SerialName(value = "description")
    val description: kotlin.String?,
    @SerialName(value = "downloads_url")
    val downloadsUrl: kotlin.String,
    @SerialName(value = "events_url")
    val eventsUrl: kotlin.String,
    @SerialName(value = "fork")
    val fork: kotlin.Boolean,
    @SerialName(value = "forks_url")
    val forksUrl: kotlin.String,
    @SerialName(value = "full_name")
    val fullName: kotlin.String,
    @SerialName(value = "git_commits_url")
    val gitCommitsUrl: kotlin.String,
    @SerialName(value = "git_refs_url")
    val gitRefsUrl: kotlin.String,
    @SerialName(value = "git_tags_url")
    val gitTagsUrl: kotlin.String,
    @SerialName(value = "hooks_url")
    val hooksUrl: kotlin.String,
    @SerialName(value = "html_url")
    val htmlUrl: kotlin.String,
    @SerialName(value = "id")
    val id: kotlin.Int,
    @SerialName(value = "node_id")
    val nodeId: kotlin.String,
    @SerialName(value = "issue_comment_url")
    val issueCommentUrl: kotlin.String,
    @SerialName(value = "issue_events_url")
    val issueEventsUrl: kotlin.String,
    @SerialName(value = "issues_url")
    val issuesUrl: kotlin.String,
    @SerialName(value = "keys_url")
    val keysUrl: kotlin.String,
    @SerialName(value = "labels_url")
    val labelsUrl: kotlin.String,
    @SerialName(value = "languages_url")
    val languagesUrl: kotlin.String,
    @SerialName(value = "merges_url")
    val mergesUrl: kotlin.String,
    @SerialName(value = "milestones_url")
    val milestonesUrl: kotlin.String,
    @SerialName(value = "name")
    val name: kotlin.String,
    @SerialName(value = "notifications_url")
    val notificationsUrl: kotlin.String,
    @SerialName(value = "owner")
    val owner: PullRequestHeadRepoOwnerModel,
    @SerialName(value = "private")
    val `private`: kotlin.Boolean,
    @SerialName(value = "pulls_url")
    val pullsUrl: kotlin.String,
    @SerialName(value = "releases_url")
    val releasesUrl: kotlin.String,
    @SerialName(value = "stargazers_url")
    val stargazersUrl: kotlin.String,
    @SerialName(value = "statuses_url")
    val statusesUrl: kotlin.String,
    @SerialName(value = "subscribers_url")
    val subscribersUrl: kotlin.String,
    @SerialName(value = "subscription_url")
    val subscriptionUrl: kotlin.String,
    @SerialName(value = "tags_url")
    val tagsUrl: kotlin.String,
    @SerialName(value = "teams_url")
    val teamsUrl: kotlin.String,
    @SerialName(value = "trees_url")
    val treesUrl: kotlin.String,
    @SerialName(value = "url")
    val url: kotlin.String,
    @SerialName(value = "clone_url")
    val cloneUrl: kotlin.String,
    @SerialName(value = "default_branch")
    val defaultBranch: kotlin.String,
    @SerialName(value = "forks")
    val forks: kotlin.Int,
    @SerialName(value = "forks_count")
    val forksCount: kotlin.Int,
    @SerialName(value = "git_url")
    val gitUrl: kotlin.String,
    @SerialName(value = "has_downloads")
    val hasDownloads: kotlin.Boolean,
    @SerialName(value = "has_issues")
    val hasIssues: kotlin.Boolean,
    @SerialName(value = "has_projects")
    val hasProjects: kotlin.Boolean,
    @SerialName(value = "has_wiki")
    val hasWiki: kotlin.Boolean,
    @SerialName(value = "has_pages")
    val hasPages: kotlin.Boolean,
    @SerialName(value = "homepage")
    val homepage: kotlin.String?,
    @SerialName(value = "language")
    val language: kotlin.String?,
    @SerialName(value = "archived")
    val archived: kotlin.Boolean,
    @SerialName(value = "disabled")
    val disabled: kotlin.Boolean,
    @SerialName(value = "mirror_url")
    val mirrorUrl: kotlin.String?,
    @SerialName(value = "open_issues")
    val openIssues: kotlin.Int,
    @SerialName(value = "open_issues_count")
    val openIssuesCount: kotlin.Int,
    @SerialName(value = "license")
    val license: PullRequestHeadRepoLicenseModel?,
    @SerialName(value = "pushed_at")
    val pushedAt: kotlin.String,
    @SerialName(value = "size")
    val propertySize: kotlin.Int,
    @SerialName(value = "ssh_url")
    val sshUrl: kotlin.String,
    @SerialName(value = "stargazers_count")
    val stargazersCount: kotlin.Int,
    @SerialName(value = "svn_url")
    val svnUrl: kotlin.String,
    @SerialName(value = "watchers")
    val watchers: kotlin.Int,
    @SerialName(value = "watchers_count")
    val watchersCount: kotlin.Int,
    @SerialName(value = "created_at")
    val createdAt: kotlin.String,
    @SerialName(value = "updated_at")
    val updatedAt: kotlin.String,
    @SerialName(value = "master_branch")
    val masterBranch: kotlin.String? = null,
    /* The repository visibility: public, private, or internal. */
    @SerialName(value = "visibility")
    val visibility: kotlin.String? = null,
    @SerialName(value = "permissions")
    val permissions: FullRepositoryPermissionsModel? = null,
    @SerialName(value = "temp_clone_token")
    val tempCloneToken: kotlin.String? = null,
    @SerialName(value = "allow_merge_commit")
    val allowMergeCommit: kotlin.Boolean? = null,
    @SerialName(value = "allow_squash_merge")
    val allowSquashMerge: kotlin.Boolean? = null,
    @SerialName(value = "allow_rebase_merge")
    val allowRebaseMerge: kotlin.Boolean? = null,
    @SerialName(value = "topics")
    val topics: kotlin.collections.List<kotlin.String>? = null,
    @SerialName(value = "allow_forking")
    val allowForking: kotlin.Boolean? = null,
    @SerialName(value = "is_template")
    val isTemplate: kotlin.Boolean? = null
) {

}

