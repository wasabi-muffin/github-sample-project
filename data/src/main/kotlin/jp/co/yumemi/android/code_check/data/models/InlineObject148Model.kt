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

import jp.co.yumemi.android.code_check.data.models.ScimV2OrganizationsOrgUsersEmailsModel
import jp.co.yumemi.android.code_check.data.models.ScimV2OrganizationsOrgUsersNameModel

import kotlinx.serialization.*

/**
 * 
 * @param userName Configured by the admin. Could be an email, login, or username
 * @param name 
 * @param emails user emails
 * @param displayName The name of the user, suitable for display to end-users
 * @param schemas 
 * @param externalId 
 * @param groups 
 * @param active 
 */
@Serializable
data class InlineObject148Model(
    /* Configured by the admin. Could be an email, login, or username */
    @SerialName(value = "userName")
    val userName: kotlin.String,
    @SerialName(value = "name")
    val name: ScimV2OrganizationsOrgUsersNameModel,
    /* user emails */
    @SerialName(value = "emails")
    val emails: kotlin.collections.List<ScimV2OrganizationsOrgUsersEmailsModel>,
    /* The name of the user, suitable for display to end-users */
    @SerialName(value = "displayName")
    val displayName: kotlin.String? = null,
    @SerialName(value = "schemas")
    val schemas: kotlin.collections.List<kotlin.String>? = null,
    @SerialName(value = "externalId")
    val externalId: kotlin.String? = null,
    @SerialName(value = "groups")
    val groups: kotlin.collections.List<kotlin.String>? = null,
    @SerialName(value = "active")
    val active: kotlin.Boolean? = null
) {

}

