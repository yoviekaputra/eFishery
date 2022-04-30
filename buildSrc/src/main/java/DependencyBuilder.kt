import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * @created 29-04-2022 11:38
 * @author yoviekaputra
 * @project eFishery
 **/

fun DependencyHandler.implementationCore() {
    implementation(Libs.Core.coreKtx)
    implementation(Libs.Core.appCompat)
    implementation(Libs.Core.material)
}

// implement the requirement of compose dependencies
fun DependencyHandler.implementationCompose() {
    implementation(Libs.Compose.ui)
    implementation(Libs.Compose.material)
    implementation(Libs.Compose.uiToolingPreview)
    implementation(Libs.Compose.activityCompose)
    implementation(Libs.Compose.uiTooling)

    androidTestImplementation(Libs.Compose.junit4)
    debugImplementation(Libs.Compose.uiTooling)
}

// implement the requirement of hilt dependencies
fun DependencyHandler.implementationHilt() {
    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.compiler)
    kapt(Libs.Hilt.hiltCompiler)

    // For instrumentation tests
    androidTestImplementation(Libs.Hilt.androidTesting)
    kaptAndroidTest(Libs.Hilt.testsCompiler)

    // For local unit tests
    testImplementation(Libs.Hilt.localAndroidTesting)
    kaptTest(Libs.Hilt.localTestCompiler)
}

// implement the requirement of coroutines dependencies
fun DependencyHandler.implementationCoroutines() {
    implementation(Libs.Coroutines.core)
    implementation(Libs.Coroutines.android)
    testImplementation(Libs.Coroutines.test)
}

// implement the requirement of room dependencies
fun DependencyHandler.implementationRoom() {
    implementation(Libs.Room.runtime)
    ksp(Libs.Room.compiler)
    implementation(Libs.Room.ktx)
    testImplementation(Libs.Room.test)
}

// implement the requirement of work manager dependencies
fun DependencyHandler.implementationWorkManager() {
    api(Libs.WorkManager.runtime)
    androidTestApi(Libs.WorkManager.test)

    implementation(Libs.WorkManager.hilt)
}

// implement the requirement of testing dependencies
fun DependencyHandler.implementationTest() {
    implementation(Libs.Test.espressoCore)
    implementation(Libs.Test.junit)
    implementation(Libs.Test.junitExt)
}

fun DependencyHandler.implementationRetrofit() {
    implementation(Libs.Retrofit.retrofit)
    implementation(Libs.Retrofit.moshi)
}