package com.example.fiveacts.utils

import android.app.Application

class SharedApp: Application() {
    companion object{
        lateinit var preferences: PreferencesManager
    }

    override fun onCreate() {
        super.onCreate()
        preferences = PreferencesManager(applicationContext)
    }

}