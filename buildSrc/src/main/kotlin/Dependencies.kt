internal object Versions {
    const val junit = "4.12"
    const val material = "1.2.0"
}

object Dependencies {

    object KotlinTest {
        const val common = "test-common"
        const val annotations = "test-annotations-common"
        const val jvm = "test-junit"
    }

    const val junit = "junit:junit:${Versions.junit}"
    const val material =  "com.google.android.material:material:${Versions.material}"

}