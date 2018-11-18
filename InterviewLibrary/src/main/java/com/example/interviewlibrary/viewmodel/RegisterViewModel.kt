package com.example.interviewlibrary.viewmodel

import android.databinding.ObservableField


/**
 * ViewModel class for register activity.
 */
class RegisterViewModel : BaseViewModel() {
    val userName: ObservableField<String> = ObservableField<String>()
    val email: ObservableField<String> = ObservableField<String>()
    val password: ObservableField<String> = ObservableField<String>()

    fun register() {
        commonButtonClickLiveData.value = ON_REGISTER_CLICK
    }
}