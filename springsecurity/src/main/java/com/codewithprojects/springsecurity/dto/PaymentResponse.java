package com.codewithprojects.springsecurity.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponse {
    private boolean success;
    private String transactionId;
    private String message;
}

