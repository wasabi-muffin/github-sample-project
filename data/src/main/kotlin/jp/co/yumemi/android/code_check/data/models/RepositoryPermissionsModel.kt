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


import kotlinx.serialization.*

/**
 * 
 * @param admin 
 * @param pull 
 * @param push 
 * @param triage 
 * @param maintain 
 */
@Serializable
data class RepositoryPermissionsModel(
    @SerialName(value = "admin")
    val admin: kotlin.Boolean,
    @SerialName(value = "pull")
    val pull: kotlin.Boolean,
    @SerialName(value = "push")
    val push: kotlin.Boolean,
    @SerialName(value = "triage")
    val triage: kotlin.Boolean? = null,
    @SerialName(value = "maintain")
    val maintain: kotlin.Boolean? = null
) {

}
