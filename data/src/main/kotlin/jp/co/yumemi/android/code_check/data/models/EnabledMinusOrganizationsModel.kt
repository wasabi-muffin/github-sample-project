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


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The policy that controls the organizations in the enterprise that are allowed to run GitHub Actions. Can be one of: `all`, `none`, or `selected`.
 *
 * Values: all,none,selected
 */
@Serializable
enum class EnabledMinusOrganizationsModel(val value: kotlin.String) {

    @SerialName(value = "all")
    all("all"),

    @SerialName(value = "none")
    none("none"),

    @SerialName(value = "selected")
    selected("selected");

    /**
     * Override toString() to avoid using the enum variable name as the value, and instead use
     * the actual value defined in the API spec file.
     *
     * This solves a problem when the variable name and its value are different, and ensures that
     * the client sends the correct enum values to the server always.
     */
    override fun toString(): String = value

    companion object {
        /**
         * Converts the provided [data] to a [String] on success, null otherwise.
         */
        fun encode(data: Any?): kotlin.String? = if (data is EnabledMinusOrganizationsModel) "$data" else null

        /**
         * Returns a valid [EnabledMinusOrganizationsModel] for [data], null otherwise.
         */
        fun decode(data: Any?): EnabledMinusOrganizationsModel? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

