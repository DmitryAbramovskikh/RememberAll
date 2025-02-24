// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.8.1" apply false
    id("org.jetbrains.kotlin.android") version "2.0.0" apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
    id("com.google.devtools.ksp") version "2.0.20-1.0.24" apply false
    kotlin("jvm") version "2.0.20"
    alias(libs.plugins.compose.compiler) apply false
    id ("org.jetbrains.kotlin.plugin.serialization") version "2.0.20"
}