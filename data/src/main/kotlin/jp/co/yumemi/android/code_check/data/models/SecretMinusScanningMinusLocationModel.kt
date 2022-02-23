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

import jp.co.yumemi.android.code_check.data.models.SecretMinusScanningMinusLocationMinusCommitModel

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * 
 * @param type The location type. Because secrets may be found in different types of resources (ie. code, comments, issues), this field identifies the type of resource where the secret was found.
 * @param details 
 */
@Serializable
data class SecretMinusScanningMinusLocationModel(
    /* The location type. Because secrets may be found in different types of resources (ie. code, comments, issues), this field identifies the type of resource where the secret was found. */
    @SerialName(value = "type")
    val type: SecretMinusScanningMinusLocationModel.Type,
    @SerialName(value = "details")
    val details: SecretMinusScanningMinusLocationMinusCommitModel
) {

    /**
     * The location type. Because secrets may be found in different types of resources (ie. code, comments, issues), this field identifies the type of resource where the secret was found.
     * Values: commit
     */
    @Serializable(with = Type.Serializer::class)
    enum class Type(val value: kotlin.String) {
        commit("commit");

        @kotlinx.serialization.Serializer(forClass = Type::class)
        object Serializer {
            override fun deserialize(decoder: Decoder): Type {
                val decoded = decoder.decodeString()
                return values().first { it.value == decoded }
            }

            override val descriptor: SerialDescriptor
                get() = PrimitiveSerialDescriptor(
                    "SecretMinusScanningMinusLocationModel.Type.Serializer",
                    PrimitiveKind.STRING
                )

            override fun serialize(encoder: Encoder, value: Type) {
                return encoder.encodeString(value.value)
            }
        }
    }
}

