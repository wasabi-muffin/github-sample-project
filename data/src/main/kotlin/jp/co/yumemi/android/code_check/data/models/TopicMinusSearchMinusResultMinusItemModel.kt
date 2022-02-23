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

import jp.co.yumemi.android.code_check.data.models.TopicSearchResultItemRelatedModel

import kotlinx.serialization.*

/**
 * Topic Search Result Item
 * @param name 
 * @param displayName 
 * @param shortDescription 
 * @param description 
 * @param createdBy 
 * @param released 
 * @param createdAt 
 * @param updatedAt 
 * @param featured 
 * @param curated 
 * @param score 
 * @param repositoryCount 
 * @param logoUrl 
 * @param related 
 * @param aliases 
 */
@Serializable
data class TopicMinusSearchMinusResultMinusItemModel(
    @SerialName(value = "name")
    val name: kotlin.String,
    @SerialName(value = "display_name")
    val displayName: kotlin.String?,
    @SerialName(value = "short_description")
    val shortDescription: kotlin.String?,
    @SerialName(value = "description")
    val description: kotlin.String?,
    @SerialName(value = "created_by")
    val createdBy: kotlin.String?,
    @SerialName(value = "released")
    val released: kotlin.String?,
    @SerialName(value = "created_at")
    val createdAt: kotlin.String,
    @SerialName(value = "updated_at")
    val updatedAt: kotlin.String,
    @SerialName(value = "featured")
    val featured: kotlin.Boolean,
    @SerialName(value = "curated")
    val curated: kotlin.Boolean,
    @Contextual @SerialName(value = "score")
    val score: kotlin.Double,
    @SerialName(value = "repository_count")
    val repositoryCount: kotlin.Int? = null,
    @SerialName(value = "logo_url")
    val logoUrl: kotlin.String? = null,
    @SerialName(value = "related")
    val related: kotlin.collections.List<TopicSearchResultItemRelatedModel>? = null,
    @SerialName(value = "aliases")
    val aliases: kotlin.collections.List<TopicSearchResultItemRelatedModel>? = null
) {

}

