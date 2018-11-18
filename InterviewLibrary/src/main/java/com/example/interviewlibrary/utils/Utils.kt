package com.example.interviewlibrary.utils

import android.content.Context
import android.util.Patterns
import com.example.interviewlibrary.listener.PaymentListener

/**
 * Utils to provide data to application
 */
object Utils {
    var paymentListener: PaymentListener? = null

    fun isLoggedIn(context: Context) =
            SharedPreferenceHelper.getSharedPreferenceBoolean(context, SharedPreferenceHelper.PREF_APP_IS_LOGGED_IN, false)

    fun isRegistered(context: Context) =
            SharedPreferenceHelper.getSharedPreferenceBoolean(context, SharedPreferenceHelper.PREF_APP_IS_REGISTERED, false)


        fun isValidEmail(email:String): Boolean = email.isNotEmpty() &&
                Patterns.EMAIL_ADDRESS.matcher(email).matches()

}