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
 * @param armoredPublicKey A GPG key in ASCII-armored format.
 */
@Serializable
data class InlineObject166Model(
    /* A GPG key in ASCII-armored format. */
    @SerialName(value = "armored_public_key")
    val armoredPublicKey: kotlin.String
) {

}

