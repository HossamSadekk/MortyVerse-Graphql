plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("com.apollographql.apollo3") version ("3.8.2")

}
apollo {
    service("service") {
        packageName.set("com.example.ricknmorty")
    }
}
android {
    namespace = "com.example.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}



dependencies {

    // core
    implementation(SupportLib.CoreKtx)
    implementation(SupportLib.LifecycleRuntime)
    implementation(SupportLib.ActivityCompose)
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation(SupportLib.compose_ui)
    implementation(SupportLib.compose_graphics)
    implementation(SupportLib.compose_preview)
    implementation(SupportLib.compose_material3)
    // testing
    testImplementation(TestingLib.Junit)
    testImplementation(AndroidTestingLib.JunitExt)
    testImplementation(AndroidTestingLib.EspressoCore)
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation(AndroidTestingLib.compose_junit4)
    debugImplementation(AndroidComposeDebugLib.ComposeUiTooling)
    debugImplementation(AndroidComposeDebugLib.UiTestManifest)
    // DI
    implementation(DI.koin_android)
    implementation(DI.koin_compose)
    implementation(DI.koin_navigation)
    // Graphql
    implementation(GRAPHQL.GraphQl)

}