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

import jp.co.yumemi.android.code_check.remote.models.CommitSearchResultItemCommitAuthorApiModel
import jp.co.yumemi.android.code_check.remote.models.NullableMinusGitMinusUserApiModel
import jp.co.yumemi.android.code_check.remote.models.ShortBranchCommitApiModel
import jp.co.yumemi.android.code_check.remote.models.VerificationApiModel

import kotlinx.serialization.*

/**
 * 
 * @param author 
 * @param committer 
 * @param commentCount 
 * @param message 
 * @param tree 
 * @param url 
 * @param verification 
 */
@Serializable
data class CommitSearchResultItemCommitApiModel(
    @SerialName(value = "author")
    val author: CommitSearchResultItemCommitAuthorApiModel,
    @SerialName(value = "committer")
    val committer: NullableMinusGitMinusUserApiModel?,
    @SerialName(value = "comment_count")
    val commentCount: kotlin.Int,
    @SerialName(value = "message")
    val message: kotlin.String,
    @SerialName(value = "tree")
    val tree: ShortBranchCommitApiModel,
    @SerialName(value = "url")
    val url: kotlin.String,
    @SerialName(value = "verification")
    val verification: VerificationApiModel? = null
) {

}
