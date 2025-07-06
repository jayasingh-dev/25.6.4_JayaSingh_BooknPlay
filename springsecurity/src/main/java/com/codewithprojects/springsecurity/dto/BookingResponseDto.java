package com.codewithprojects.springsecurity.dto;

import com.codewithprojects.springsecurity.entities.Booking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponseDto {
    private Long id;
    private Long slotId;
    private String userEmail;

    private String status;
    private String paymentTransactionId;
    private String paymentMessage;

    public static BookingResponseDto fromEntity(Booking booking, String paymentTransactionId, String paymentMessage) {
        return BookingResponseDto.builder()
                .id(booking.getId())
                .slotId(booking.getSlot().getId())
                .userEmail(booking.getUser().getEmail())
                .status(booking.getStatus().name())
                .paymentTransactionId(paymentTransactionId)
                .paymentMessage(paymentMessage)
                .build();
    }
}

//    public static BookingResponseDto fromEntity(Booking booking) {
//        return BookingResponseDto.builder()
//                .id(booking.getId())
//                .slotId(booking.getSlot().getId())
//                .userEmail(booking.getUser().getEmail())
//                .build();
//    }

