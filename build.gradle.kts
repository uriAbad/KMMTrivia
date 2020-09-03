buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Deps.gradle_kotlin_plugin)
        classpath(Deps.gradle)
    }
}
group = "uri.abad.kmmtrivia"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
