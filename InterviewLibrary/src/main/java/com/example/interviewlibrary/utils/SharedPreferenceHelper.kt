package com.example.interviewlibrary.utils

import android.content.Context

/**
 * Helper class for shared preference
 */
object SharedPreferenceHelper {
    private const val PREF_FILE = "PREFS"
    const val PREF_APP_IS_LOGGED_IN = "PREF_APP_IS_LOGGED_IN"
    const val PREF_APP_IS_REGISTERED = "PREF_APP_IS_REGISTERED"
    const val PREF_APP_USERNAME = "PREF_APP_USERNAME"
    const val PREF_APP_EMAIL = "PREF_APP_EMAIL"
    const val PREF_APP_PASSWORD = "app_password"

    /**
     * Set a string shared preference
     *
     * @param key   - Key to set shared preference
     * @param value - Value for the key
     */
    fun setSharedPreferenceString(context: Context, key: String, value: String) {
        val settings = context.getSharedPreferences(PREF_FILE, 0)
        val editor = settings.edit()
        editor.putString(key, value)
        editor.apply()
    }

    /**
     * Set a Boolean shared preference
     *
     * @param key   - Key to set shared preference
     * @param value - Value for the key
     */
    fun setSharedPreferenceBoolean(context: Context, key: String, value: Boolean) {
        val settings = context.getSharedPreferences(PREF_FILE, 0)
        val editor = settings.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    /**
     * Get a string shared preference
     *
     * @param key      - Key to look up in shared preferences.
     * @param defValue - Default value to be returned if shared preference isn't found.
     * @return value - String containing value of the shared preference if found.
     */
    fun getSharedPreferenceString(context: Context, key: String, defValue: String): String? {
        val settings = context.getSharedPreferences(PREF_FILE, 0)
        return settings.getString(key, defValue)
    }

    /**
     * Get a boolean shared preference
     *
     * @param key      - Key to look up in shared preferences.
     * @param defValue - Default value to be returned if shared preference isn't found.
     * @return value - String containing value of the shared preference if found.
     */
    fun getSharedPreferenceBoolean(context: Context, key: String, defValue: Boolean): Boolean {
        val settings = context.getSharedPreferences(PREF_FILE, 0)
        return settings.getBoolean(key, defValue)
    }

    fun clearSharedPreferencence(context: Context): Boolean {
        val settings = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE)
        settings.edit().clear().apply()
        return true
    }

}