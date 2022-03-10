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


import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * A GitHub Actions workflow
 * @param id 
 * @param nodeId 
 * @param name 
 * @param path 
 * @param state 
 * @param createdAt 
 * @param updatedAt 
 * @param url 
 * @param htmlUrl 
 * @param badgeUrl 
 * @param deletedAt 
 */
@Serializable
data class WorkflowApiModel(
    @SerialName(value = "id")
    val id: kotlin.Int,
    @SerialName(value = "node_id")
    val nodeId: kotlin.String,
    @SerialName(value = "name")
    val name: kotlin.String,
    @SerialName(value = "path")
    val path: kotlin.String,
    @SerialName(value = "state")
    val state: WorkflowApiModel.State,
    @SerialName(value = "created_at")
    val createdAt: kotlin.String,
    @SerialName(value = "updated_at")
    val updatedAt: kotlin.String,
    @SerialName(value = "url")
    val url: kotlin.String,
    @SerialName(value = "html_url")
    val htmlUrl: kotlin.String,
    @SerialName(value = "badge_url")
    val badgeUrl: kotlin.String,
    @SerialName(value = "deleted_at")
    val deletedAt: kotlin.String? = null
) {

    /**
     * 
     * Values: active,deleted,disabledFork,disabledInactivity,disabledManually
     */
    @Serializable(with = State.Serializer::class)
    enum class State(val value: kotlin.String) {
        active("active"),
        deleted("deleted"),
        disabledFork("disabled_fork"),
        disabledInactivity("disabled_inactivity"),
        disabledManually("disabled_manually");

        @kotlinx.serialization.Serializer(forClass = State::class)
        object Serializer {
            override fun deserialize(decoder: Decoder): State {
                val decoded = decoder.decodeString()
                return values().first { it.value == decoded }
            }

            override val descriptor: SerialDescriptor
                get() = PrimitiveSerialDescriptor(
                    "WorkflowApiModel.State.Serializer",
                    PrimitiveKind.STRING
                )

            override fun serialize(encoder: Encoder, value: State) {
                return encoder.encodeString(value.value)
            }
        }
    }
}
