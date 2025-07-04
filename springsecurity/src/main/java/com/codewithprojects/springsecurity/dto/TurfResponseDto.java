package com.codewithprojects.springsecurity.dto;
import com.codewithprojects.springsecurity.entities.Turf;
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
    private TurfStatus status;
    private String ownerEmail;

    public static TurfResponseDto fromEntity(Turf turf) {
        return TurfResponseDto.builder()
                .id(turf.getId())
                .name(turf.getName())
                .location(turf.getLocation())
                .sportsSupported(turf.getSportsSupported())
                .pricePerHour(turf.getPricePerHour())
                .status(turf.getStatus())
                .ownerEmail(turf.getOwner().getEmail())
                .build();
    }
}

