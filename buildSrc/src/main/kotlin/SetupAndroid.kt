
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun Project.setupAndroid() {
    extensions.findByType(BaseExtension::class.java)?.apply {
        compileSdkVersion(Versions.Config.androidCompileSdk)
        buildToolsVersion(Versions.Config.buildToolsVersion)
        defaultConfig {
            applicationId = "jp.co.yumemi.android.codecheck"
            minSdk = Versions.Config.androidMinSdk
            targetSdk = Versions.Config.androidTargetSdk
            versionCode = Versions.Config.androidVersionCode
            versionName = Versions.Config.androidVersionName
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        setupAndroidApp()

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }
    }
}

private fun Project.setupAndroidApp() {
    extensions.findByType(BaseAppModuleExtension::class.java)?.apply {
        buildFeatures {
            viewBinding = true
        }
    }
}