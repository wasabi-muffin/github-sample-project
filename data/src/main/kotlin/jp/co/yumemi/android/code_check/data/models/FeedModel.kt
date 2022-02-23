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

import jp.co.yumemi.android.code_check.data.models.FeedLinksModel

import kotlinx.serialization.*

/**
 * Feed
 * @param timelineUrl 
 * @param userUrl 
 * @param links 
 * @param currentUserPublicUrl 
 * @param currentUserUrl 
 * @param currentUserActorUrl 
 * @param currentUserOrganizationUrl 
 * @param currentUserOrganizationUrls 
 * @param securityAdvisoriesUrl 
 */
@Serializable
data class FeedModel(
    @SerialName(value = "timeline_url")
    val timelineUrl: kotlin.String,
    @SerialName(value = "user_url")
    val userUrl: kotlin.String,
    @SerialName(value = "_links")
    val links: FeedLinksModel,
    @SerialName(value = "current_user_public_url")
    val currentUserPublicUrl: kotlin.String? = null,
    @SerialName(value = "current_user_url")
    val currentUserUrl: kotlin.String? = null,
    @SerialName(value = "current_user_actor_url")
    val currentUserActorUrl: kotlin.String? = null,
    @SerialName(value = "current_user_organization_url")
    val currentUserOrganizationUrl: kotlin.String? = null,
    @SerialName(value = "current_user_organization_urls")
    val currentUserOrganizationUrls: kotlin.collections.List<kotlin.String>? = null,
    @SerialName(value = "security_advisories_url")
    val securityAdvisoriesUrl: kotlin.String? = null
) {

}

