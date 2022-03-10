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

import io.github.gmvalentino8.github.sample.remote.models.GroupMappingGroupsApiModel

import kotlinx.serialization.*

/**
 * External Groups to be mapped to a team for membership
 * @param groups Array of groups to be mapped to this team
 */
@Serializable
data class GroupMinusMappingApiModel(
    /* Array of groups to be mapped to this team */
    @SerialName(value = "groups")
    val groups: kotlin.collections.List<GroupMappingGroupsApiModel>? = null
) {

}
