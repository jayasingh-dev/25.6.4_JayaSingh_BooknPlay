package com.codewithprojects.springsecurity.dto;
import com.codewithprojects.springsecurity.entities.TurfStatus;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TurfResponseDto {
    private Long id;
    private String name;
    private String location;
    private List<String> sportsSupported;
    private Double pricePerHour;
    private List<String> availableSlots;
    private TurfStatus status;
    private Long ownerId; // Or ownerId if you prefer

}
