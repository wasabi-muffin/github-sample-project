plugins {
    id(Dependencies.Plugin.androidLibrary)
    id(Dependencies.Plugin.kotlinAndroid)
    id(Dependencies.Plugin.kotlinKapt)
    id(Dependencies.Plugin.parcelize)
    id(Dependencies.Plugin.hilt)
}

setupAndroid()
setupJetpackCompose()

dependencies {
    project(Modules.Presentation)
    project(Modules.Domain)
    projectTest(Modules.Test)

    implementation(Dependencies.Kotlinx.coroutinesCore)
    implementation(Dependencies.Kotlinx.coroutinesAndroid)
    implementation(Dependencies.AndroidX.lifecycleViewModel)
    implementation(Dependencies.AndroidX.lifecycleSavedState)
    implementation(Dependencies.Compose.runtime)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.uiGraphics)
    implementation(Dependencies.Compose.uiTooling)
    implementation(Dependencies.Compose.uiToolingPreview)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.foundation)
    implementation(Dependencies.Compose.foundationLayout)
    implementation(Dependencies.Hilt.android)
    kapt(Dependencies.Hilt.compiler)
}
