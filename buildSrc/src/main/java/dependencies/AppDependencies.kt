package dependencies

object AppDependencies {
    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val app_compat = "androidx.appcompat:appcompat:${Versions.app_compat}"


    const val constraint_layout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val ui_tooling = "androidx.ui:ui-tooling:${Versions.androidx_ui}"
    const val nav_fragment_ktx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.nav_component}"
    const val material = "com.google.android.material:material:${Versions.material}"

    const val nav_ui_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.nav_component}"

    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"


    const val hilt_compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt}"
}