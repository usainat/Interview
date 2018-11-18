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
import com.example.interviewlibrary.databinding.ActivityRegisterBinding
import com.example.interviewlibrary.utils.Utils.isValidEmail
import com.example.interviewlibrary.viewmodel.*

/**
 * Register screen
 */
class RegisterActivity : AppCompatActivity() {
    private lateinit var viewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityRegisterBinding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.commonButtonClickLiveData.observe(this, Observer {
            when (it) {
                ON_REGISTER_CLICK -> {
                    attemptregister()
                }
            }
        })


    }

    private fun attemptregister() {
        val userName = this.viewModel.userName.get()
        val email = this.viewModel.email.get()
        val password = this.viewModel.password.get()

        if (!userName.isNullOrBlank() && !email.isNullOrBlank() && !password.isNullOrBlank() && password.length >= 4 && isValidEmail(email)) {
            SharedPreferenceHelper.setSharedPreferenceString(this, SharedPreferenceHelper.PREF_APP_USERNAME, userName)
            SharedPreferenceHelper.setSharedPreferenceString(this, SharedPreferenceHelper.PREF_APP_EMAIL, email)
            SharedPreferenceHelper.setSharedPreferenceString(this, SharedPreferenceHelper.PREF_APP_PASSWORD, password)
            SharedPreferenceHelper.setSharedPreferenceBoolean(this, SharedPreferenceHelper.PREF_APP_IS_REGISTERED, true)
            Toast.makeText(this, R.string.reg_success, Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginActivity::class.java))
            overridePendingTransition(R.anim.right_enter, R.anim.left_exit)
            finish()
        } else if (userName.isNullOrBlank()) {
            Toast.makeText(this, R.string.plz_enter_username, Toast.LENGTH_SHORT).show()
        } else if (email.isNullOrBlank()) {
            Toast.makeText(this, R.string.plz_enter_email, Toast.LENGTH_SHORT).show()
        } else if (password.isNullOrBlank()) {
            Toast.makeText(this, R.string.plz_enter_password, Toast.LENGTH_SHORT).show()
        } else if (password.length < 4) {
            Toast.makeText(this, R.string.error_invalid_password, Toast.LENGTH_SHORT).show()
        } else if (!isValidEmail(email)) {
            Toast.makeText(this, R.string.error_invalid_email, Toast.LENGTH_SHORT).show()
        }
    }


}
