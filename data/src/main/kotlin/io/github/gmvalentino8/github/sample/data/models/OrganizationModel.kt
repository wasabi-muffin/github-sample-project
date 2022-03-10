package io.github.gmvalentino8.github.sample.data.models

/**
 * Organization Data Model
 *
 * @property id unique id for this organization
 * @property name name of this organization
 * @property username login username associated with this organization
 * @property iconUrl url for the avatar of this organization
 * @property description bio for this organization
 */
data class OrganizationModel(
    val id: Int,
    val name: String?,
    val username: String,
    val iconUrl: String?,
    val description: String?,
)
