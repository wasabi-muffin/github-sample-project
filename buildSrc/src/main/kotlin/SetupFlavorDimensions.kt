import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension

fun BaseExtension.setupFlavorDimensions() {
    productFlavors {
        flavorDimensionList.clear()
        flavorDimensionList.addAll(Dimension.values().map { it.label })
        Flavor.values().forEach { flavor ->
            productFlavors.create(flavor.label) {
                dimension = flavor.dimension.label
                if (this is BaseAppModuleExtension && flavor.suffix != null) {
                    applicationIdSuffix = flavor.suffix
                }
            }
        }
    }
}
