package com.codewithprojects.springsecurity.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SlotRequestDto {
    private Long turfId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}

