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

package jp.co.yumemi.android.code_check.remote.models


import kotlinx.serialization.*

/**
 * 
 * @param sha The SHA1 value to set this reference to
 * @param force Indicates whether to force the update or to make sure the update is a fast-forward update. Leaving this out or setting it to `false` will make sure you're not overwriting work.
 */
@Serializable
data class InlineObject88ApiModel(
    /* The SHA1 value to set this reference to */
    @SerialName(value = "sha")
    val sha: kotlin.String,
    /* Indicates whether to force the update or to make sure the update is a fast-forward update. Leaving this out or setting it to `false` will make sure you're not overwriting work. */
    @SerialName(value = "force")
    val force: kotlin.Boolean? = false
) {

}
