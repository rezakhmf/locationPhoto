package com.farahaniconsulting.locationphoto

import com.farahaniconsulting.locationphoto.data.local.database.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PhotoLocationApplication : PhotoLocationCoreApplication() {
    override fun onCreate() {
        super.onCreate()
    }
}