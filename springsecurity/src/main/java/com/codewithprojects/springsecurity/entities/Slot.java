package com.codewithprojects.springsecurity.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @NotNull(message = "Turf is required")
    private Turf turf;

    @Column(nullable = false)
    @NotNull(message = "Start time is required")
    private LocalDateTime startTime;

    @Column(nullable = false)
    @NotNull(message = "End time is required")
    private LocalDateTime endTime;
}
