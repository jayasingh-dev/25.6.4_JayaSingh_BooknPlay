package com.codewithprojects.springsecurity.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Turf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Turf name is required")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Location is required")
    private String location;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @NotNull(message = "Owner is required")
    private User owner;

    @ElementCollection
    @NotNull(message = "Sports supported list is required")
    private List<String> sportsSupported;

    @Column(nullable = false)
    @NotNull(message = "Price per hour is required")
    private Double pricePerHour;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Turf status is required")
    private TurfStatus status;
}
