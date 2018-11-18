package com.example.interviewlibrary.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 *  enum data for various click action
 */
const val ON_LOGIN_CLICK = 1
const val ON_REG_NAV_CLICK = 2
const val ON_REGISTER_CLICK = 3
const val ON_PAYMENT_CLICK = 4
const val ON_SIGN_OUT_CLICK = 5
const val ON_EXIT_CLICK = 6
const val ON_PAYMENT_SUCCESS_CLICK = 7
const val ON_PAYMENT_FAILURE_CLICK = 8



/**
 *  ViewModel class as for common functionality
 */
abstract class BaseViewModel : ViewModel() {


    var commonButtonClickLiveData = MutableLiveData<Int>()
}