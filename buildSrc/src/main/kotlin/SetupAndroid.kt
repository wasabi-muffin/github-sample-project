import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project

fun Project.setupAndroid() {
    extensions.findByType(BaseExtension::class.java)?.apply {
        compileSdkVersion(Versions.Config.androidCompileSdk)
        buildToolsVersion(Versions.Config.buildToolsVersion)
        defaultConfig {
            minSdk = Versions.Config.androidMinSdk
            targetSdk = Versions.Config.androidTargetSdk
            versionCode = Versions.Config.androidVersionCode
            versionName = Versions.Config.androidVersionName
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }

        buildTypes {
            getByName("release") {
                isMinifyEnabled = true
                proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            }
        }

        lintOptions {
            isCheckDependencies = true
            xmlReport = true
            htmlReport = true
            isAbortOnError = false
            disable.plusAssign(
                setOf(
                    "UnsafeExperimentalUsageError",
                    "UnsafeExperimentalUsageWarning",
                    "FragmentBackPressedCallback",
                    "FragmentLiveDataObserve",
                    "WebViewApiAvailability",
                    "InlinedApi",
                    "ObsoleteSdkInt",
                    "Override",
                    "NewApi",
                    "UnusedAttribute"
                )
            )
        }

        setupFlavorDimensions()
    }

    setupAndroidApp()
}

private fun Project.setupAndroidApp() {
    extensions.findByType(BaseAppModuleExtension::class.java)?.apply {
        defaultConfig {
            applicationId = "jp.co.yumemi.android.codecheck"
        }

        buildFeatures {
            viewBinding = true
        }
    }
}
