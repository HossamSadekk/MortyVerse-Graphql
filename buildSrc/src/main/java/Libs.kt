object SupportLib {
    const val CoreKtx = "androidx.core:core-ktx:1.9.0"
    const val LifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.6.1"
    const val ActivityCompose = "androidx.activity:activity-compose:1.7.0"
    const val compose_ui = "androidx.compose.ui:ui"
    const val compose_graphics = "androidx.compose.ui:ui-graphics"
    const val compose_preview = "androidx.compose.ui:ui-tooling-preview"
    const val compose_material3 = "androidx.compose.material3:material3"
    const val material = "com.google.android.material:material:1.8.0"
    const val appcompat = "androidx.appcompat:appcompat:1.6.1"

}
object TestingLib {
    const val Junit = "junit:junit:4.13.2"
}

object AndroidTestingLib {
    const val JunitExt = "androidx.test.ext:junit:1.1.5"
    const val EspressoCore = "androidx.test.espresso:espresso-core:3.5.1"
    const val compose_junit4 = "androidx.compose.ui:ui-test-junit4"
}

object AndroidComposeDebugLib {
    const val ComposeUiTooling = "androidx.compose.ui:ui-tooling"
    const val UiTestManifest = "androidx.compose.ui:ui-test-manifest"
}

object Navigation {
    const val NavigationCompose = "androidx.navigation:navigation-compose:2.7.5"
}

object DI {
    const val koin_android = "io.insert-koin:koin-android:3.5.0"
    const val koin_navigation = "io.insert-koin:koin-androidx-navigation:3.5.0"
    const val koin_compose = "io.insert-koin:koin-androidx-compose:3.5.0"
    const val koin_junit4 = "io.insert-koin:koin-test-junit4:3.5.0"
}
object Modules {
    const val APP = ":app"
    const val PRESENTATION = ":presentation"
    const val COMMON = ":common"
}