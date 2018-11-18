package com.example.husa.interview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import com.example.interviewlibrary.activity.LibHomeActivity
import com.example.interviewlibrary.activity.LoginActivity
import com.example.interviewlibrary.activity.PaymentActivity
import com.example.interviewlibrary.activity.RegisterActivity
import com.example.interviewlibrary.utils.Utils

class HomePage : AppCompatActivity() {
    private var mCurrentFragment = "It will contain Fragment name"
    private var fManager: FragmentManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        fManager = supportFragmentManager
        mainAppPage()
    }

    private fun mainAppPage() {
        val fragment = HomeFragment()
        mCurrentFragment = "LOGIN"
        val fTrans = fManager!!.beginTransaction()
        fTrans.setCustomAnimations(R.anim.right_enter, R.anim.left_exit, R.anim.left_in, R.anim.right_out)
        fTrans.replace(R.id.content_home, fragment, mCurrentFragment)
        fTrans.commit()
    }

    fun loadPaymentPage() {
        if (Utils.isLoggedIn(this)) {
            val intent = Intent(this, PaymentActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.right_enter, R.anim.left_exit)
        } else if (Utils.isRegistered(this)) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.right_enter, R.anim.left_exit)
        } else {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.right_enter, R.anim.left_exit)
        }

    }

    fun loginPage() {
        if (Utils.isLoggedIn(this)) {
            val intent = Intent(this, LibHomeActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.right_enter, R.anim.left_exit);
        } else if (Utils.isRegistered(this)) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.right_enter, R.anim.left_exit);
        } else {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.right_enter, R.anim.left_exit);
        }
    }
}

