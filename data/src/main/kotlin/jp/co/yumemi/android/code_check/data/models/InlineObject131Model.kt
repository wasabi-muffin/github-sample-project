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
 * @param name The file name of the asset.
 * @param label An alternate short description of the asset. Used in place of the filename.
 * @param state 
 */
@Serializable
data class InlineObject131Model(
    /* The file name of the asset. */
    @SerialName(value = "name")
    val name: kotlin.String? = null,
    /* An alternate short description of the asset. Used in place of the filename. */
    @SerialName(value = "label")
    val label: kotlin.String? = null,
    @SerialName(value = "state")
    val state: kotlin.String? = null
) {

}

