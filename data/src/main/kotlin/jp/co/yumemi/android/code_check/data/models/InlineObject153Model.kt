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
 * @param title The discussion post's title.
 * @param body The discussion post's body text.
 */
@Serializable
data class InlineObject153Model(
    /* The discussion post's title. */
    @SerialName(value = "title")
    val title: kotlin.String? = null,
    /* The discussion post's body text. */
    @SerialName(value = "body")
    val body: kotlin.String? = null
) {

}

