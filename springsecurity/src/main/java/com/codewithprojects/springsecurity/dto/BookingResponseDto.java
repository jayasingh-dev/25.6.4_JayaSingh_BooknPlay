package com.codewithprojects.springsecurity.dto;

import com.codewithprojects.springsecurity.entities.Booking;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingResponseDto {
    private Long id;
    private Long slotId;
    private String userEmail;

    public static BookingResponseDto fromEntity(Booking booking) {
        return BookingResponseDto.builder()
                .id(booking.getId())
                .slotId(booking.getSlot().getId())
                .userEmail(booking.getUser().getEmail())
                .build();
    }
}
