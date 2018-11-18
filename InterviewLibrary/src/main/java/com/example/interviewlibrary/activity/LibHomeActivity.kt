package com.example.interviewlibrary.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.interviewlibrary.R
import com.example.interviewlibrary.databinding.ActivityLibHomeBinding
import com.example.interviewlibrary.listener.PaymentListener
import com.example.interviewlibrary.utils.SharedPreferenceHelper
import com.example.interviewlibrary.utils.Utils
import com.example.interviewlibrary.viewmodel.LibHomeViewModel
import com.example.interviewlibrary.viewmodel.ON_EXIT_CLICK
import com.example.interviewlibrary.viewmodel.ON_PAYMENT_CLICK
import com.example.interviewlibrary.viewmodel.ON_SIGN_OUT_CLICK

/**
 * A Home screen that offers Payment, sign-out,exit
 */
class LibHomeActivity : AppCompatActivity(), PaymentListener {
    override fun onPaymentSuccess() {
        Toast.makeText(this, "Payment success hom", Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun onPaymentFailure() {
        Toast.makeText(this, "Payment failure hom", Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLibHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_lib_home)
        val viewModel: LibHomeViewModel = ViewModelProviders.of(this).get(LibHomeViewModel::class.java)
        binding.viewmodel = viewModel
        Utils.paymentListener = this
        viewModel.commonButtonClickLiveData.observe(this, Observer {
            when (it) {
                ON_EXIT_CLICK -> {
                    onBackPressed()
                    overridePendingTransition(R.anim.right_enter, R.anim.left_exit)
                }
                ON_SIGN_OUT_CLICK -> {
                   SharedPreferenceHelper.clearSharedPreferencence(this)
                    onBackPressed()
                }
                ON_PAYMENT_CLICK -> {
                    startActivity(Intent(this, PaymentActivity::class.java))
                    overridePendingTransition(R.anim.right_enter, R.anim.left_exit)
                }
            }
        })
    }

}
