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

package jp.co.yumemi.android.code_check.remote.models

import jp.co.yumemi.android.code_check.remote.models.NullableMinusSimpleMinusUserApiModel

import kotlinx.serialization.*

/**
 * The status of a commit.
 * @param url 
 * @param avatarUrl 
 * @param id 
 * @param nodeId 
 * @param state 
 * @param description 
 * @param targetUrl 
 * @param context 
 * @param createdAt 
 * @param updatedAt 
 * @param creator 
 */
@Serializable
data class StatusApiModel(
    @SerialName(value = "url")
    val url: kotlin.String,
    @SerialName(value = "avatar_url")
    val avatarUrl: kotlin.String?,
    @SerialName(value = "id")
    val id: kotlin.Int,
    @SerialName(value = "node_id")
    val nodeId: kotlin.String,
    @SerialName(value = "state")
    val state: kotlin.String,
    @SerialName(value = "description")
    val description: kotlin.String,
    @SerialName(value = "target_url")
    val targetUrl: kotlin.String,
    @SerialName(value = "context")
    val context: kotlin.String,
    @SerialName(value = "created_at")
    val createdAt: kotlin.String,
    @SerialName(value = "updated_at")
    val updatedAt: kotlin.String,
    @SerialName(value = "creator")
    val creator: NullableMinusSimpleMinusUserApiModel?
) {

}
