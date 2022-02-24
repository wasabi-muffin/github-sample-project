plugins {
    id(Dependencies.Plugin.androidApplication)
    id(Dependencies.Plugin.kotlinAndroid)
    id(Dependencies.Plugin.kotlinKapt)
    id(Dependencies.Plugin.parcelize)
    id(Dependencies.Plugin.safeArgs)
    id(Dependencies.Plugin.hilt)
}

setupAndroid()
setupJetpackCompose()

dependencies {
    // Projects
    project(Modules.Ui)
    project(Modules.Presentation)
    project(Modules.Domain)
    project(Modules.Data)
    project(Modules.Remote)
    project(Modules.Local)

    // AndroidX
    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.constraintLayout)
    implementation(Dependencies.AndroidX.recyclerView)
    implementation(Dependencies.AndroidX.lifecycleRuntime)
    implementation(Dependencies.AndroidX.lifecycleViewModel)
    implementation(Dependencies.AndroidX.lifecycleSavedState)

    implementation(Dependencies.AndroidX.navigationFragment)
    implementation(Dependencies.AndroidX.navigationUi)

    implementation(Dependencies.Compose.ui)

    // Android
    implementation(Dependencies.Android.material)

    // Hilt
    implementation(Dependencies.Hilt.android)
    kapt(Dependencies.Hilt.compiler)

    // KotlinX
    implementation(Dependencies.Kotlinx.coroutinesAndroid)

    // Ktor
    implementation(Dependencies.Ktor.clientAndroid)

    // Room
    implementation(Dependencies.Room.runtime)
    kapt(Dependencies.Room.compiler)

    // Coil
    implementation(Dependencies.Coil.core)

    // Test
    projectTest(Modules.Test)
    androidTestImplementation(Dependencies.Test.junitExt)
    androidTestImplementation(Dependencies.Test.espresso)

    // Leak
    debugImplementation(Dependencies.Leak.leakCanary)
}
