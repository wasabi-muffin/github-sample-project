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
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * 
 * @param status 
 */
@Serializable
data class FullRepositorySecurityAndAnalysisAdvancedSecurityModel(
    @SerialName(value = "status")
    val status: FullRepositorySecurityAndAnalysisAdvancedSecurityModel.Status? = null
) {

    /**
     * 
     * Values: enabled,disabled
     */
    @Serializable(with = Status.Serializer::class)
    enum class Status(val value: kotlin.String) {
        enabled("enabled"),
        disabled("disabled");

        @kotlinx.serialization.Serializer(forClass = Status::class)
        object Serializer {
            override fun deserialize(decoder: Decoder): Status {
                val decoded = decoder.decodeString()
                return values().first { it.value == decoded }
            }

            override val descriptor: SerialDescriptor
                get() = PrimitiveSerialDescriptor(
                    "FullRepositorySecurityAndAnalysisAdvancedSecurityModel.Status.Serializer",
                    PrimitiveKind.STRING
                )

            override fun serialize(encoder: Encoder, value: Status) {
                return encoder.encodeString(value.value)
            }
        }
    }
}

