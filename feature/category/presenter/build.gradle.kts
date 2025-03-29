plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.google.dagger.hilt)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "app.google.presenter"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    kapt {
        correctErrorTypes = true
    }
    buildFeatures {
        compose = true
    }
    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }
}

dependencies {
    implementation(project(":feature:category:domain"))
    implementation(project(":common"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    kapt(libs.hilt.android.compiler)
    implementation(libs.hilt.android)
    implementation(libs.androidx.lifecycle.viewModel)

    implementation(libs.glide)
    implementation(libs.landscapist.glide)

    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.navigation.navigation.compose)
    implementation(libs.androidx.navigation.compose)


    // Kotest (For BDD-style testing)
    testImplementation(libs.kotest.runner.junit5)
    testImplementation(libs.kotest.assertions.core)
    testImplementation(libs.kotest.framework.engine)

    // JUnit 5 (For unit testing)
    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.engine)

    // MockK (For mocking dependencies)
    testImplementation(libs.mockk)

    // Coroutines Testing (For ViewModel coroutine testing)
    testImplementation(libs.kotlinx.coroutines.test)

    // Turbine (For Flow & StateFlow testing)
    testImplementation(libs.turbine)

    // AndroidX Core Testing (For LiveData and ViewModel testing)
   // testImplementation("androidx.arch.core:core-testing:2.1.0")

    // Espresso (For UI Testing if needed)
    androidTestImplementation(libs.androidx.espresso.core)

    // UI Testing (AndroidX)
/*    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.runner)*/

    // Compose UI Testing (If using Jetpack Compose)
    androidTestImplementation(libs.ui.test.junit4)
    implementation( libs.kotlin.reflect)

}
