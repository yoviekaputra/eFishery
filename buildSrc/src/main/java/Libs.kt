/**
 * @created 29-04-2022 11:05
 * @author yoviekaputra
 * @project eFishery
 **/

object Libs {

    object Core {
        const val coreKtx = "androidx.core:core-ktx:${Version.Core.coreKtx}"
        const val appCompat = "androidx.appcompat:appcompat:${Version.Core.appCompat}"
        const val material = "com.google.android.material:material:${Version.Core.material}"
    }

    object Lifecycle {
        const val viewModel =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.Lifecycle.lifecycleRuntimeKtx}"
        const val lifecycleRuntimeKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Version.Lifecycle.lifecycleRuntimeKtx}"
        const val viewModelCompose =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.Lifecycle.viewModelCompose}"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Version.Compose.compose}"
        const val material = "androidx.compose.material:material:${Version.Compose.compose}"
        const val activityCompose =
            "androidx.activity:activity-compose:${Version.Compose.activityCompose}"
        const val uiToolingPreview =
            "androidx.compose.ui:ui-tooling-preview:${Version.Compose.compose}"

        const val junit4 = "androidx.compose.ui:ui-test-junit4:${Version.Compose.compose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Version.Compose.compose}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.Retrofit.retrofit}"
        const val okHttpLogger = "com.squareup.okhttp3:logging-interceptor:${Version.Retrofit.okHttp}"
        const val moshi = "com.squareup.retrofit2:converter-moshi:${Version.Retrofit.retrofit}"
        const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Version.Retrofit.moshiKotlin}"
        const val codegen = "com.squareup.moshi:moshi-kotlin-codegen:${Version.Retrofit.moshiKotlin}"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:${Version.Hilt.core}"
        const val compiler = "com.google.dagger:hilt-compiler:${Version.Hilt.core}"
        const val hiltCompiler = "androidx.hilt:hilt-compiler:${Version.Hilt.androidX}"

        // For instrumentation tests
        const val androidTesting = "com.google.dagger:hilt-android-testing:${Version.Hilt.core}"
        const val testsCompiler = "com.google.dagger:hilt-compiler:${Version.Hilt.core}"

        // For local unit tests
        const val localAndroidTesting =
            "com.google.dagger:hilt-android-testing:${Version.Hilt.core}"
        const val localTestCompiler = "com.google.dagger:hilt-compiler:${Version.Hilt.core}"
    }

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutines}"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Version.room}"
        const val compiler = "androidx.room:room-compiler:${Version.room}"
        const val ktx = "androidx.room:room-ktx:${Version.room}"
        const val test = "androidx.room:room-testing:${Version.room}"
    }

    object WorkManager {
        const val runtime = "androidx.work:work-runtime-ktx:${Version.workManager}"
        const val test = "androidx.work:work-testing:${Version.workManager}"

        // Hilt Worker
        const val hilt = "androidx.hilt:hilt-work:${Version.Hilt.androidX}"
    }

    object Test {
        const val junit = "junit:junit:${Version.Test.junit}"
        const val junitExt = "androidx.test.ext:junit:${Version.Test.junitExt}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Version.Test.espressoCore}"
    }
}