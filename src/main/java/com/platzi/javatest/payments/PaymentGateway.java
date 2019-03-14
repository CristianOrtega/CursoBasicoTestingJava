package com.platzi.javatest.payments;

import com.platzi.javatest.payments.PaymentRequest;
import com.platzi.javatest.payments.PaymentResponse;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);
}
