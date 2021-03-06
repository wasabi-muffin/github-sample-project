plugins {
    id(Dependencies.Plugin.androidLibrary)
    id(Dependencies.Plugin.kotlinAndroid)
    id(Dependencies.Plugin.kotlinKapt)
    id(Dependencies.Plugin.parcelize)
}

setupAndroidLibrary()

dependencies {
    projectTest(Modules.Test)

    implementation(Dependencies.Kotlinx.coroutinesCore)
}
