plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
}



android {
    namespace = "com.example.finalassessment"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.finalassessment"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        viewBinding = true
        dataBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.recyclerview)
    implementation (libs.androidx.constraintlayout.constraintlayout20)


    // OkHttp dependencies
    implementation("com.squareup.okhttp3:okhttp:4.9.3")  // OkHttp library
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")  // Logging interceptor

    // ViewModel
    implementation (libs.androidx.lifecycle.lifecycle.viewmodel.ktx22)
    implementation (libs.androidx.activity.activity.ktx24)

    // Retrofit
    implementation (libs.com.squareup.retrofit2.retrofit25)
    implementation (libs.com.squareup.retrofit2.converter.gson26)

    // Coroutines
    implementation (libs.org.jetbrains.kotlinx.kotlinx.coroutines.android21)

    // Hilt
    implementation ("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")

    //Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    testImplementation ("org.mockito:mockito-core:3.11.2")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.2")
    testImplementation ("androidx.arch.core:core-testing:2.1.0")

    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
}



// Allow references to generated code
kapt{
    correctErrorTypes = true
}
