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

import jp.co.yumemi.android.code_check.data.models.SecretMinusScanningMinusAlertMinusResolutionModel
import jp.co.yumemi.android.code_check.data.models.SecretMinusScanningMinusAlertMinusStateModel

import kotlinx.serialization.*

/**
 * 
 * @param state 
 * @param resolution 
 */
@Serializable
data class InlineObject135Model(
    @Contextual @SerialName(value = "state")
    val state: SecretMinusScanningMinusAlertMinusStateModel,
    @Contextual @SerialName(value = "resolution")
    val resolution: SecretMinusScanningMinusAlertMinusResolutionModel? = null
) {

}

