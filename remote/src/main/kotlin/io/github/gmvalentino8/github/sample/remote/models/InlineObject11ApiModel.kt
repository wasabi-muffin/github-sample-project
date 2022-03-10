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

import io.github.gmvalentino8.github.sample.remote.models.GistsFilesApiModel

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * 
 * @param files Names and content for the files that make up the gist
 * @param description Description of the gist
 * @param isPublic 
 */
@Serializable
data class InlineObject11ApiModel(
    /* Names and content for the files that make up the gist */
    @Contextual @SerialName(value = "files")
    val files: kotlin.collections.Map<kotlin.String, GistsFilesApiModel>,
    /* Description of the gist */
    @SerialName(value = "description")
    val description: kotlin.String? = null,
    @SerialName(value = "is_public")
    val isPublic: InlineObject11ApiModel.IsPublic? = IsPublic.`false`
) {

    /**
     * 
     * Values: `true`,`false`
     */
    @Serializable(with = IsPublic.Serializer::class)
    enum class IsPublic(val value: kotlin.String) {
        `true`("true"),
        `false`("false");

        @kotlinx.serialization.Serializer(forClass = IsPublic::class)
        object Serializer {
            override fun deserialize(decoder: Decoder): IsPublic {
                val decoded = decoder.decodeString()
                return values().first { it.value == decoded }
            }

            override val descriptor: SerialDescriptor
                get() = PrimitiveSerialDescriptor(
                    "InlineObject11ApiModel.IsPublic.Serializer",
                    PrimitiveKind.STRING
                )

            override fun serialize(encoder: Encoder, value: IsPublic) {
                return encoder.encodeString(value.value)
            }
        }
    }
}
