package com.example.husa.interview

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.interviewlibrary.listener.PaymentListener
import com.example.interviewlibrary.utils.Utils
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), PaymentListener {
    override fun onPaymentSuccess() {
        Toast.makeText(mHom, "Payment success", Toast.LENGTH_SHORT).show()
    }

    override fun onPaymentFailure() {
        Toast.makeText(mHom, "Payment failure", Toast.LENGTH_SHORT).show()
    }

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var mHom: HomePage? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mHom = activity as HomePage?
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        bt_login_reg.setOnClickListener {
            mHom!!.loginPage()
        }

        bt_paymnet.setOnClickListener {
            mHom!!.loadPaymentPage()

            Utils.paymentListener = this

          /*  Utils.paymentStatus.observe(this, Observer {
                when (it) {
                    "FAILURE" -> {
                        Toast.makeText(mHom, "Payment success", Toast.LENGTH_SHORT).show()
                    }
                    "SUCCESS" -> {
                        Toast.makeText(mHom, "Payment failure", Toast.LENGTH_SHORT).show()
                    }
                }            })*/
        }

    }}