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
 * @param reason 
 * @param createdAt 
 * @param htmlUrl 
 */
@Serializable
data class InlineResponse403BlockModel(
    @SerialName(value = "reason")
    val reason: kotlin.String? = null,
    @SerialName(value = "created_at")
    val createdAt: kotlin.String? = null,
    @SerialName(value = "html_url")
    val htmlUrl: kotlin.String? = null
) {

}

