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
 * An SSH key granting access to a single repository.
 * @param id 
 * @param key 
 * @param url 
 * @param title 
 * @param verified 
 * @param createdAt 
 * @param readOnly 
 */
@Serializable
data class DeployMinusKeyModel(
    @SerialName(value = "id")
    val id: kotlin.Int,
    @SerialName(value = "key")
    val key: kotlin.String,
    @SerialName(value = "url")
    val url: kotlin.String,
    @SerialName(value = "title")
    val title: kotlin.String,
    @SerialName(value = "verified")
    val verified: kotlin.Boolean,
    @SerialName(value = "created_at")
    val createdAt: kotlin.String,
    @SerialName(value = "read_only")
    val readOnly: kotlin.Boolean
) {

}

