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

import jp.co.yumemi.android.code_check.data.models.SimpleMinusUserModel

import kotlinx.serialization.*

/**
 * Organization Invitation
 * @param id 
 * @param login 
 * @param email 
 * @param role 
 * @param createdAt 
 * @param inviter 
 * @param teamCount 
 * @param nodeId 
 * @param invitationTeamsUrl 
 * @param failedAt 
 * @param failedReason 
 */
@Serializable
data class OrganizationMinusInvitationModel(
    @SerialName(value = "id")
    val id: kotlin.Int,
    @SerialName(value = "login")
    val login: kotlin.String?,
    @SerialName(value = "email")
    val email: kotlin.String?,
    @SerialName(value = "role")
    val role: kotlin.String,
    @SerialName(value = "created_at")
    val createdAt: kotlin.String,
    @SerialName(value = "inviter")
    val inviter: SimpleMinusUserModel,
    @SerialName(value = "team_count")
    val teamCount: kotlin.Int,
    @SerialName(value = "node_id")
    val nodeId: kotlin.String,
    @SerialName(value = "invitation_teams_url")
    val invitationTeamsUrl: kotlin.String,
    @SerialName(value = "failed_at")
    val failedAt: kotlin.String? = null,
    @SerialName(value = "failed_reason")
    val failedReason: kotlin.String? = null
) {

}

