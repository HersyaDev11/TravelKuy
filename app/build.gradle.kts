plugins {
    // Perbaikan Alias: Menghapus kata 'jetbrains' yang bikin error
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.travelkuy"
    compileSdk = 34 // Menggunakan SDK stabil

    defaultConfig {
        applicationId = "com.example.travelkuy"
        minSdk = 26
        targetSdk = 34
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

    // Pastikan Java Version sinkron
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    // HAPUS 'compose = true' dan ganti dengan ini:
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // --- LIBRARY INTI ANDROID (XML/VIEWS) ---
    // Saya ganti ke string langsung supaya tidak error 'Unresolved reference'
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // --- LIBRARY UNTUK TUGAS AKHIR ---
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation(libs.androidx.activity)

    // --- TESTING (Biarkan saja) ---
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}