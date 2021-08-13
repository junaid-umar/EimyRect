package dependencies

object Test {
    const val jupiter_api = "org.junit.jupiter:junit-jupiter-api:${Versions.junit_jupiter}"
    const val jupiter_engine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit_jupiter}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val core_testing = "androidx.arch.core:core-testing:${Versions.core_testing}"
    const val flow_turbine = "app.cash.turbine:turbine:${Versions.flow_turbine}"
    const val coroutine_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine}"
    const val truth_google = "com.google.truth:truth:${Versions.truth}"

    const val junit4 = "androidx.test.ext:junit:${Versions.junit4}"
    const val test_core = "androidx.test:core:${Versions.test_core}"
    const val test_runner = "androidx.test:runner:${Versions.test_core}"

}
