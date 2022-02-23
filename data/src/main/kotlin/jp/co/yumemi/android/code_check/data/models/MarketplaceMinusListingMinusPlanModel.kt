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


import kotlinx.serialization.*

/**
 * Marketplace Listing Plan
 * @param url 
 * @param accountsUrl 
 * @param id 
 * @param number 
 * @param name 
 * @param description 
 * @param monthlyPriceInCents 
 * @param yearlyPriceInCents 
 * @param priceModel 
 * @param hasFreeTrial 
 * @param unitName 
 * @param state 
 * @param bullets 
 */
@Serializable
data class MarketplaceMinusListingMinusPlanModel(
    @SerialName(value = "url")
    val url: kotlin.String,
    @SerialName(value = "accounts_url")
    val accountsUrl: kotlin.String,
    @SerialName(value = "id")
    val id: kotlin.Int,
    @SerialName(value = "number")
    val number: kotlin.Int,
    @SerialName(value = "name")
    val name: kotlin.String,
    @SerialName(value = "description")
    val description: kotlin.String,
    @SerialName(value = "monthly_price_in_cents")
    val monthlyPriceInCents: kotlin.Int,
    @SerialName(value = "yearly_price_in_cents")
    val yearlyPriceInCents: kotlin.Int,
    @SerialName(value = "price_model")
    val priceModel: kotlin.String,
    @SerialName(value = "has_free_trial")
    val hasFreeTrial: kotlin.Boolean,
    @SerialName(value = "unit_name")
    val unitName: kotlin.String?,
    @SerialName(value = "state")
    val state: kotlin.String,
    @SerialName(value = "bullets")
    val bullets: kotlin.collections.List<kotlin.String>
) {

}

