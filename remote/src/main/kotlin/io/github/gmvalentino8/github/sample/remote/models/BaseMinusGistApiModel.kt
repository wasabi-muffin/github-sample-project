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

import io.github.gmvalentino8.github.sample.remote.models.BaseGistFilesApiModel
import io.github.gmvalentino8.github.sample.remote.models.NullableMinusSimpleMinusUserApiModel
import io.github.gmvalentino8.github.sample.remote.models.SimpleMinusUserApiModel

import kotlinx.serialization.*

/**
 * Base Gist
 * @param url 
 * @param forksUrl 
 * @param commitsUrl 
 * @param id 
 * @param nodeId 
 * @param gitPullUrl 
 * @param gitPushUrl 
 * @param htmlUrl 
 * @param files 
 * @param createdAt 
 * @param updatedAt 
 * @param description 
 * @param comments 
 * @param user 
 * @param commentsUrl 
 * @param isPublic 
 * @param owner 
 * @param truncated 
 * @param forks 
 * @param history 
 */
@Serializable
data class BaseMinusGistApiModel(
    @SerialName(value = "url")
    val url: kotlin.String,
    @SerialName(value = "forks_url")
    val forksUrl: kotlin.String,
    @SerialName(value = "commits_url")
    val commitsUrl: kotlin.String,
    @SerialName(value = "id")
    val id: kotlin.String,
    @SerialName(value = "node_id")
    val nodeId: kotlin.String,
    @SerialName(value = "git_pull_url")
    val gitPullUrl: kotlin.String,
    @SerialName(value = "git_push_url")
    val gitPushUrl: kotlin.String,
    @SerialName(value = "html_url")
    val htmlUrl: kotlin.String,
    @Contextual @SerialName(value = "files")
    val files: kotlin.collections.Map<kotlin.String, BaseGistFilesApiModel>,
    @SerialName(value = "created_at")
    val createdAt: kotlin.String,
    @SerialName(value = "updated_at")
    val updatedAt: kotlin.String,
    @SerialName(value = "description")
    val description: kotlin.String?,
    @SerialName(value = "comments")
    val comments: kotlin.Int,
    @SerialName(value = "user")
    val user: NullableMinusSimpleMinusUserApiModel?,
    @SerialName(value = "comments_url")
    val commentsUrl: kotlin.String,
    @SerialName(value = "is_public")
    val isPublic: kotlin.Boolean? = null,
    @SerialName(value = "owner")
    val owner: SimpleMinusUserApiModel? = null,
    @SerialName(value = "truncated")
    val truncated: kotlin.Boolean? = null,
    @SerialName(value = "forks")
    val forks: kotlin.collections.List<@Contextual kotlin.Any>? = null,
    @SerialName(value = "history")
    val history: kotlin.collections.List<@Contextual kotlin.Any>? = null
) {

}

