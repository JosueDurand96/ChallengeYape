plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    alias(libs.plugins.jetbrainsKotlinSerialization)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.durand.challengeyape"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.durand.challengeyape"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
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
    packagingOptions {
        resources {
            excludes += "META-INF/LICENSE.md"
            excludes += "META-INF/LICENSE-notice.md"
            excludes += "META-INF/LICENSE.txt"
            excludes += "META-INF/NOTICE.txt"
            excludes += "META-INF/DEPENDENCIES"
        }
    }
}

dependencies {
    implementation(project(":domain")) // Conectar con domain
    implementation(project(":data")) // Conectar con data

    implementation(libs.material.window.size)
    // Maps
    implementation(libs.maps.compose)
    implementation(libs.play.services.maps)
    // Hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.ui.test.junit4.android)
    implementation(libs.androidx.navigation.testing)
    kapt(libs.hilt.compiler)
    // Jetpack Compose
    implementation(libs.androidx.activity.compose.v180)
    implementation(libs.ui)
    implementation(libs.androidx.material)
    // Hilt para Jetpack Compose
    implementation(libs.androidx.hilt.navigation.compose)
    // Coil
    implementation(libs.coil.compose)
    //navigation compose
    implementation(libs.androidx.navigation.compose)
    //Kotlinx serialization
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.runtime.livedata)
    testImplementation(libs.junit)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    // Mockk para mocks y stubbing
    testImplementation(libs.mockk)
    // Coroutines Testing para pruebas asíncronas
    testImplementation(libs.kotlinx.coroutines.test)
    // Turbine para pruebas de Flow
    testImplementation(libs.turbine)
    // Kotlinx Serialization para serialización/deserialización de JSON
    testImplementation(libs.kotlinx.serialization.json.v151)
    testImplementation(libs.robolectric)
    // Actualizar MockK a la última versión

    androidTestImplementation(libs.mockk.android)
    androidTestImplementation(libs.androidx.junit.v115) // Versión correcta
    androidTestImplementation(libs.androidx.espresso.core.v351)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    configurations.all {
        resolutionStrategy.force("androidx.test.ext:junit:1.1.5")
    }
}