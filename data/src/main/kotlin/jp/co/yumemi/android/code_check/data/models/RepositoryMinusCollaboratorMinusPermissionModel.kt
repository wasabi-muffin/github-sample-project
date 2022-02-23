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

import jp.co.yumemi.android.code_check.data.models.NullableMinusCollaboratorModel

import kotlinx.serialization.*

/**
 * Repository Collaborator Permission
 * @param permission 
 * @param roleName 
 * @param user 
 */
@Serializable
data class RepositoryMinusCollaboratorMinusPermissionModel(
    @SerialName(value = "permission")
    val permission: kotlin.String,
    @SerialName(value = "role_name")
    val roleName: kotlin.String,
    @SerialName(value = "user")
    val user: NullableMinusCollaboratorModel?
) {

}
