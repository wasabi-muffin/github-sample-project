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

import jp.co.yumemi.android.code_check.data.models.NullableMinusIntegrationModel
import jp.co.yumemi.android.code_check.data.models.RenamedIssueEventRenameModel
import jp.co.yumemi.android.code_check.data.models.SimpleMinusUserModel

import kotlinx.serialization.*

/**
 * Renamed Issue Event
 * @param id 
 * @param nodeId 
 * @param url 
 * @param actor 
 * @param event 
 * @param commitId 
 * @param commitUrl 
 * @param createdAt 
 * @param performedViaGithubApp 
 * @param rename 
 */
@Serializable
data class RenamedMinusIssueMinusEventModel(
    @SerialName(value = "id")
    val id: kotlin.Int,
    @SerialName(value = "node_id")
    val nodeId: kotlin.String,
    @SerialName(value = "url")
    val url: kotlin.String,
    @SerialName(value = "actor")
    val actor: SimpleMinusUserModel,
    @SerialName(value = "event")
    val event: kotlin.String,
    @SerialName(value = "commit_id")
    val commitId: kotlin.String?,
    @SerialName(value = "commit_url")
    val commitUrl: kotlin.String?,
    @SerialName(value = "created_at")
    val createdAt: kotlin.String,
    @SerialName(value = "performed_via_github_app")
    val performedViaGithubApp: NullableMinusIntegrationModel?,
    @SerialName(value = "rename")
    val rename: RenamedIssueEventRenameModel
) {

}

