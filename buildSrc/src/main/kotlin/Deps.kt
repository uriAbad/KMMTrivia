object Versions {
    const val kotlin = "1.4.0"
    const val junit = "4.12"
    const val material = "1.2.0"
    const val ktor = "1.4.0"
    const val coroutines = "1.3.9"
    const val serialization = "1.0.0-RC"
    const val gradle = "4.0.1"
}

object Deps {

    object KotlinTest {
        const val common = "test-common"
        const val common_annotations = "test-annotations-common"
        const val jvm = "test-junit"
    }

    object Ktor {
        const val common_core = "io.ktor:ktor-client-core:${Versions.ktor}"
        const val json = "io.ktor:ktor-client-json:${Versions.ktor}"
        const val ios_client = "io.ktor:ktor-client-ios:${Versions.ktor}"
        const val android_client = "io.ktor:ktor-client-android:${Versions.ktor}"
        const val serialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
    }

    object Coroutines {
        const val common = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    }

    const val gradle_kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"

    const val kotlinxSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.serialization}"
    const val junit = "junit:junit:${Versions.junit}"
    const val material =  "com.google.android.material:material:${Versions.material}"

}