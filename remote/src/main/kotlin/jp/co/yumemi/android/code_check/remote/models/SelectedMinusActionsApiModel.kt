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
 * @param githubOwnedAllowed Whether GitHub-owned actions are allowed. For example, this includes the actions in the `actions` organization.
 * @param verifiedAllowed Whether actions in GitHub Marketplace from verified creators are allowed. Set to `true` to allow all GitHub Marketplace actions by verified creators.
 * @param patternsAllowed Specifies a list of string-matching patterns to allow specific action(s). Wildcards, tags, and SHAs are allowed. For example, `monalisa/octocat@*`, `monalisa/octocat@v2`, `monalisa/_*`.\"
 */
@Serializable
data class SelectedMinusActionsApiModel(
    /* Whether GitHub-owned actions are allowed. For example, this includes the actions in the `actions` organization. */
    @SerialName(value = "github_owned_allowed")
    val githubOwnedAllowed: kotlin.Boolean? = null,
    /* Whether actions in GitHub Marketplace from verified creators are allowed. Set to `true` to allow all GitHub Marketplace actions by verified creators. */
    @SerialName(value = "verified_allowed")
    val verifiedAllowed: kotlin.Boolean? = null,
    /* Specifies a list of string-matching patterns to allow specific action(s). Wildcards, tags, and SHAs are allowed. For example, `monalisa/octocat@*`, `monalisa/octocat@v2`, `monalisa/_*`.\" */
    @SerialName(value = "patterns_allowed")
    val patternsAllowed: kotlin.collections.List<kotlin.String>? = null
) {

}
