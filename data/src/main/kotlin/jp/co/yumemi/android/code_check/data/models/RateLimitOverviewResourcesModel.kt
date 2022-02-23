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

import jp.co.yumemi.android.code_check.data.models.RateMinusLimitModel

import kotlinx.serialization.*

/**
 * 
 * @param core 
 * @param search 
 * @param graphql 
 * @param sourceImport 
 * @param integrationManifest 
 * @param codeScanningUpload 
 * @param actionsRunnerRegistration 
 * @param scim 
 */
@Serializable
data class RateLimitOverviewResourcesModel(
    @SerialName(value = "core")
    val core: RateMinusLimitModel,
    @SerialName(value = "search")
    val search: RateMinusLimitModel,
    @SerialName(value = "graphql")
    val graphql: RateMinusLimitModel? = null,
    @SerialName(value = "source_import")
    val sourceImport: RateMinusLimitModel? = null,
    @SerialName(value = "integration_manifest")
    val integrationManifest: RateMinusLimitModel? = null,
    @SerialName(value = "code_scanning_upload")
    val codeScanningUpload: RateMinusLimitModel? = null,
    @SerialName(value = "actions_runner_registration")
    val actionsRunnerRegistration: RateMinusLimitModel? = null,
    @SerialName(value = "scim")
    val scim: RateMinusLimitModel? = null
) {

}

