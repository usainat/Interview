package com.example.interviewlibrary.listener

/**
 * Interface callback for payment success and failure.
 */

interface PaymentListener {
    fun onPaymentSuccess()
    fun onPaymentFailure()
}