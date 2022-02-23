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
 * @param commitTitle Title for the automatic commit message.
 * @param commitMessage Extra detail to append to automatic commit message.
 * @param sha SHA that pull request head must match to allow merge.
 * @param mergeMethod Merge method to use. Possible values are `merge`, `squash` or `rebase`. Default is `merge`.
 */
@Serializable
data class InlineObject124Model(
    /* Title for the automatic commit message. */
    @SerialName(value = "commit_title")
    val commitTitle: kotlin.String? = null,
    /* Extra detail to append to automatic commit message. */
    @SerialName(value = "commit_message")
    val commitMessage: kotlin.String? = null,
    /* SHA that pull request head must match to allow merge. */
    @SerialName(value = "sha")
    val sha: kotlin.String? = null,
    /* Merge method to use. Possible values are `merge`, `squash` or `rebase`. Default is `merge`. */
    @SerialName(value = "merge_method")
    val mergeMethod: InlineObject124Model.MergeMethod? = null
) {

    /**
     * Merge method to use. Possible values are `merge`, `squash` or `rebase`. Default is `merge`.
     * Values: merge,squash,rebase
     */
    @Serializable(with = MergeMethod.Serializer::class)
    enum class MergeMethod(val value: kotlin.String) {
        merge("merge"),
        squash("squash"),
        rebase("rebase");

        @kotlinx.serialization.Serializer(forClass = MergeMethod::class)
        object Serializer {
            override fun deserialize(decoder: Decoder): MergeMethod {
                val decoded = decoder.decodeString()
                return values().first { it.value == decoded }
            }

            override val descriptor: SerialDescriptor
                get() = PrimitiveSerialDescriptor(
                    "InlineObject124Model.MergeMethod.Serializer",
                    PrimitiveKind.STRING
                )

            override fun serialize(encoder: Encoder, value: MergeMethod) {
                return encoder.encodeString(value.value)
            }
        }
    }
}

