package com.example.interviewlibrary.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.interviewlibrary.R
import com.example.interviewlibrary.utils.Utils.paymentListener
import com.example.interviewlibrary.databinding.ActivityPaymentBinding
import com.example.interviewlibrary.viewmodel.ON_PAYMENT_FAILURE_CLICK
import com.example.interviewlibrary.viewmodel.ON_PAYMENT_SUCCESS_CLICK
import com.example.interviewlibrary.viewmodel.PaymentViewModel


/**
 *  Payment activity screen
 */
class PaymentActivity : AppCompatActivity() {
    private lateinit var viewModel: PaymentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityPaymentBinding = DataBindingUtil.setContentView(this, R.layout.activity_payment)
        this.viewModel = ViewModelProviders.of(this).get(PaymentViewModel::class.java)
        binding.viewmodel = this.viewModel
        this.viewModel.commonButtonClickLiveData.observe(this, Observer {
            when (it) {
                ON_PAYMENT_FAILURE_CLICK -> {
                    finish()
                    paymentListener?.onPaymentSuccess()
                }
                ON_PAYMENT_SUCCESS_CLICK -> {
                    finish()
                    paymentListener?.onPaymentFailure()

                }
            }
        })
    }


}
