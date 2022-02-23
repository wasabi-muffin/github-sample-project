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
 * The public key used for setting Dependabot Secrets.
 * @param keyId The identifier for the key.
 * @param key The Base64 encoded public key.
 */
@Serializable
data class DependabotMinusPublicMinusKeyModel(
    /* The identifier for the key. */
    @SerialName(value = "key_id")
    val keyId: kotlin.String,
    /* The Base64 encoded public key. */
    @SerialName(value = "key")
    val key: kotlin.String
) {

}

