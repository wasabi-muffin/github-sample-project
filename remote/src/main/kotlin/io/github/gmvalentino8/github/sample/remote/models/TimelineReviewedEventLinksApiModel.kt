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

package io.github.gmvalentino8.github.sample.remote.models

import io.github.gmvalentino8.github.sample.remote.models.TimelineReviewedEventLinksHtmlApiModel

import kotlinx.serialization.*

/**
 * 
 * @param html 
 * @param pullRequest 
 */
@Serializable
data class TimelineReviewedEventLinksApiModel(
    @SerialName(value = "html")
    val html: TimelineReviewedEventLinksHtmlApiModel,
    @SerialName(value = "pull_request")
    val pullRequest: TimelineReviewedEventLinksHtmlApiModel
) {

}

