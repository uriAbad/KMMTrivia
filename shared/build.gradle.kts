import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version Versions.kotlin
    id("com.android.library")
    id("kotlin-android-extensions")
}
group = "uri.abad.kmmtrivia"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}
kotlin {
    android()
    ios {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Deps.Ktor.common_core)
                implementation(Deps.Ktor.json)
                implementation(Deps.Ktor.serialization)
                implementation(Deps.Ktor.CIO)
                implementation(Deps.kotlinxSerialization)
                implementation(Deps.Coroutines.common)

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin(Deps.KotlinTest.common))
                implementation(kotlin(Deps.KotlinTest.common_annotations))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Deps.material)
                implementation(Deps.Ktor.android_client)
                implementation(Deps.Coroutines.android)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin(Deps.KotlinTest.jvm))
                implementation(Deps.junit)
                implementation(Deps.Coroutines.test)
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(Deps.Ktor.ios_client)
                implementation(Deps.Coroutines.common)
            }
        }
        val iosTest by getting
    }
}
android {
    compileSdkVersion(29)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}
val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework = kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}
tasks.getByName("build").dependsOn(packForXcode)