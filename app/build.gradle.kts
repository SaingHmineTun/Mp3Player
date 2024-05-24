plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "it.saimao.mp3player"
    compileSdk = 34

    defaultConfig {
        applicationId = "it.saimao.mp3player"
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
        sourceCompatibility = JavaVersion.VERSION_17 // LTS
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    /*
        Scalable Unit
     */
    val intuitVersion = "1.1.1"
    implementation("com.intuit.ssp:ssp-android:$intuitVersion") // font-size - sp
    implementation("com.intuit.sdp:sdp-android:$intuitVersion") // dp -> sdp

    /*
    Exoplayer
     */
    val mediaVersion = "1.0.1"
    implementation("androidx.media3:media3-exoplayer:$mediaVersion")
    implementation("androidx.media3:media3-ui:$mediaVersion")
    implementation("androidx.media3:media3-exoplayer-dash:$mediaVersion")

    /*
    Glide (Image Loading Library)
     */
    implementation("com.github.bumptech.glide:glide:4.16.0")

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}