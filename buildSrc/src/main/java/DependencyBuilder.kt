import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * @created 29-04-2022 11:38
 * @author yoviekaputra
 * @project eFishery
 **/

// implement the requirement of compose dependencies
fun DependencyHandler.implementationsCompose() {
    implementation(Libs.Compose.ui)
    implementation(Libs.Compose.material)
    implementation(Libs.Compose.uiToolingPreview)
    implementation(Libs.Compose.activityCompose)
    implementation(Libs.Compose.uiTooling)

    androidTestImplementation(Libs.Compose.junit4)
    debugImplementation(Libs.Compose.uiTooling)
}

// implement the requirement of hilt dependencies
fun DependencyHandler.implementationsHilt() {
    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.compiler)

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
fun DependencyHandler.implementationsRoom() {
    implementation(Libs.Room.runtime)
    ksp(Libs.Room.compiler)
    implementation(Libs.Room.ktx)
    testImplementation(Libs.Room.test)
}

// implement the requirement of work manager dependencies
fun DependencyHandler.implementationWorkManager() {
    implementation(Libs.WorkManager.runtime)
    implementation(Libs.WorkManager.test)
}

// implement the requirement of testing dependencies
fun DependencyHandler.implementationsTest() {
    implementation(Libs.Test.espressoCore)
    implementation(Libs.Test.junit)
    implementation(Libs.Test.junitExt)
}
