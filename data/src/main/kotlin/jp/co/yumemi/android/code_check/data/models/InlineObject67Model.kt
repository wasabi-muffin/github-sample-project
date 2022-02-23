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

import jp.co.yumemi.android.code_check.data.models.ReposOwnerRepoBranchesBranchProtectionRequiredStatusChecksChecksModel

import kotlinx.serialization.*

/**
 * 
 * @param strict Require branches to be up to date before merging.
 * @param contexts **Deprecated**: The list of status checks to require in order to merge into this branch. If any of these checks have recently been set by a particular GitHub App, they will be required to come from that app in future for the branch to merge. Use `checks` instead of `contexts` for more fine-grained control. 
 * @param checks The list of status checks to require in order to merge into this branch.
 */
@Serializable
data class InlineObject67Model(
    /* Require branches to be up to date before merging. */
    @SerialName(value = "strict")
    val strict: kotlin.Boolean? = null,
    /* **Deprecated**: The list of status checks to require in order to merge into this branch. If any of these checks have recently been set by a particular GitHub App, they will be required to come from that app in future for the branch to merge. Use `checks` instead of `contexts` for more fine-grained control.  */
    @SerialName(value = "contexts")
    @Deprecated(message = "This property is deprecated.")
    val contexts: kotlin.collections.List<kotlin.String>? = null,
    /* The list of status checks to require in order to merge into this branch. */
    @SerialName(value = "checks")
    val checks: kotlin.collections.List<ReposOwnerRepoBranchesBranchProtectionRequiredStatusChecksChecksModel>? = null
) {

}

