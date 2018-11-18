package com.example.interviewlibrary.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.interviewlibrary.R
import com.example.interviewlibrary.utils.SharedPreferenceHelper
import com.example.interviewlibrary.databinding.ActivityLoginBinding
import com.example.interviewlibrary.viewmodel.*

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity() {
    private lateinit var viewModel: LibraryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        this.viewModel = ViewModelProviders.of(this).get(LibraryViewModel::class.java)
        binding.viewmodel = this.viewModel

        this.viewModel.commonButtonClickLiveData.observe(this, Observer {
            when (it) {
                ON_LOGIN_CLICK -> {
                    this.attemptLogin()
                }
                ON_REG_NAV_CLICK -> {
                    startActivity(Intent(this, RegisterActivity::class.java))
                    overridePendingTransition(R.anim.right_enter, R.anim.left_exit)
                }


            }
        })

    }

    private fun attemptLogin() {
        val email = viewModel.email.value
        val password = viewModel.password.value
        val storedEmail = SharedPreferenceHelper.getSharedPreferenceString(this, SharedPreferenceHelper.PREF_APP_EMAIL, "")
        val storedPassword = SharedPreferenceHelper.getSharedPreferenceString(this, SharedPreferenceHelper.PREF_APP_PASSWORD, "")
        if (!email.isNullOrBlank() && !password.isNullOrBlank() && email.equals(storedEmail) && password == storedPassword) {
            SharedPreferenceHelper.setSharedPreferenceBoolean(this, SharedPreferenceHelper.PREF_APP_IS_LOGGED_IN, true)
            startActivity(Intent(this, LibHomeActivity::class.java))
            overridePendingTransition(R.anim.right_enter, R.anim.left_exit)
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
            finish()
        } else if (email.isNullOrBlank())
            Toast.makeText(this, R.string.plz_enter_email, Toast.LENGTH_SHORT).show()
        else if (password.isNullOrBlank())
            Toast.makeText(this, R.string.plz_enter_password, Toast.LENGTH_SHORT).show()
        else if (password.isNullOrBlank())
            Toast.makeText(this, R.string.plz_enter_password, Toast.LENGTH_SHORT).show()
        else if (!email.equals(storedEmail))
            Toast.makeText(this, R.string.email_mismatch, Toast.LENGTH_SHORT).show()
        else if (!password.equals(storedPassword))
            Toast.makeText(this, R.string.password_mismatch, Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, R.string.plz_enter_check, Toast.LENGTH_SHORT).show()
    }
}
