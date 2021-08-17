package com.example.datadogcrash

import android.app.Application
import com.datadog.android.Datadog
import com.datadog.android.core.configuration.Configuration
import com.datadog.android.core.configuration.Credentials
import com.datadog.android.privacy.TrackingConsent

class DdCrashApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val environmentName = BuildConfig.BUILD_TYPE
        val config = Configuration.Builder(
            logsEnabled = true,
            tracesEnabled = false,
            rumEnabled = false,
            crashReportsEnabled = false
        ).build()
        val credentials = Credentials("datadogClientToken", environmentName, Credentials.NO_VARIANT, null)

        Datadog.initialize(this, credentials, config, TrackingConsent.GRANTED)
    }
}