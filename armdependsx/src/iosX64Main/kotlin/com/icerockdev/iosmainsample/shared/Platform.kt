package com.icerockdev.iosmainsample.shared


import cocoapods.AFNetworking.AFNetworkingVersionString
import com.icerockdev.iosmainsample.interop.setAssociatedObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() +
            " " + UIDevice.currentDevice.systemVersion

    init {
        setAssociatedObject(this, "test")

        GlobalScope.launch(Dispatchers.Main) {
            delay(2000)

            println(AFNetworkingVersionString)
        }
    }
}
