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
    const val kotlin = "1.6.10"
    const val gradle = "7.0.3"
    const val kotlinCoroutines = "1.5.2"
    const val datetime = "0.3.2"

    // Tests
    const val testCore = "1.4.0"
    const val junit = "4.13.2"
    const val junitExt = "1.1.3"
    const val espresso = "3.4.0"
    const val roboelectric = "4.6.1"
    const val turbine = "0.7.0"
    const val mockk = "1.12.2"
    const val kotest = "5.1.0"

    // Android
    const val material = "1.4.0"
    const val coreKtx = "1.6.0"
    const val appCompat = "1.3.1"
    const val lifecycle = "2.4.1"
    const val navigation = "2.3.5"

    // Jetpack Compose
    const val compose = "1.2.0-alpha04"
    const val accompanist = "0.24.2-alpha"

    // Hilt
    const val hilt = "2.38.1"

    // Serialization
    const val serialization = "1.3.2"

    // Ktor
    const val ktor = "1.6.4"

    // Room
    const val room = "2.4.1"

    // Coil
    const val coil = "1.4.0"

    // Lint
    const val ktLint = "10.2.1"

    // Leaks
    const val leakCanary = "2.8.1"

    // Documentation
    const val dokka = "1.6.10"
}

object Dependencies {
    object Gradle {
        const val android = "com.android.tools.build:gradle:${Versions.gradle}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
        const val serialization = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
        const val ktlint = "org.jlleitschuh.gradle:ktlint-gradle:${Versions.ktLint}"
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    }

    object Plugin {
        const val androidApplication = "com.android.application"
        const val androidLibrary = "com.android.library"
        const val kotlinAndroid = "kotlin-android"
        const val kotlinKapt = "kotlin-kapt"
        const val parcelize = "kotlin-parcelize"
        const val safeArgs = "androidx.navigation.safeargs.kotlin"
        const val ktlint = "org.jlleitschuh.gradle.ktlint"
        const val kover = "org.jetbrains.kotlinx.kover"
        const val dokka = "org.jetbrains.dokka"
        const val serialization = "kotlinx-serialization"
        const val hilt = "dagger.hilt.android.plugin"
    }

    object Kotlinx {
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
        const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}"
        const val datetime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.datetime}"
    }

    object Android {
        const val material = "com.google.android.material:material:${Versions.material}"
    }

    object AndroidX {
        const val core = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val lifecycleSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycle}"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    object Compose {
        const val runtime = "androidx.compose.runtime:runtime:${Versions.compose}"
        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
        const val uiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
        const val foundationLayout = "androidx.compose.foundation:foundation-layout:${Versions.compose}"
        const val material = "androidx.compose.material:material:${Versions.compose}"
    }

    object Accompanist {
        const val swipeRefresh = "com.google.accompanist:accompanist-swiperefresh:${Versions.accompanist}"
    }

    object Hilt {
        const val android = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Versions.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.room}"
        const val coroutines = "androidx.room:room-ktx:${Versions.room}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.junit}"
        const val core = "androidx.test:core-ktx:${Versions.testCore}"
        const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutines}"
        const val roboelectric = "org.robolectric:robolectric:${Versions.roboelectric}"
        const val turbine = "app.cash.turbine:turbine:${Versions.turbine}"
        const val mockk = "io.mockk:mockk:${Versions.mockk}"
        const val kotest = "io.kotest:kotest-assertions-core:${Versions.kotest}"
        const val compose = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    }

    object Ktor {
        const val clientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
        const val clientAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
        const val clientJson = "io.ktor:ktor-client-json:${Versions.ktor}"
        const val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
        const val clientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
    }

    object Coil {
        const val core = "io.coil-kt:coil:${Versions.coil}"
        const val compose = "io.coil-kt:coil-compose:${Versions.coil}"
    }

    object Leak {
        const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
    }
}
