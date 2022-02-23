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

import jp.co.yumemi.android.code_check.data.models.ReposOwnerRepoBranchesBranchProtectionRequiredPullRequestReviewsModel
import jp.co.yumemi.android.code_check.data.models.ReposOwnerRepoBranchesBranchProtectionRequiredStatusChecksModel
import jp.co.yumemi.android.code_check.data.models.ReposOwnerRepoBranchesBranchProtectionRestrictionsModel

import kotlinx.serialization.*

/**
 * 
 * @param requiredStatusChecks 
 * @param enforceAdmins Enforce all configured restrictions for administrators. Set to `true` to enforce required status checks for repository administrators. Set to `null` to disable.
 * @param requiredPullRequestReviews 
 * @param restrictions 
 * @param requiredLinearHistory Enforces a linear commit Git history, which prevents anyone from pushing merge commits to a branch. Set to `true` to enforce a linear commit history. Set to `false` to disable a linear commit Git history. Your repository must allow squash merging or rebase merging before you can enable a linear commit history. Default: `false`. For more information, see \"[Requiring a linear commit history](https://docs.github.com/github/administering-a-repository/requiring-a-linear-commit-history)\" in the GitHub Help documentation.
 * @param allowForcePushes Permits force pushes to the protected branch by anyone with write access to the repository. Set to `true` to allow force pushes. Set to `false` or `null` to block force pushes. Default: `false`. For more information, see \"[Enabling force pushes to a protected branch](https://docs.github.com/en/github/administering-a-repository/enabling-force-pushes-to-a-protected-branch)\" in the GitHub Help documentation.\"
 * @param allowDeletions Allows deletion of the protected branch by anyone with write access to the repository. Set to `false` to prevent deletion of the protected branch. Default: `false`. For more information, see \"[Enabling force pushes to a protected branch](https://docs.github.com/en/github/administering-a-repository/enabling-force-pushes-to-a-protected-branch)\" in the GitHub Help documentation.
 * @param requiredConversationResolution Requires all conversations on code to be resolved before a pull request can be merged into a branch that matches this rule. Set to `false` to disable. Default: `false`.
 */
@Serializable
data class InlineObject65Model(
    @SerialName(value = "required_status_checks")
    val requiredStatusChecks: ReposOwnerRepoBranchesBranchProtectionRequiredStatusChecksModel?,
    /* Enforce all configured restrictions for administrators. Set to `true` to enforce required status checks for repository administrators. Set to `null` to disable. */
    @SerialName(value = "enforce_admins")
    val enforceAdmins: kotlin.Boolean?,
    @SerialName(value = "required_pull_request_reviews")
    val requiredPullRequestReviews: ReposOwnerRepoBranchesBranchProtectionRequiredPullRequestReviewsModel?,
    @SerialName(value = "restrictions")
    val restrictions: ReposOwnerRepoBranchesBranchProtectionRestrictionsModel?,
    /* Enforces a linear commit Git history, which prevents anyone from pushing merge commits to a branch. Set to `true` to enforce a linear commit history. Set to `false` to disable a linear commit Git history. Your repository must allow squash merging or rebase merging before you can enable a linear commit history. Default: `false`. For more information, see \"[Requiring a linear commit history](https://docs.github.com/github/administering-a-repository/requiring-a-linear-commit-history)\" in the GitHub Help documentation. */
    @SerialName(value = "required_linear_history")
    val requiredLinearHistory: kotlin.Boolean? = null,
    /* Permits force pushes to the protected branch by anyone with write access to the repository. Set to `true` to allow force pushes. Set to `false` or `null` to block force pushes. Default: `false`. For more information, see \"[Enabling force pushes to a protected branch](https://docs.github.com/en/github/administering-a-repository/enabling-force-pushes-to-a-protected-branch)\" in the GitHub Help documentation.\" */
    @SerialName(value = "allow_force_pushes")
    val allowForcePushes: kotlin.Boolean? = null,
    /* Allows deletion of the protected branch by anyone with write access to the repository. Set to `false` to prevent deletion of the protected branch. Default: `false`. For more information, see \"[Enabling force pushes to a protected branch](https://docs.github.com/en/github/administering-a-repository/enabling-force-pushes-to-a-protected-branch)\" in the GitHub Help documentation. */
    @SerialName(value = "allow_deletions")
    val allowDeletions: kotlin.Boolean? = null,
    /* Requires all conversations on code to be resolved before a pull request can be merged into a branch that matches this rule. Set to `false` to disable. Default: `false`. */
    @SerialName(value = "required_conversation_resolution")
    val requiredConversationResolution: kotlin.Boolean? = null
) {

}

