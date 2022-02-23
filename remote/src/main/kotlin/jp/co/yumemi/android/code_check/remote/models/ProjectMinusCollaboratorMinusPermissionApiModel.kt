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
 * Project Collaborator Permission
 * @param permission 
 * @param user 
 */
@Serializable
data class ProjectMinusCollaboratorMinusPermissionApiModel(
    @SerialName(value = "permission")
    val permission: kotlin.String,
    @SerialName(value = "user")
    val user: NullableMinusSimpleMinusUserApiModel?
) {

}
