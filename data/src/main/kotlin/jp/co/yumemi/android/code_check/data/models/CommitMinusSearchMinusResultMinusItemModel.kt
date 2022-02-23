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

import jp.co.yumemi.android.code_check.data.models.CommitSearchResultItemCommitModel
import jp.co.yumemi.android.code_check.data.models.FileCommitCommitParentsModel
import jp.co.yumemi.android.code_check.data.models.MinimalMinusRepositoryModel
import jp.co.yumemi.android.code_check.data.models.NullableMinusGitMinusUserModel
import jp.co.yumemi.android.code_check.data.models.NullableMinusSimpleMinusUserModel

import kotlinx.serialization.*

/**
 * Commit Search Result Item
 * @param url 
 * @param sha 
 * @param htmlUrl 
 * @param commentsUrl 
 * @param commit 
 * @param author 
 * @param committer 
 * @param parents 
 * @param repository 
 * @param score 
 * @param nodeId 
 */
@Serializable
data class CommitMinusSearchMinusResultMinusItemModel(
    @SerialName(value = "url")
    val url: kotlin.String,
    @SerialName(value = "sha")
    val sha: kotlin.String,
    @SerialName(value = "html_url")
    val htmlUrl: kotlin.String,
    @SerialName(value = "comments_url")
    val commentsUrl: kotlin.String,
    @SerialName(value = "commit")
    val commit: CommitSearchResultItemCommitModel,
    @SerialName(value = "author")
    val author: NullableMinusSimpleMinusUserModel?,
    @SerialName(value = "committer")
    val committer: NullableMinusGitMinusUserModel?,
    @SerialName(value = "parents")
    val parents: kotlin.collections.List<FileCommitCommitParentsModel>,
    @SerialName(value = "repository")
    val repository: MinimalMinusRepositoryModel,
    @Contextual @SerialName(value = "score")
    val score: kotlin.Double,
    @SerialName(value = "node_id")
    val nodeId: kotlin.String
) {

}
