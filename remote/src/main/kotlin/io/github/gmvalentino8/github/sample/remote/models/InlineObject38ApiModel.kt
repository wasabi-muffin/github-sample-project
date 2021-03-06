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
 * 
 * @param name The name of the team.
 * @param description The description of the team.
 * @param privacy The level of privacy this team should have. Editing teams without specifying this parameter leaves `privacy` intact. When a team is nested, the `privacy` for parent teams cannot be `secret`. The options are:   **For a non-nested team:**   \\* `secret` - only visible to organization owners and members of this team.   \\* `closed` - visible to all members of this organization.   **For a parent or child team:**   \\* `closed` - visible to all members of this organization.
 * @param permission **Deprecated**. The permission that new repositories will be added to the team with when none is specified. Can be one of:   \\* `pull` - team members can pull, but not push to or administer newly-added repositories.   \\* `push` - team members can pull and push, but not administer newly-added repositories.   \\* `admin` - team members can pull, push and administer newly-added repositories.
 * @param parentTeamId The ID of a team to set as the parent team.
 */
@Serializable
data class InlineObject38ApiModel(
    /* The name of the team. */
    @SerialName(value = "name")
    val name: kotlin.String? = null,
    /* The description of the team. */
    @SerialName(value = "description")
    val description: kotlin.String? = null,
    /* The level of privacy this team should have. Editing teams without specifying this parameter leaves `privacy` intact. When a team is nested, the `privacy` for parent teams cannot be `secret`. The options are:   **For a non-nested team:**   \\* `secret` - only visible to organization owners and members of this team.   \\* `closed` - visible to all members of this organization.   **For a parent or child team:**   \\* `closed` - visible to all members of this organization. */
    @SerialName(value = "privacy")
    val privacy: InlineObject38ApiModel.Privacy? = null,
    /* **Deprecated**. The permission that new repositories will be added to the team with when none is specified. Can be one of:   \\* `pull` - team members can pull, but not push to or administer newly-added repositories.   \\* `push` - team members can pull and push, but not administer newly-added repositories.   \\* `admin` - team members can pull, push and administer newly-added repositories. */
    @SerialName(value = "permission")
    val permission: InlineObject38ApiModel.Permission? = Permission.pull,
    /* The ID of a team to set as the parent team. */
    @SerialName(value = "parent_team_id")
    val parentTeamId: kotlin.Int? = null
) {

    /**
     * The level of privacy this team should have. Editing teams without specifying this parameter leaves `privacy` intact. When a team is nested, the `privacy` for parent teams cannot be `secret`. The options are:   **For a non-nested team:**   \\* `secret` - only visible to organization owners and members of this team.   \\* `closed` - visible to all members of this organization.   **For a parent or child team:**   \\* `closed` - visible to all members of this organization.
     * Values: secret,closed
     */
    @Serializable(with = Privacy.Serializer::class)
    enum class Privacy(val value: kotlin.String) {
        secret("secret"),
        closed("closed");

        @kotlinx.serialization.Serializer(forClass = Privacy::class)
        object Serializer {
            override fun deserialize(decoder: Decoder): Privacy {
                val decoded = decoder.decodeString()
                return values().first { it.value == decoded }
            }

            override val descriptor: SerialDescriptor
                get() = PrimitiveSerialDescriptor(
                    "InlineObject38ApiModel.Privacy.Serializer",
                    PrimitiveKind.STRING
                )

            override fun serialize(encoder: Encoder, value: Privacy) {
                return encoder.encodeString(value.value)
            }
        }
    }
    /**
     * **Deprecated**. The permission that new repositories will be added to the team with when none is specified. Can be one of:   \\* `pull` - team members can pull, but not push to or administer newly-added repositories.   \\* `push` - team members can pull and push, but not administer newly-added repositories.   \\* `admin` - team members can pull, push and administer newly-added repositories.
     * Values: pull,push,admin
     */
    @Serializable(with = Permission.Serializer::class)
    enum class Permission(val value: kotlin.String) {
        pull("pull"),
        push("push"),
        admin("admin");

        @kotlinx.serialization.Serializer(forClass = Permission::class)
        object Serializer {
            override fun deserialize(decoder: Decoder): Permission {
                val decoded = decoder.decodeString()
                return values().first { it.value == decoded }
            }

            override val descriptor: SerialDescriptor
                get() = PrimitiveSerialDescriptor(
                    "InlineObject38ApiModel.Permission.Serializer",
                    PrimitiveKind.STRING
                )

            override fun serialize(encoder: Encoder, value: Permission) {
                return encoder.encodeString(value.value)
            }
        }
    }
}

