plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles(Config.consumerRulesLibrary)
    }

    buildTypes {
        release {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
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
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Version.Compose.compose
    }
}

dependencies {

    implementationCore()

    implementationTest()

    implementationCompose()

    implementationHilt()

    implementationCoroutines()

    implementationWorkManager()

    implementation(project(Modules.Core.network))

    implementation(project(Modules.Core.abstractions))

    implementation(project(Modules.database))

    implementation(project(Modules.Features.syncronize))

    implementation(project(Modules.Core.themes))
}