plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
}

version = "1.0.0"

kotlin {
    ios {
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
