plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "mx.com.edieltech.konfiocodechallenge"
    compileSdk = 36

    defaultConfig {
        applicationId = "mx.com.edieltech.konfiocodechallenge"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)


    // - Compose Navigation
    implementation(libs.androidx.navigation.compose)
    // - Kotlin Serialization
    implementation(libs.kotlinx.serialization.json)
    // - Extended Icons
    implementation(libs.material.icons.extended)
    // - system ui controller
    implementation(libs.com.google.accompanist)
    // - Lottie
    implementation(libs.airbnb.lottie.compose)
    // - Hilt Dependency Injection
    ksp(libs.google.hilt.compiler)
    implementation(libs.google.hilt)
    //- Hilt Navigation Compose
    implementation(libs.hilt.navigation.compose)
    //- Coil Image Compose
    implementation(libs.io.coil3)
    implementation(libs.io.coil3.okhttp)
    //-Room Data Base
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
    //Retrofit
    implementation(libs.retrofit2.converter.gson)
    //implementation(libs.okhttp3.logging.interceptor)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}