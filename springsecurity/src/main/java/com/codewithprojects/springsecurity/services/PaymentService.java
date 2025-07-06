package com.codewithprojects.springsecurity.services;

import com.codewithprojects.springsecurity.dto.PaymentRequest;
import com.codewithprojects.springsecurity.dto.PaymentResponse;

public interface PaymentService {
    PaymentResponse processPayment(PaymentRequest request);
}