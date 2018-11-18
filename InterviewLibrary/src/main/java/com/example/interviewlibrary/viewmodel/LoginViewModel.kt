package com.example.interviewlibrary.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.databinding.Bindable
import android.databinding.ObservableField

/**
 * ViewModel class for library login activity.
 */
open class LibraryViewModel : BaseViewModel() {
    // for my reference
    // val email: ObservableField<String> = ObservableField()
    @Bindable
    val password = MutableLiveData<String>()

    @Bindable
    val email = MutableLiveData<String>()


    fun onLoginClick() {
        this.commonButtonClickLiveData.value = ON_LOGIN_CLICK
    }

    fun onRegisterNavClick() {
        this.commonButtonClickLiveData.value = ON_REG_NAV_CLICK
    }

}