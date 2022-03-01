import com.android.build.api.variant.VariantFilter
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Project

fun Project.setupFlavorDimensions() {
    extensions.findByType(BaseExtension::class.java)?.apply {
        productFlavors {
            flavorDimensionList.clear()
            flavorDimensionList.addAll(Dimension.values().map { it.label })
            Flavor.values().forEach { flavor ->
                productFlavors.create(flavor.label) {
                    dimension = flavor.dimension.label
                    if (flavor.suffix != null) {
                        extensions.findByType(BaseAppModuleExtension::class.java)?.run {
                            applicationIdSuffix = flavor.suffix
                        }
                    }
                }
            }
        }
        variantFilter {
            ignore(
                VariantFilterSetting(name = "debug", Flavor.Prd),
                VariantFilterSetting(name = "release", Flavor.Mock, Flavor.Dev),
            )
        }
    }
}

private class VariantFilterSetting(val name: String, vararg val flavors: Flavor)

private fun VariantFilter.ignore(vararg settings: VariantFilterSetting) {
    ignore = settings.any { filter ->
        buildType.name == filter.name && filter.flavors.any { flavor ->
            filter.flavors.contains(Flavor.fromLabel(this.flavors[flavor.index].name))
        }
    }
}
