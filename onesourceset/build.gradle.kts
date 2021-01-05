import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
}

version = "1.0.0"

kotlin {
    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
            ::iosArm64
        else
            ::iosX64

    iosTarget("ios") {
        // not needed with cocoapods plugin
//        binaries {
//            framework {
//                baseName = "shared"
//            }
//        }
    }
    sourceSets {
        val commonMain by getting
        val iosMain by getting
    }
    kotlin {
        targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget>().all {
            compilations.getByName("main") {
                val objcAddtition by cinterops.creating {
                    defFile(rootProject.file("objcAddtition.def"))
                }
            }
        }
    }
    cocoapods {
        summary = "Summary"
        homepage = "home"

        pod("AFNetworking")
    }
}
