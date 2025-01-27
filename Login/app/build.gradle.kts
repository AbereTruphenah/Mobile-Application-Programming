plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.login"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.login"
        minSdk = 24
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
        debug {
            // Rename the APK after it is built
            tasks.withType<com.android.build.gradle.tasks.PackageAndroidArtifact>().configureEach {
                doLast {
                    val outputDir = outputDirectory.get().asFile
                    outputDir.listFiles()?.forEach { file ->
                        if (file.name.endsWith("debug.apk")) {
                            val newName = "Truphenah.apk"
                            file.renameTo(outputDir.resolve(newName))
                        }
                    }
                }
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
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
}