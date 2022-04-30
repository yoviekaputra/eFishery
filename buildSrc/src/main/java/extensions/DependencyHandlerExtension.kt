import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * @created 29-04-2022 11:35
 * @author yoviekaputra
 * @project eFishery
 **/


fun DependencyHandler.implementation(dependencyNotation: String) {
    add("implementation", dependencyNotation)
}

fun DependencyHandler.kapt(dependencyNotation: String) {
    add("kapt", dependencyNotation)
}

fun DependencyHandler.testImplementation(dependencyNotation: String) {
    add("testImplementation", dependencyNotation)
}

fun DependencyHandler.kaptTest(dependencyNotation: String) {
    add("kaptTest", dependencyNotation)
}

fun DependencyHandler.androidTestImplementation(dependencyNotation: String) {
    add("androidTestImplementation", dependencyNotation)
}

fun DependencyHandler.kaptAndroidTest(dependencyNotation: String) {
    add("kaptAndroidTest", dependencyNotation)
}

fun DependencyHandler.debugImplementation(dependencyNotation: String) {
    add("debugImplementation", dependencyNotation)
}

fun DependencyHandler.ksp(dependencyNotation: String) {
    add("ksp", dependencyNotation)
}

fun DependencyHandler.api(dependencyNotation: Any) {
    add("api", dependencyNotation)
}

fun DependencyHandler.androidTestApi(dependencyNotation: Any) {
    add("androidTestApi", dependencyNotation)
}