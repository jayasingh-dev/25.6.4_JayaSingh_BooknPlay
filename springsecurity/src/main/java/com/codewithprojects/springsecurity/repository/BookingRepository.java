package com.codewithprojects.springsecurity.repository;

import com.codewithprojects.springsecurity.entities.Booking;
import com.codewithprojects.springsecurity.entities.Slot;
import com.codewithprojects.springsecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    boolean existsBySlot(Slot slot);
    List<Booking> findByUser(User user);
}

