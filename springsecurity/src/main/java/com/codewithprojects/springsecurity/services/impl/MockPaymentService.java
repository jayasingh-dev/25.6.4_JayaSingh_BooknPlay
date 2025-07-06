package com.codewithprojects.springsecurity.services.impl;

import com.codewithprojects.springsecurity.dto.PaymentRequest;
import com.codewithprojects.springsecurity.dto.PaymentResponse;
import com.codewithprojects.springsecurity.services.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class MockPaymentService implements PaymentService {
    @Override
    public PaymentResponse processPayment(PaymentRequest request) {
        return PaymentResponse.builder()
                .success(true)
                .transactionId("mock_txn_" + System.currentTimeMillis())
                .message("Mock payment successful")
                .build();
    }
}

