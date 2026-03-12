package com.example.messagingapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Main application class for the messaging app
 */
@HiltAndroidApp
class MessagingApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialization code can go here
    }
}