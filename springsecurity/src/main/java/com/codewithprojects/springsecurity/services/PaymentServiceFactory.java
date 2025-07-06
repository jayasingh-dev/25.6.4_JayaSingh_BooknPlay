package com.codewithprojects.springsecurity.services;

import com.codewithprojects.springsecurity.entities.PaymentMethod;
import com.codewithprojects.springsecurity.services.impl.MockPaymentService;
import com.codewithprojects.springsecurity.services.impl.PayPalPaymentService;
import com.codewithprojects.springsecurity.services.impl.StripePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PaymentServiceFactory {

    @Autowired
    private StripePaymentService stripePaymentService;
    @Autowired
    private PayPalPaymentService paypalPaymentService;
    @Autowired
    private MockPaymentService mockPaymentService;

    public PaymentService getService(PaymentMethod method) {
        switch (method) {
            case STRIPE: return stripePaymentService;
            case PAYPAL: return paypalPaymentService;
            case MOCK:   return mockPaymentService;
            default: throw new IllegalArgumentException("Unsupported payment method");
        }
    }
}