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
 * @param content The [reaction type](https://docs.github.com/rest/reference/reactions#reaction-types) to add to the release.
 */
@Serializable
data class InlineObject134Model(
    /* The [reaction type](https://docs.github.com/rest/reference/reactions#reaction-types) to add to the release. */
    @SerialName(value = "content")
    val content: InlineObject134Model.Content
) {

    /**
     * The [reaction type](https://docs.github.com/rest/reference/reactions#reaction-types) to add to the release.
     * Values: plus1,laugh,heart,hooray,rocket,eyes
     */
    @Serializable(with = Content.Serializer::class)
    enum class Content(val value: kotlin.String) {
        plus1("+1"),
        laugh("laugh"),
        heart("heart"),
        hooray("hooray"),
        rocket("rocket"),
        eyes("eyes");

        @kotlinx.serialization.Serializer(forClass = Content::class)
        object Serializer {
            override fun deserialize(decoder: Decoder): Content {
                val decoded = decoder.decodeString()
                return values().first { it.value == decoded }
            }

            override val descriptor: SerialDescriptor
                get() = PrimitiveSerialDescriptor(
                    "InlineObject134Model.Content.Serializer",
                    PrimitiveKind.STRING
                )

            override fun serialize(encoder: Encoder, value: Content) {
                return encoder.encodeString(value.value)
            }
        }
    }
}
