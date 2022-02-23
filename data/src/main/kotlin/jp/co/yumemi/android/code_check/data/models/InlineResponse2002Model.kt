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

import jp.co.yumemi.android.code_check.data.models.OrganizationMinusCustomMinusRepositoryMinusRoleModel

import kotlinx.serialization.*

/**
 * 
 * @param totalCount The number of custom roles in this organization
 * @param customRoles 
 */
@Serializable
data class InlineResponse2002Model(
    /* The number of custom roles in this organization */
    @SerialName(value = "total_count")
    val totalCount: kotlin.Int? = null,
    @SerialName(value = "custom_roles")
    val customRoles: kotlin.collections.List<OrganizationMinusCustomMinusRepositoryMinusRoleModel>? = null
) {

}

