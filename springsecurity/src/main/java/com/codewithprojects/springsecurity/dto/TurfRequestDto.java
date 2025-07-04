package com.codewithprojects.springsecurity.dto;
import com.codewithprojects.springsecurity.entities.TurfStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TurfRequestDto {
    @NotBlank(message = "Turf name is required")
    private String name;
    @NotBlank(message = "Location is required")
    private String location;
    private List<String> sportsSupported;
    private Double pricePerHour;
    private TurfStatus status;

}

