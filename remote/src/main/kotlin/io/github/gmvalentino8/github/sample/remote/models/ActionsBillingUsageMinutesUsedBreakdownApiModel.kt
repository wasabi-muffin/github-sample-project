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

package io.github.gmvalentino8.github.sample.remote.models


import kotlinx.serialization.*

/**
 * 
 * @param UBUNTU Total minutes used on Ubuntu runner machines.
 * @param MACOS Total minutes used on macOS runner machines.
 * @param WINDOWS Total minutes used on Windows runner machines.
 */
@Serializable
data class ActionsBillingUsageMinutesUsedBreakdownApiModel(
    /* Total minutes used on Ubuntu runner machines. */
    @SerialName(value = "UBUNTU")
    val UBUNTU: kotlin.Int? = null,
    /* Total minutes used on macOS runner machines. */
    @SerialName(value = "MACOS")
    val MACOS: kotlin.Int? = null,
    /* Total minutes used on Windows runner machines. */
    @SerialName(value = "WINDOWS")
    val WINDOWS: kotlin.Int? = null
) {

}

