plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs")
    id("org.jlleitschuh.gradle.ktlint")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.ict.mito.justodo"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
    }
    dataBinding.isEnabled = true
    viewBinding.isEnabled = true
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildToolsVersion = "30.0.2"
}

dependencies {
    implementation(
        fileTree(
            mapOf(
                "dir" to "libs",
                "include" to listOf("*.jar")
            )
        )
    )

    val kotlinVersion: String? by project
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion")

//    KTX
    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.activity:activity-ktx:1.2.1")
    implementation("androidx.fragment:fragment-ktx:1.3.1")

//    androidx
    implementation("androidx.appcompat:appcompat:1.3.0-beta01")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.0")
    implementation("com.android.support:multidex:1.0.3")
//    navigation
    val navigationVersion: String? by project
    implementation("androidx.navigation:navigation-common-ktx:$navigationVersion")
    implementation("androidx.navigation:navigation-fragment:$navigationVersion")
    implementation("androidx.navigation:navigation-ui:$navigationVersion")
    implementation("androidx.navigation:navigation-fragment-ktx:$navigationVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navigationVersion")
//    androidx view
    implementation("androidx.constraintlayout:constraintlayout:2.1.0-beta01")
    implementation("androidx.recyclerview:recyclerview:1.2.0-beta02")
    implementation("androidx.cardview:cardview:1.0.0")
//    material view
    implementation("com.google.android.material:material:1.4.0-alpha01")
//    room
    val roomVersion: String? by project
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    androidTestImplementation("androidx.room:room-testing:$roomVersion")
//    Lifecycle components
    val lifecycleVersion: String? by project
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    // Lifecycles only (without ViewModel or LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")

    implementation("androidx.lifecycle:lifecycle-extensions:$lifecycleVersion")
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycleVersion")
//    Coroutines
    val coroutinesVersion: String? by project
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

//    Anko
    implementation("org.jetbrains.anko:anko-commons:0.10.8")

//    LazyDatePicker
    implementation("com.mikhaellopez:lazydatepicker:1.0.0")

//    Dagger 2
    val daggerVersion: String? by project
    implementation("com.google.dagger:dagger:$daggerVersion")
    implementation("com.google.dagger:dagger-android:$daggerVersion")
    implementation("com.google.dagger:dagger-android-support:$daggerVersion")
    annotationProcessor("com.google.dagger:dagger-compiler:$daggerVersion")
    kapt("com.google.dagger:dagger-compiler:$daggerVersion")
    kapt("com.google.dagger:dagger-android-processor:$daggerVersion")

//    test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test:runner:1.3.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}

kapt {
    javacOptions {
        option("-Xmaxerrs", 5000)
    }
}

ktlint {
    version.set("0.31.0")
    android.set(true)
    reporters.set(setOf(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE))
    ignoreFailures.set(true) // NOTE: エラーで中断させないための設定
}
