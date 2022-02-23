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

import jp.co.yumemi.android.code_check.data.models.GitTagObjectModel
import jp.co.yumemi.android.code_check.data.models.GitTagTaggerModel
import jp.co.yumemi.android.code_check.data.models.VerificationModel

import kotlinx.serialization.*

/**
 * Metadata for a Git tag
 * @param nodeId 
 * @param tag Name of the tag
 * @param sha 
 * @param url URL for the tag
 * @param message Message describing the purpose of the tag
 * @param tagger 
 * @param `object` 
 * @param verification 
 */
@Serializable
data class GitMinusTagModel(
    @SerialName(value = "node_id")
    val nodeId: kotlin.String,
    /* Name of the tag */
    @SerialName(value = "tag")
    val tag: kotlin.String,
    @SerialName(value = "sha")
    val sha: kotlin.String,
    /* URL for the tag */
    @SerialName(value = "url")
    val url: kotlin.String,
    /* Message describing the purpose of the tag */
    @SerialName(value = "message")
    val message: kotlin.String,
    @SerialName(value = "tagger")
    val tagger: GitTagTaggerModel,
    @SerialName(value = "object")
    val `object`: GitTagObjectModel,
    @SerialName(value = "verification")
    val verification: VerificationModel? = null
) {

}

