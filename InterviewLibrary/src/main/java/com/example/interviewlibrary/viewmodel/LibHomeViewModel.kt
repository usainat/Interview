package com.example.interviewlibrary.viewmodel



/**
 * ViewModel class for library Home activity.
 */
class LibHomeViewModel : BaseViewModel() {
    fun triggerpayment() {
        commonButtonClickLiveData.value = ON_PAYMENT_CLICK
    }

    fun exit() {
        commonButtonClickLiveData.value = ON_EXIT_CLICK
    }

    fun signoutt() {
        commonButtonClickLiveData.value = ON_SIGN_OUT_CLICK
    }
}