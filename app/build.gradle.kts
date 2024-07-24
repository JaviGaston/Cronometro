plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.cronometro"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.cronometro"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation("org.jetbrains.kotlin:kotlin-script-runtime:1.6.10")

    implementation ("androidx.room:room-runtime:2.6.1")
    annotationProcessor ("androidx.room:room-compiler:2.6.1")

    // optional - RxJava2 support for Room
    implementation ("androidx.room:room-rxjava2:2.6.1")

    // optional - RxJava3 support for Room
    implementation ("androidx.room:room-rxjava3:2.6.1")

    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation ("androidx.room:room-guava:2.6.1")

    // optional - Test helpers
    testImplementation ("androidx.room:room-testing:2.6.1")

    // optional - Paging 3 Integration
    implementation ("androidx.room:room-paging:2.6.1")
}