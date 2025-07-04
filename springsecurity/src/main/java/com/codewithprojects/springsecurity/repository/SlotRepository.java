package com.codewithprojects.springsecurity.repository;

import com.codewithprojects.springsecurity.entities.Slot;
import com.codewithprojects.springsecurity.entities.Turf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Long> {
    List<Slot> findByTurf(Turf turf);
}

