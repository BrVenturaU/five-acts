package com.example.fiveacts.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.fiveacts.models.User

class PreferencesManager(context: Context) {
    // Clave de objeto de preferencias
    val PREFERENCES_NAME = "com.example.fiveacts.utils"

    // Clave
    val SHARED_EMAIL = "user_data"
    val preferences: SharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, 0)

    var userEmail: String?
        get() = preferences.getString(SHARED_EMAIL, "")
        set(value) = preferences.edit().putString(SHARED_EMAIL, value).apply()



}