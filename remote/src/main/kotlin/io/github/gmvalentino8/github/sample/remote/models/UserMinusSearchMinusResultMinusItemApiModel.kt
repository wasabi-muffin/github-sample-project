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

package io.github.gmvalentino8.github.sample.remote.models


import kotlinx.serialization.*

/**
 * User Search Result Item
 * @param login 
 * @param id 
 * @param nodeId 
 * @param avatarUrl 
 * @param gravatarId 
 * @param url 
 * @param htmlUrl 
 * @param followersUrl 
 * @param subscriptionsUrl 
 * @param organizationsUrl 
 * @param reposUrl 
 * @param receivedEventsUrl 
 * @param type 
 * @param score 
 * @param followingUrl 
 * @param gistsUrl 
 * @param starredUrl 
 * @param eventsUrl 
 * @param siteAdmin 
 * @param publicRepos 
 * @param publicGists 
 * @param followers 
 * @param following 
 * @param createdAt 
 * @param updatedAt 
 * @param name 
 * @param bio 
 * @param email 
 * @param location 
 * @param hireable 
 * @param blog 
 * @param company 
 * @param suspendedAt 
 */
@Serializable
data class UserMinusSearchMinusResultMinusItemApiModel(
    @SerialName(value = "login")
    val login: kotlin.String,
    @SerialName(value = "id")
    val id: kotlin.Int,
    @SerialName(value = "node_id")
    val nodeId: kotlin.String,
    @SerialName(value = "avatar_url")
    val avatarUrl: kotlin.String,
    @SerialName(value = "gravatar_id")
    val gravatarId: kotlin.String?,
    @SerialName(value = "url")
    val url: kotlin.String,
    @SerialName(value = "html_url")
    val htmlUrl: kotlin.String,
    @SerialName(value = "followers_url")
    val followersUrl: kotlin.String,
    @SerialName(value = "subscriptions_url")
    val subscriptionsUrl: kotlin.String,
    @SerialName(value = "organizations_url")
    val organizationsUrl: kotlin.String,
    @SerialName(value = "repos_url")
    val reposUrl: kotlin.String,
    @SerialName(value = "received_events_url")
    val receivedEventsUrl: kotlin.String,
    @SerialName(value = "type")
    val type: kotlin.String,
    @Contextual @SerialName(value = "score")
    val score: kotlin.Double,
    @SerialName(value = "following_url")
    val followingUrl: kotlin.String,
    @SerialName(value = "gists_url")
    val gistsUrl: kotlin.String,
    @SerialName(value = "starred_url")
    val starredUrl: kotlin.String,
    @SerialName(value = "events_url")
    val eventsUrl: kotlin.String,
    @SerialName(value = "site_admin")
    val siteAdmin: kotlin.Boolean,
    @SerialName(value = "public_repos")
    val publicRepos: kotlin.Int? = null,
    @SerialName(value = "public_gists")
    val publicGists: kotlin.Int? = null,
    @SerialName(value = "followers")
    val followers: kotlin.Int? = null,
    @SerialName(value = "following")
    val following: kotlin.Int? = null,
    @SerialName(value = "created_at")
    val createdAt: kotlin.String? = null,
    @SerialName(value = "updated_at")
    val updatedAt: kotlin.String? = null,
    @SerialName(value = "name")
    val name: kotlin.String? = null,
    @SerialName(value = "bio")
    val bio: kotlin.String? = null,
    @SerialName(value = "email")
    val email: kotlin.String? = null,
    @SerialName(value = "location")
    val location: kotlin.String? = null,
    @SerialName(value = "hireable")
    val hireable: kotlin.Boolean? = null,
    @SerialName(value = "blog")
    val blog: kotlin.String? = null,
    @SerialName(value = "company")
    val company: kotlin.String? = null,
    @SerialName(value = "suspended_at")
    val suspendedAt: kotlin.String? = null
) {

}

