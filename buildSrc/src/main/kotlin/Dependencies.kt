object Versions {
    object Config {
        const val androidVersionCode = 1
        const val androidVersionName = "1.0"

        const val androidMinSdk = 23
        const val androidCompileSdk = 31
        const val androidTargetSdk = 31
        const val buildToolsVersion = "31.0.0"

        const val jvmTarget = "11"
    }

    // Kotlin
    const val kotlin = "1.5.31"
    const val gradle = "7.0.3"
    const val kotlinCoroutines = "1.5.2"

    // Tests
    const val junit = "4.13.2"
    const val junitExt = "1.1.3"
    const val espresso = "3.4.0"

    // Android
    const val material = "1.4.0"
    const val coreKtx = "1.6.0"
    const val appCompat = "1.3.1"
    const val constraintLayout = "2.1.1"
    const val recyclerView = "1.2.1"
    const val lifecycleKtx = "2.3.1"
    const val navigation = "2.3.5"

    // Ktor
    const val ktor = "1.6.4"

    // Coil
    const val coil = "1.3.2"

    // Lint
    const val ktLint = "10.2.1"

    // Test Coverage
    const val kover = "0.5.0"
}

object Dependencies {
    object Gradle {
        const val android = "com.android.tools.build:gradle:${Versions.gradle}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    }

    object Plugin {
        const val androidApplication = "com.android.application"
        const val kotlinAndroid = "kotlin-android"
        const val kotlinKapt = "kotlin-kapt"
        const val parcelize = "kotlin-parcelize"
        const val safeArgs = "androidx.navigation.safeargs.kotlin"
        const val ktlint = "org.jlleitschuh.gradle.ktlint"
        const val kover = "org.jetbrains.kotlinx.kover"
    }

    object Kotlinx {
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
    }

    object Android {
        const val material = "com.google.android.material:material:${Versions.material}"
    }

    object AndroidX {
        const val core = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleKtx}"
        const val lifecycleViewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleKtx}"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.junit}"
        const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    }

    object Ktor {
        const val clientAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
    }

    object Coil {
        const val core = "io.coil-kt:coil:${Versions.coil}"
    }
}
