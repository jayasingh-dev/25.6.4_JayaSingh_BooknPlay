package com.codewithprojects.springsecurity.repository;

import com.codewithprojects.springsecurity.entities.Turf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TurfRepository extends JpaRepository<Turf, Long> {
    List<Turf> findByOwnerEmail(String ownerEmail);
    // Add custom queries if needed
}
