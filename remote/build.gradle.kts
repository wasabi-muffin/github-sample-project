plugins {
    id(Dependencies.Plugin.androidLibrary)
    id(Dependencies.Plugin.kotlinAndroid)
    id(Dependencies.Plugin.serialization)
}

setupAndroid()

dependencies {
    project(Modules.Data)
    projectTest(Modules.Test)

    implementation(Dependencies.Kotlinx.serializationJson)
    implementation(Dependencies.Ktor.clientCore)
    implementation(Dependencies.Ktor.clientAndroid)
    implementation(Dependencies.Ktor.clientJson)
    implementation(Dependencies.Ktor.clientLogging)
    implementation(Dependencies.Ktor.clientSerialization)
}
