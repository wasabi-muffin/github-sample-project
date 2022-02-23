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

import jp.co.yumemi.android.code_check.data.models.CodeMinusScanningMinusAlertMinusDismissedMinusReasonModel
import jp.co.yumemi.android.code_check.data.models.CodeMinusScanningMinusAlertMinusInstanceModel
import jp.co.yumemi.android.code_check.data.models.CodeMinusScanningMinusAlertMinusRuleModel
import jp.co.yumemi.android.code_check.data.models.CodeMinusScanningMinusAlertMinusStateModel
import jp.co.yumemi.android.code_check.data.models.CodeMinusScanningMinusAnalysisMinusToolModel
import jp.co.yumemi.android.code_check.data.models.MinimalMinusRepositoryModel
import jp.co.yumemi.android.code_check.data.models.NullableMinusSimpleMinusUserModel

import kotlinx.serialization.*

/**
 * 
 * @param number The security alert number.
 * @param createdAt The time that the alert was created in ISO 8601 format: `YYYY-MM-DDTHH:MM:SSZ`.
 * @param url The REST API URL of the alert resource.
 * @param htmlUrl The GitHub URL of the alert resource.
 * @param instancesUrl The REST API URL for fetching the list of instances for an alert.
 * @param state 
 * @param dismissedBy 
 * @param dismissedAt The time that the alert was dismissed in ISO 8601 format: `YYYY-MM-DDTHH:MM:SSZ`.
 * @param dismissedReason 
 * @param rule 
 * @param tool 
 * @param mostRecentInstance 
 * @param repository 
 * @param updatedAt The time that the alert was last updated in ISO 8601 format: `YYYY-MM-DDTHH:MM:SSZ`.
 * @param fixedAt The time that the alert was no longer detected and was considered fixed in ISO 8601 format: `YYYY-MM-DDTHH:MM:SSZ`.
 */
@Serializable
data class CodeMinusScanningMinusOrganizationMinusAlertMinusItemsModel(
    /* The security alert number. */
    @SerialName(value = "number")
    val number: kotlin.Int,
    /* The time that the alert was created in ISO 8601 format: `YYYY-MM-DDTHH:MM:SSZ`. */
    @SerialName(value = "created_at")
    val createdAt: kotlin.String,
    /* The REST API URL of the alert resource. */
    @SerialName(value = "url")
    val url: kotlin.String,
    /* The GitHub URL of the alert resource. */
    @SerialName(value = "html_url")
    val htmlUrl: kotlin.String,
    /* The REST API URL for fetching the list of instances for an alert. */
    @SerialName(value = "instances_url")
    val instancesUrl: kotlin.String,
    @Contextual @SerialName(value = "state")
    val state: CodeMinusScanningMinusAlertMinusStateModel,
    @SerialName(value = "dismissed_by")
    val dismissedBy: NullableMinusSimpleMinusUserModel?,
    /* The time that the alert was dismissed in ISO 8601 format: `YYYY-MM-DDTHH:MM:SSZ`. */
    @SerialName(value = "dismissed_at")
    val dismissedAt: kotlin.String?,
    @Contextual @SerialName(value = "dismissed_reason")
    val dismissedReason: CodeMinusScanningMinusAlertMinusDismissedMinusReasonModel?,
    @SerialName(value = "rule")
    val rule: CodeMinusScanningMinusAlertMinusRuleModel,
    @SerialName(value = "tool")
    val tool: CodeMinusScanningMinusAnalysisMinusToolModel,
    @SerialName(value = "most_recent_instance")
    val mostRecentInstance: CodeMinusScanningMinusAlertMinusInstanceModel,
    @SerialName(value = "repository")
    val repository: MinimalMinusRepositoryModel,
    /* The time that the alert was last updated in ISO 8601 format: `YYYY-MM-DDTHH:MM:SSZ`. */
    @SerialName(value = "updated_at")
    val updatedAt: kotlin.String? = null,
    /* The time that the alert was no longer detected and was considered fixed in ISO 8601 format: `YYYY-MM-DDTHH:MM:SSZ`. */
    @SerialName(value = "fixed_at")
    val fixedAt: kotlin.String? = null
) {

}

