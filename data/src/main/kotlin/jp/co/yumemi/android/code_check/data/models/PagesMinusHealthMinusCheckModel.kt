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

import jp.co.yumemi.android.code_check.data.models.PagesHealthCheckAltDomainModel
import jp.co.yumemi.android.code_check.data.models.PagesHealthCheckDomainModel

import kotlinx.serialization.*

/**
 * Pages Health Check Status
 * @param domain 
 * @param altDomain 
 */
@Serializable
data class PagesMinusHealthMinusCheckModel(
    @SerialName(value = "domain")
    val domain: PagesHealthCheckDomainModel? = null,
    @SerialName(value = "alt_domain")
    val altDomain: PagesHealthCheckAltDomainModel? = null
) {

}

