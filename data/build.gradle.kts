plugins {
    id(Dependencies.Plugin.androidLibrary)
    id(Dependencies.Plugin.kotlinAndroid)
    id(Dependencies.Plugin.kotlinKapt)
    id(Dependencies.Plugin.serialization)
}

setupAndroid()

dependencies {
    project(Modules.Domain)
    projectTest(Modules.Test)

    implementation(Dependencies.Kotlinx.serializationJson)
}
