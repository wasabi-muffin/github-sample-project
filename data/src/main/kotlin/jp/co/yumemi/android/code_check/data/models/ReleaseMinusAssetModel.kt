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

import jp.co.yumemi.android.code_check.data.models.NullableMinusSimpleMinusUserModel

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * Data related to a release.
 * @param url 
 * @param browserDownloadUrl 
 * @param id 
 * @param nodeId 
 * @param name The file name of the asset.
 * @param label 
 * @param state State of the release asset.
 * @param contentType 
 * @param propertySize 
 * @param downloadCount 
 * @param createdAt 
 * @param updatedAt 
 * @param uploader 
 */
@Serializable
data class ReleaseMinusAssetModel(
    @SerialName(value = "url")
    val url: kotlin.String,
    @SerialName(value = "browser_download_url")
    val browserDownloadUrl: kotlin.String,
    @SerialName(value = "id")
    val id: kotlin.Int,
    @SerialName(value = "node_id")
    val nodeId: kotlin.String,
    /* The file name of the asset. */
    @SerialName(value = "name")
    val name: kotlin.String,
    @SerialName(value = "label")
    val label: kotlin.String?,
    /* State of the release asset. */
    @SerialName(value = "state")
    val state: ReleaseMinusAssetModel.State,
    @SerialName(value = "content_type")
    val contentType: kotlin.String,
    @SerialName(value = "size")
    val propertySize: kotlin.Int,
    @SerialName(value = "download_count")
    val downloadCount: kotlin.Int,
    @SerialName(value = "created_at")
    val createdAt: kotlin.String,
    @SerialName(value = "updated_at")
    val updatedAt: kotlin.String,
    @SerialName(value = "uploader")
    val uploader: NullableMinusSimpleMinusUserModel?
) {

    /**
     * State of the release asset.
     * Values: uploaded,`open`
     */
    @Serializable(with = State.Serializer::class)
    enum class State(val value: kotlin.String) {
        uploaded("uploaded"),
        `open`("open");

        @kotlinx.serialization.Serializer(forClass = State::class)
        object Serializer {
            override fun deserialize(decoder: Decoder): State {
                val decoded = decoder.decodeString()
                return values().first { it.value == decoded }
            }

            override val descriptor: SerialDescriptor
                get() = PrimitiveSerialDescriptor(
                    "ReleaseMinusAssetModel.State.Serializer",
                    PrimitiveKind.STRING
                )

            override fun serialize(encoder: Encoder, value: State) {
                return encoder.encodeString(value.value)
            }
        }
    }
}

