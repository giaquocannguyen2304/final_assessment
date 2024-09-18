// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
    alias(libs.plugins.compose.compiler) apply false

}
buildscript {

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath (libs.gradle)
        classpath(libs.androidx.navigation.safe.args.gradle.plugin)
        classpath (libs.dagger.hilt.android.gradle.plugin)
        classpath(libs.kotlin.gradle.plugin)
    }
}








