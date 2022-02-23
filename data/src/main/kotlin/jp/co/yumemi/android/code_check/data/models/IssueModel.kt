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

import jp.co.yumemi.android.code_check.data.models.AuthorAssociationModel
import jp.co.yumemi.android.code_check.data.models.IssueLabelsModel
import jp.co.yumemi.android.code_check.data.models.IssuePullRequestModel
import jp.co.yumemi.android.code_check.data.models.NullableMinusIntegrationModel
import jp.co.yumemi.android.code_check.data.models.NullableMinusMilestoneModel
import jp.co.yumemi.android.code_check.data.models.NullableMinusSimpleMinusUserModel
import jp.co.yumemi.android.code_check.data.models.ReactionMinusRollupModel
import jp.co.yumemi.android.code_check.data.models.RepositoryModel
import jp.co.yumemi.android.code_check.data.models.SimpleMinusUserModel

import kotlinx.serialization.*

/**
 * Issues are a great way to keep track of tasks, enhancements, and bugs for your projects.
 * @param id 
 * @param nodeId 
 * @param url URL for the issue
 * @param repositoryUrl 
 * @param labelsUrl 
 * @param commentsUrl 
 * @param eventsUrl 
 * @param htmlUrl 
 * @param number Number uniquely identifying the issue within its repository
 * @param state State of the issue; either 'open' or 'closed'
 * @param title Title of the issue
 * @param user 
 * @param labels Labels to associate with this issue; pass one or more label names to replace the set of labels on this issue; send an empty array to clear all labels from the issue; note that the labels are silently dropped for users without push access to the repository
 * @param assignee 
 * @param milestone 
 * @param locked 
 * @param comments 
 * @param closedAt 
 * @param createdAt 
 * @param updatedAt 
 * @param authorAssociation 
 * @param body Contents of the issue
 * @param assignees 
 * @param activeLockReason 
 * @param pullRequest 
 * @param draft 
 * @param closedBy 
 * @param bodyHtml 
 * @param bodyText 
 * @param timelineUrl 
 * @param repository 
 * @param performedViaGithubApp 
 * @param reactions 
 */
@Serializable
data class IssueModel(
    @SerialName(value = "id")
    val id: kotlin.Int,
    @SerialName(value = "node_id")
    val nodeId: kotlin.String,
    /* URL for the issue */
    @SerialName(value = "url")
    val url: kotlin.String,
    @SerialName(value = "repository_url")
    val repositoryUrl: kotlin.String,
    @SerialName(value = "labels_url")
    val labelsUrl: kotlin.String,
    @SerialName(value = "comments_url")
    val commentsUrl: kotlin.String,
    @SerialName(value = "events_url")
    val eventsUrl: kotlin.String,
    @SerialName(value = "html_url")
    val htmlUrl: kotlin.String,
    /* Number uniquely identifying the issue within its repository */
    @SerialName(value = "number")
    val number: kotlin.Int,
    /* State of the issue; either 'open' or 'closed' */
    @SerialName(value = "state")
    val state: kotlin.String,
    /* Title of the issue */
    @SerialName(value = "title")
    val title: kotlin.String,
    @SerialName(value = "user")
    val user: NullableMinusSimpleMinusUserModel?,
    /* Labels to associate with this issue; pass one or more label names to replace the set of labels on this issue; send an empty array to clear all labels from the issue; note that the labels are silently dropped for users without push access to the repository */
    @SerialName(value = "labels")
    val labels: kotlin.collections.List<IssueLabelsModel>,
    @SerialName(value = "assignee")
    val assignee: NullableMinusSimpleMinusUserModel?,
    @SerialName(value = "milestone")
    val milestone: NullableMinusMilestoneModel?,
    @SerialName(value = "locked")
    val locked: kotlin.Boolean,
    @SerialName(value = "comments")
    val comments: kotlin.Int,
    @SerialName(value = "closed_at")
    val closedAt: kotlin.String?,
    @SerialName(value = "created_at")
    val createdAt: kotlin.String,
    @SerialName(value = "updated_at")
    val updatedAt: kotlin.String,
    @Contextual @SerialName(value = "author_association")
    val authorAssociation: AuthorAssociationModel,
    /* Contents of the issue */
    @SerialName(value = "body")
    val body: kotlin.String? = null,
    @SerialName(value = "assignees")
    val assignees: kotlin.collections.List<SimpleMinusUserModel>? = null,
    @SerialName(value = "active_lock_reason")
    val activeLockReason: kotlin.String? = null,
    @SerialName(value = "pull_request")
    val pullRequest: IssuePullRequestModel? = null,
    @SerialName(value = "draft")
    val draft: kotlin.Boolean? = null,
    @SerialName(value = "closed_by")
    val closedBy: NullableMinusSimpleMinusUserModel? = null,
    @SerialName(value = "body_html")
    val bodyHtml: kotlin.String? = null,
    @SerialName(value = "body_text")
    val bodyText: kotlin.String? = null,
    @SerialName(value = "timeline_url")
    val timelineUrl: kotlin.String? = null,
    @SerialName(value = "repository")
    val repository: RepositoryModel? = null,
    @SerialName(value = "performed_via_github_app")
    val performedViaGithubApp: NullableMinusIntegrationModel? = null,
    @SerialName(value = "reactions")
    val reactions: ReactionMinusRollupModel? = null
) {

}

