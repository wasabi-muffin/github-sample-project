plugins {
    id(Dependencies.Plugin.androidApplication)
    id(Dependencies.Plugin.kotlinAndroid)
    id(Dependencies.Plugin.kotlinKapt)
    id(Dependencies.Plugin.parcelize)
    id(Dependencies.Plugin.safeArgs)
}

setupAndroid()

dependencies {
    // Projects
    project(Modules.Domain)
    project(Modules.Data)
    project(Modules.Remote)
    project(Modules.Local)

    // AndroidX
    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.constraintLayout)
    implementation(Dependencies.AndroidX.recyclerView)

    implementation(Dependencies.AndroidX.lifecycleRuntimeKtx)
    implementation(Dependencies.AndroidX.lifecycleViewmodelKtx)

    implementation(Dependencies.AndroidX.navigationFragment)
    implementation(Dependencies.AndroidX.navigationUi)

    // Android
    implementation(Dependencies.Android.material)

    // KotlinX
    implementation(Dependencies.Kotlinx.coroutinesAndroid)

    // Ktor
    implementation(Dependencies.Ktor.clientAndroid)

    // Coil
    implementation(Dependencies.Coil.core)

    // Test
    projectTest(Modules.Test)
    androidTestImplementation(Dependencies.Test.junitExt)
    androidTestImplementation(Dependencies.Test.espresso)

    // Leak
    debugImplementation(Dependencies.Leak.leakCanary)
}
