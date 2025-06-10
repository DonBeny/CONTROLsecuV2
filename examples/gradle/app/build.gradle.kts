plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
    id("kotlin-parcelize") // Plugin inclus avec kotlin-android
    // Firebase désactivé pour Phase 1 - sera réactivé en production
    // alias(libs.plugins.google.services)
    // alias(libs.plugins.firebase.crashlytics)
    alias(libs.plugins.navigation.safeargs)
}

android {
    namespace = "net.orgaprop.controlsecuv2"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "net.orgaprop.controlsecuv2"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Configuration Room
        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf(
                    "room.schemaLocation" to "$projectDir/schemas",
                    "room.incremental" to "true"
                )
            }
        }
    }

    buildTypes {
        debug {
            isDebuggable = true
            buildConfigField("String", "BASE_URL", "\"https://api-dev.controlsecu.org/\"")
            buildConfigField("boolean", "ENABLE_LOGGING", "true")
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://api.controlsecu.org/\"")
            buildConfigField("boolean", "ENABLE_LOGGING", "false")
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
        viewBinding = true
        buildConfig = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Core Android
    implementation(libs.bundles.android.core)

    // Architecture Components
    implementation(libs.bundles.lifecycle)
    implementation(libs.bundles.navigation)

    // Room Database
    implementation(libs.bundles.room)
    kapt(libs.room.compiler)

    // Networking
    implementation(libs.bundles.networking)

    // Dependency Injection
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // WorkManager
    implementation(libs.work.runtime)

    // Security
    implementation(libs.security.crypto)

    // Image Loading & Processing
    implementation(libs.glide.core)
    kapt(libs.glide.compiler)

    // Firebase - Désactivé pour Phase 1, sera réactivé en production
    // implementation(platform(libs.firebase.bom))
    // implementation(libs.bundles.firebase)

    // Signature Pad
    implementation(libs.signature.pad)

    // Coroutines
    implementation(libs.coroutines.android)

    // Testing
    testImplementation(libs.bundles.testing)

    androidTestImplementation(libs.bundles.android.testing)
    kaptAndroidTest(libs.hilt.compiler)
}

// Permettre les references aux generated files
kapt {
    correctErrorTypes = true
}