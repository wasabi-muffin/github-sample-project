plugins {
    id(Dependencies.Plugin.androidApplication)
    id(Dependencies.Plugin.kotlinAndroid)
    id(Dependencies.Plugin.kotlinKapt)
    id(Dependencies.Plugin.parcelize)
    id(Dependencies.Plugin.safeArgs)
    id(Dependencies.Plugin.hilt)
}

setupAndroidApp {
    defaultConfig {
        signingConfig = signingConfigs.getByName("debug")
    }
}

dependencies {
    project(Modules.Ui)
    project(Modules.Presentation)
    project(Modules.Domain)
    project(Modules.Data)
    project(Modules.Remote)
    project(Modules.Local)
    project(Modules.Test)

    implementation(Dependencies.Android.material)
    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.Hilt.android)
    kapt(Dependencies.Hilt.compiler)
    implementation(Dependencies.Kotlinx.datetime)
    implementation(Dependencies.Room.runtime)
    debugImplementation(Dependencies.Leak.leakCanary)
    androidTestImplementation(Dependencies.Test.junitExt)
    androidTestImplementation(Dependencies.Test.espresso)
}
