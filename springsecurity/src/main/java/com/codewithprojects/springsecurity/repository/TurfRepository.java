package com.codewithprojects.springsecurity.repository;

import com.codewithprojects.springsecurity.entities.Turf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurfRepository extends JpaRepository<Turf, Long> {
    // Add custom queries if needed
}
