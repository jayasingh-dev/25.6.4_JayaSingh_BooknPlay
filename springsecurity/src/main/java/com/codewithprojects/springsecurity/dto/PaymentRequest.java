package com.codewithprojects.springsecurity.dto;

import com.codewithprojects.springsecurity.entities.PaymentMethod;
import lombok.*;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequest {
    private PaymentMethod method;
    private String orderId;
    private double amount;
    private String currency;
    private Map<String, String> paymentDetails;
}

