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

import io.github.gmvalentino8.github.sample.remote.models.ContainerMetadataApiModel
import io.github.gmvalentino8.github.sample.remote.models.DockerMetadataApiModel

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * 
 * @param packageType 
 * @param container 
 * @param docker 
 */
@Serializable
data class PackageVersionMetadataApiModel(
    @SerialName(value = "package_type")
    val packageType: PackageVersionMetadataApiModel.PackageType,
    @SerialName(value = "container")
    val container: ContainerMetadataApiModel? = null,
    @SerialName(value = "docker")
    val docker: DockerMetadataApiModel? = null
) {

    /**
     * 
     * Values: npm,maven,rubygems,docker,nuget,container
     */
    @Serializable(with = PackageType.Serializer::class)
    enum class PackageType(val value: kotlin.String) {
        npm("npm"),
        maven("maven"),
        rubygems("rubygems"),
        docker("docker"),
        nuget("nuget"),
        container("container");

        @kotlinx.serialization.Serializer(forClass = PackageType::class)
        object Serializer {
            override fun deserialize(decoder: Decoder): PackageType {
                val decoded = decoder.decodeString()
                return values().first { it.value == decoded }
            }

            override val descriptor: SerialDescriptor
                get() = PrimitiveSerialDescriptor(
                    "PackageVersionMetadataApiModel.PackageType.Serializer",
                    PrimitiveKind.STRING
                )

            override fun serialize(encoder: Encoder, value: PackageType) {
                return encoder.encodeString(value.value)
            }
        }
    }
}
