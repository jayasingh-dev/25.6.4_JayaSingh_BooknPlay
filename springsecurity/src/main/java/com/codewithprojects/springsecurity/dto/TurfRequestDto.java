package com.codewithprojects.springsecurity.dto;
import com.codewithprojects.springsecurity.entities.TurfStatus;
import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TurfRequestDto {
    private String name;
    private String location;
    private List<String> sportsSupported;
    private Double pricePerHour;
    private List<String> availableSlots;
    private TurfStatus status;

}

