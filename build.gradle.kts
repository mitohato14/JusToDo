// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    val kotlinVersion by extra("1.3.70")
    val daggerVersion by extra("2.23")
    val navigationVersion by extra("2.3.0-alpha01")
    val roomVersion by extra("2.1.0-alpha06")
    val lifecycleVersion by extra("2.2.0")
    val coroutinesVersion by extra("0.26.1")

    repositories {
        google()
        jcenter()
        maven(url = "https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.6.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:8.2.0")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven("https://jitpack.io")
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
    }
}
tasks.create(
    "clean",
    type = Delete::class
) {
    delete(rootProject.buildDir)
}
