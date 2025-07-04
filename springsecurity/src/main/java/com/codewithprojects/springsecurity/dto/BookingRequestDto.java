package com.codewithprojects.springsecurity.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookingRequestDto {
    @NotNull(message = "Slot ID is required")
    private Long slotId;
}
