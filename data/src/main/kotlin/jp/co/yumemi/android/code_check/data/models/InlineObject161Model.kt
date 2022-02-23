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

import jp.co.yumemi.android.code_check.data.models.TeamsTeamIdTeamSyncGroupMappingsGroupsModel

import kotlinx.serialization.*

/**
 * 
 * @param groups The IdP groups you want to connect to a GitHub team. When updating, the new `groups` object will replace the original one. You must include any existing groups that you don't want to remove.
 * @param syncedAt 
 */
@Serializable
data class InlineObject161Model(
    /* The IdP groups you want to connect to a GitHub team. When updating, the new `groups` object will replace the original one. You must include any existing groups that you don't want to remove. */
    @SerialName(value = "groups")
    val groups: kotlin.collections.List<TeamsTeamIdTeamSyncGroupMappingsGroupsModel>,
    @SerialName(value = "synced_at")
    val syncedAt: kotlin.String? = null
) {

}

