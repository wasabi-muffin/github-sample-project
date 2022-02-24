plugins {
    id(Dependencies.Plugin.androidLibrary)
    id(Dependencies.Plugin.kotlinAndroid)
    id(Dependencies.Plugin.kotlinKapt)
    id(Dependencies.Plugin.parcelize)
}

setupAndroid()
setupJetpackCompose()

dependencies {
    project(Modules.Presentation)
    project(Modules.Domain)
    projectTest(Modules.Test)

    implementation(Dependencies.Kotlinx.coroutinesCore)
    implementation(Dependencies.Kotlinx.coroutinesAndroid)
    implementation(Dependencies.Compose.runtime)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.uiGraphics)
    implementation(Dependencies.Compose.uiTooling)
    implementation(Dependencies.Compose.uiToolingPreview)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.foundation)
    implementation(Dependencies.Compose.foundationLayout)
}
