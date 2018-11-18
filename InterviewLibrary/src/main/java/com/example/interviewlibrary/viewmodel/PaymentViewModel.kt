package com.example.interviewlibrary.viewmodel


/**
 * ViewModel class for Payment activity.
 */
class PaymentViewModel : BaseViewModel() {


    fun paymentSuccess() {
        commonButtonClickLiveData.value = ON_PAYMENT_SUCCESS_CLICK
    }

    fun paymentFailure() {
        commonButtonClickLiveData.value = ON_PAYMENT_FAILURE_CLICK
    }
}