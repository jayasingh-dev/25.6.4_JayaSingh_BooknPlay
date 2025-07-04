package com.codewithprojects.springsecurity.dto;

import com.codewithprojects.springsecurity.entities.Slot;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class SlotResponseDto {
    private Long id;
    private Long turfId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public static SlotResponseDto fromEntity(Slot slot) {
        return SlotResponseDto.builder()
                .id(slot.getId())
                .turfId(slot.getTurf().getId())
                .startTime(slot.getStartTime())
                .endTime(slot.getEndTime())
                .build();
    }
}

