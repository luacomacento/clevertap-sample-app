package dev.luaoctaviano.clevertap.sampleapp

import android.app.Application
import com.clevertap.android.sdk.ActivityLifecycleCallback
import com.clevertap.android.sdk.CleverTapAPI

class CTApplication : Application() {
    override fun onCreate() {
        ActivityLifecycleCallback.register(this)
        super.onCreate()
        CleverTapAPI.getDefaultInstance(applicationContext)?.promptForPushPermission(true)
    }
}