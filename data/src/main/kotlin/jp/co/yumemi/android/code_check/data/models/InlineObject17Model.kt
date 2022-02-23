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
 * @param billingEmail Billing email address. This address is not publicized.
 * @param company The company name.
 * @param email The publicly visible email address.
 * @param twitterUsername The Twitter username of the company.
 * @param location The location.
 * @param name The shorthand name of the company.
 * @param description The description of the company.
 * @param hasOrganizationProjects Toggles whether an organization can use organization projects.
 * @param hasRepositoryProjects Toggles whether repositories that belong to the organization can use repository projects.
 * @param defaultRepositoryPermission Default permission level members have for organization repositories:   \\* `read` - can pull, but not push to or administer this repository.   \\* `write` - can pull and push, but not administer this repository.   \\* `admin` - can pull, push, and administer this repository.   \\* `none` - no permissions granted by default.
 * @param membersCanCreateRepositories Toggles the ability of non-admin organization members to create repositories. Can be one of:   \\* `true` - all organization members can create repositories.   \\* `false` - only organization owners can create repositories.   Default: `true`   **Note:** A parameter can override this parameter. See `members_allowed_repository_creation_type` in this table for details. **Note:** A parameter can override this parameter. See `members_allowed_repository_creation_type` in this table for details.
 * @param membersCanCreateInternalRepositories Toggles whether organization members can create internal repositories, which are visible to all enterprise members. You can only allow members to create internal repositories if your organization is associated with an enterprise account using GitHub Enterprise Cloud or GitHub Enterprise Server 2.20+. Can be one of:   \\* `true` - all organization members can create internal repositories.   \\* `false` - only organization owners can create internal repositories.   Default: `true`. For more information, see \"[Restricting repository creation in your organization](https://docs.github.com/github/setting-up-and-managing-organizations-and-teams/restricting-repository-creation-in-your-organization)\" in the GitHub Help documentation.
 * @param membersCanCreatePrivateRepositories Toggles whether organization members can create private repositories, which are visible to organization members with permission. Can be one of:   \\* `true` - all organization members can create private repositories.   \\* `false` - only organization owners can create private repositories.   Default: `true`. For more information, see \"[Restricting repository creation in your organization](https://docs.github.com/github/setting-up-and-managing-organizations-and-teams/restricting-repository-creation-in-your-organization)\" in the GitHub Help documentation.
 * @param membersCanCreatePublicRepositories Toggles whether organization members can create public repositories, which are visible to anyone. Can be one of:   \\* `true` - all organization members can create public repositories.   \\* `false` - only organization owners can create public repositories.   Default: `true`. For more information, see \"[Restricting repository creation in your organization](https://docs.github.com/github/setting-up-and-managing-organizations-and-teams/restricting-repository-creation-in-your-organization)\" in the GitHub Help documentation.
 * @param membersAllowedRepositoryCreationType Specifies which types of repositories non-admin organization members can create. Can be one of:   \\* `all` - all organization members can create public and private repositories.   \\* `private` - members can create private repositories. This option is only available to repositories that are part of an organization on GitHub Enterprise Cloud.   \\* `none` - only admin members can create repositories.   **Note:** This parameter is deprecated and will be removed in the future. Its return value ignores internal repositories. Using this parameter overrides values set in `members_can_create_repositories`. See the parameter deprecation notice in the operation description for details.
 * @param membersCanCreatePages Toggles whether organization members can create GitHub Pages sites. Can be one of:   \\* `true` - all organization members can create GitHub Pages sites.   \\* `false` - no organization members can create GitHub Pages sites. Existing published sites will not be impacted.
 * @param membersCanCreatePublicPages Toggles whether organization members can create public GitHub Pages sites. Can be one of:   \\* `true` - all organization members can create public GitHub Pages sites.   \\* `false` - no organization members can create public GitHub Pages sites. Existing published sites will not be impacted.
 * @param membersCanCreatePrivatePages Toggles whether organization members can create private GitHub Pages sites. Can be one of:   \\* `true` - all organization members can create private GitHub Pages sites.   \\* `false` - no organization members can create private GitHub Pages sites. Existing published sites will not be impacted.
 * @param membersCanForkPrivateRepositories Toggles whether organization members can fork private organization repositories. Can be one of:   \\* `true` - all organization members can fork private repositories within the organization.   \\* `false` - no organization members can fork private repositories within the organization.
 * @param blog 
 */
@Serializable
data class InlineObject17Model(
    /* Billing email address. This address is not publicized. */
    @SerialName(value = "billing_email")
    val billingEmail: kotlin.String? = null,
    /* The company name. */
    @SerialName(value = "company")
    val company: kotlin.String? = null,
    /* The publicly visible email address. */
    @SerialName(value = "email")
    val email: kotlin.String? = null,
    /* The Twitter username of the company. */
    @SerialName(value = "twitter_username")
    val twitterUsername: kotlin.String? = null,
    /* The location. */
    @SerialName(value = "location")
    val location: kotlin.String? = null,
    /* The shorthand name of the company. */
    @SerialName(value = "name")
    val name: kotlin.String? = null,
    /* The description of the company. */
    @SerialName(value = "description")
    val description: kotlin.String? = null,
    /* Toggles whether an organization can use organization projects. */
    @SerialName(value = "has_organization_projects")
    val hasOrganizationProjects: kotlin.Boolean? = null,
    /* Toggles whether repositories that belong to the organization can use repository projects. */
    @SerialName(value = "has_repository_projects")
    val hasRepositoryProjects: kotlin.Boolean? = null,
    /* Default permission level members have for organization repositories:   \\* `read` - can pull, but not push to or administer this repository.   \\* `write` - can pull and push, but not administer this repository.   \\* `admin` - can pull, push, and administer this repository.   \\* `none` - no permissions granted by default. */
    @SerialName(value = "default_repository_permission")
    val defaultRepositoryPermission: InlineObject17Model.DefaultRepositoryPermission? = DefaultRepositoryPermission.read,
    /* Toggles the ability of non-admin organization members to create repositories. Can be one of:   \\* `true` - all organization members can create repositories.   \\* `false` - only organization owners can create repositories.   Default: `true`   **Note:** A parameter can override this parameter. See `members_allowed_repository_creation_type` in this table for details. **Note:** A parameter can override this parameter. See `members_allowed_repository_creation_type` in this table for details. */
    @SerialName(value = "members_can_create_repositories")
    val membersCanCreateRepositories: kotlin.Boolean? = true,
    /* Toggles whether organization members can create internal repositories, which are visible to all enterprise members. You can only allow members to create internal repositories if your organization is associated with an enterprise account using GitHub Enterprise Cloud or GitHub Enterprise Server 2.20+. Can be one of:   \\* `true` - all organization members can create internal repositories.   \\* `false` - only organization owners can create internal repositories.   Default: `true`. For more information, see \"[Restricting repository creation in your organization](https://docs.github.com/github/setting-up-and-managing-organizations-and-teams/restricting-repository-creation-in-your-organization)\" in the GitHub Help documentation. */
    @SerialName(value = "members_can_create_internal_repositories")
    val membersCanCreateInternalRepositories: kotlin.Boolean? = null,
    /* Toggles whether organization members can create private repositories, which are visible to organization members with permission. Can be one of:   \\* `true` - all organization members can create private repositories.   \\* `false` - only organization owners can create private repositories.   Default: `true`. For more information, see \"[Restricting repository creation in your organization](https://docs.github.com/github/setting-up-and-managing-organizations-and-teams/restricting-repository-creation-in-your-organization)\" in the GitHub Help documentation. */
    @SerialName(value = "members_can_create_private_repositories")
    val membersCanCreatePrivateRepositories: kotlin.Boolean? = null,
    /* Toggles whether organization members can create public repositories, which are visible to anyone. Can be one of:   \\* `true` - all organization members can create public repositories.   \\* `false` - only organization owners can create public repositories.   Default: `true`. For more information, see \"[Restricting repository creation in your organization](https://docs.github.com/github/setting-up-and-managing-organizations-and-teams/restricting-repository-creation-in-your-organization)\" in the GitHub Help documentation. */
    @SerialName(value = "members_can_create_public_repositories")
    val membersCanCreatePublicRepositories: kotlin.Boolean? = null,
    /* Specifies which types of repositories non-admin organization members can create. Can be one of:   \\* `all` - all organization members can create public and private repositories.   \\* `private` - members can create private repositories. This option is only available to repositories that are part of an organization on GitHub Enterprise Cloud.   \\* `none` - only admin members can create repositories.   **Note:** This parameter is deprecated and will be removed in the future. Its return value ignores internal repositories. Using this parameter overrides values set in `members_can_create_repositories`. See the parameter deprecation notice in the operation description for details. */
    @SerialName(value = "members_allowed_repository_creation_type")
    val membersAllowedRepositoryCreationType: InlineObject17Model.MembersAllowedRepositoryCreationType? = null,
    /* Toggles whether organization members can create GitHub Pages sites. Can be one of:   \\* `true` - all organization members can create GitHub Pages sites.   \\* `false` - no organization members can create GitHub Pages sites. Existing published sites will not be impacted. */
    @SerialName(value = "members_can_create_pages")
    val membersCanCreatePages: kotlin.Boolean? = true,
    /* Toggles whether organization members can create public GitHub Pages sites. Can be one of:   \\* `true` - all organization members can create public GitHub Pages sites.   \\* `false` - no organization members can create public GitHub Pages sites. Existing published sites will not be impacted. */
    @SerialName(value = "members_can_create_public_pages")
    val membersCanCreatePublicPages: kotlin.Boolean? = true,
    /* Toggles whether organization members can create private GitHub Pages sites. Can be one of:   \\* `true` - all organization members can create private GitHub Pages sites.   \\* `false` - no organization members can create private GitHub Pages sites. Existing published sites will not be impacted. */
    @SerialName(value = "members_can_create_private_pages")
    val membersCanCreatePrivatePages: kotlin.Boolean? = true,
    /* Toggles whether organization members can fork private organization repositories. Can be one of:   \\* `true` - all organization members can fork private repositories within the organization.   \\* `false` - no organization members can fork private repositories within the organization. */
    @SerialName(value = "members_can_fork_private_repositories")
    val membersCanForkPrivateRepositories: kotlin.Boolean? = false,
    @SerialName(value = "blog")
    val blog: kotlin.String? = null
) {

    /**
     * Default permission level members have for organization repositories:   \\* `read` - can pull, but not push to or administer this repository.   \\* `write` - can pull and push, but not administer this repository.   \\* `admin` - can pull, push, and administer this repository.   \\* `none` - no permissions granted by default.
     * Values: read,write,admin,none
     */
    @Serializable(with = DefaultRepositoryPermission.Serializer::class)
    enum class DefaultRepositoryPermission(val value: kotlin.String) {
        read("read"),
        write("write"),
        admin("admin"),
        none("none");

        @kotlinx.serialization.Serializer(forClass = DefaultRepositoryPermission::class)
        object Serializer {
            override fun deserialize(decoder: Decoder): DefaultRepositoryPermission {
                val decoded = decoder.decodeString()
                return values().first { it.value == decoded }
            }

            override val descriptor: SerialDescriptor
                get() = PrimitiveSerialDescriptor(
                    "InlineObject17Model.DefaultRepositoryPermission.Serializer",
                    PrimitiveKind.STRING
                )

            override fun serialize(encoder: Encoder, value: DefaultRepositoryPermission) {
                return encoder.encodeString(value.value)
            }
        }
    }
    /**
     * Specifies which types of repositories non-admin organization members can create. Can be one of:   \\* `all` - all organization members can create public and private repositories.   \\* `private` - members can create private repositories. This option is only available to repositories that are part of an organization on GitHub Enterprise Cloud.   \\* `none` - only admin members can create repositories.   **Note:** This parameter is deprecated and will be removed in the future. Its return value ignores internal repositories. Using this parameter overrides values set in `members_can_create_repositories`. See the parameter deprecation notice in the operation description for details.
     * Values: all,`private`,none
     */
    @Serializable(with = MembersAllowedRepositoryCreationType.Serializer::class)
    enum class MembersAllowedRepositoryCreationType(val value: kotlin.String) {
        all("all"),
        `private`("private"),
        none("none");

        @kotlinx.serialization.Serializer(forClass = MembersAllowedRepositoryCreationType::class)
        object Serializer {
            override fun deserialize(decoder: Decoder): MembersAllowedRepositoryCreationType {
                val decoded = decoder.decodeString()
                return values().first { it.value == decoded }
            }

            override val descriptor: SerialDescriptor
                get() = PrimitiveSerialDescriptor(
                    "InlineObject17Model.MembersAllowedRepositoryCreationType.Serializer",
                    PrimitiveKind.STRING
                )

            override fun serialize(encoder: Encoder, value: MembersAllowedRepositoryCreationType) {
                return encoder.encodeString(value.value)
            }
        }
    }
}

