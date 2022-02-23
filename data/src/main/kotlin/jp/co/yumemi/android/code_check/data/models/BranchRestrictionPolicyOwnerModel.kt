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


import kotlinx.serialization.*

/**
 * 
 * @param login 
 * @param id 
 * @param nodeId 
 * @param url 
 * @param reposUrl 
 * @param eventsUrl 
 * @param hooksUrl 
 * @param issuesUrl 
 * @param membersUrl 
 * @param publicMembersUrl 
 * @param avatarUrl 
 * @param description 
 * @param gravatarId 
 * @param htmlUrl 
 * @param followersUrl 
 * @param followingUrl 
 * @param gistsUrl 
 * @param starredUrl 
 * @param subscriptionsUrl 
 * @param organizationsUrl 
 * @param receivedEventsUrl 
 * @param type 
 * @param siteAdmin 
 */
@Serializable
data class BranchRestrictionPolicyOwnerModel(
    @SerialName(value = "login")
    val login: kotlin.String? = null,
    @SerialName(value = "id")
    val id: kotlin.Int? = null,
    @SerialName(value = "node_id")
    val nodeId: kotlin.String? = null,
    @SerialName(value = "url")
    val url: kotlin.String? = null,
    @SerialName(value = "repos_url")
    val reposUrl: kotlin.String? = null,
    @SerialName(value = "events_url")
    val eventsUrl: kotlin.String? = null,
    @SerialName(value = "hooks_url")
    val hooksUrl: kotlin.String? = null,
    @SerialName(value = "issues_url")
    val issuesUrl: kotlin.String? = null,
    @SerialName(value = "members_url")
    val membersUrl: kotlin.String? = null,
    @SerialName(value = "public_members_url")
    val publicMembersUrl: kotlin.String? = null,
    @SerialName(value = "avatar_url")
    val avatarUrl: kotlin.String? = null,
    @SerialName(value = "description")
    val description: kotlin.String? = null,
    @SerialName(value = "gravatar_id")
    val gravatarId: kotlin.String? = null,
    @SerialName(value = "html_url")
    val htmlUrl: kotlin.String? = null,
    @SerialName(value = "followers_url")
    val followersUrl: kotlin.String? = null,
    @SerialName(value = "following_url")
    val followingUrl: kotlin.String? = null,
    @SerialName(value = "gists_url")
    val gistsUrl: kotlin.String? = null,
    @SerialName(value = "starred_url")
    val starredUrl: kotlin.String? = null,
    @SerialName(value = "subscriptions_url")
    val subscriptionsUrl: kotlin.String? = null,
    @SerialName(value = "organizations_url")
    val organizationsUrl: kotlin.String? = null,
    @SerialName(value = "received_events_url")
    val receivedEventsUrl: kotlin.String? = null,
    @SerialName(value = "type")
    val type: kotlin.String? = null,
    @SerialName(value = "site_admin")
    val siteAdmin: kotlin.Boolean? = null
) {

}
