package com.codewithprojects.springsecurity.entities;

import com.codewithprojects.springsecurity.entities.TurfStatus;
import jakarta.persistence.*;
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
    private String name;

    @Column(nullable = false)
    private String location;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;

    @ElementCollection
    private List<String> sportsSupported; //new table created
    @Column(nullable = false)
    private Double pricePerHour;

    @ElementCollection
    private List<String> availableSlots; // e.g., ["08:00-09:00", "09:00-10:00"] //new table created

    @Enumerated(EnumType.STRING)
    private TurfStatus status;
}
