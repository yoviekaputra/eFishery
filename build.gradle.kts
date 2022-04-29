// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.application) version Version.Plugin.application apply false
    id(Plugins.library) version Version.Plugin.library apply false
    id(Plugins.kotlin) version Version.Plugin.kotlin apply false
}

buildscript {
    dependencies {
        // other plugins...
        classpath(Plugins.hilt)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}