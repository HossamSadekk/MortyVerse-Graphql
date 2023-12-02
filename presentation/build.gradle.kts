plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.presentation"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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
    // Navigation
    implementation(Navigation.NavigationCompose)
    // Modules
    implementation(project(Modules.COMMON))
    implementation(project(Modules.DOMIAN))
    //
    implementation(Pagination.Paging)
    // logger
    implementation(Logger.Timber)
    //
    implementation(ImageLoader.coil)
    implementation(ImageLoader.coil_skydov)
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.0")

    // DI
    implementation(DI.koin_android)
    implementation(DI.koin_compose)
    implementation(DI.koin_navigation)
    implementation(DI.koin_junit4)
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation(Pagination.Paging)
    implementation(Pagination.Paging_compose)

}