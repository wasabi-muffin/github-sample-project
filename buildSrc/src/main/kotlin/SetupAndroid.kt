import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun Project.setupAndroidApp(
    additionalConfig: BaseAppModuleExtension.() -> Unit = {}
) {
    setupAndroidCore()
    extensions.findByType(BaseAppModuleExtension::class.java)?.apply {
        defaultConfig {
            applicationId = "jp.co.yumemi.android.codecheck"
        }

        buildTypes {
            getByName("release") {
                isMinifyEnabled = true
                proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            }
        }

        buildFeatures {
            viewBinding = true
        }

        additionalConfig()
    }
}

fun Project.setupAndroidLibrary(
    additionalConfig: LibraryExtension.() -> Unit = {}
) {
    setupAndroidCore()
    extensions.findByType(LibraryExtension::class.java)?.apply {
        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
            }
        }

        additionalConfig()
    }
}

private fun Project.setupAndroidCore() {
    plugins.apply(Dependencies.Plugin.dokka)

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

        sourceSets.all {
            java.srcDir("src/$name/kotlin")
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

        tasks.withType(KotlinCompile::class.java) {
            kotlinOptions {
                jvmTarget = Versions.Config.jvmTarget
            }
        }

    }

    setupLinter()
    setupTestCoverage()
    setupFlavorDimensions()
}
