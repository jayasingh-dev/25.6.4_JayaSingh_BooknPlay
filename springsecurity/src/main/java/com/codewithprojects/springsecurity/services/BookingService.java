package com.codewithprojects.springsecurity.services;

import com.codewithprojects.springsecurity.dto.BookingRequestDto;
import com.codewithprojects.springsecurity.dto.BookingResponseDto;
import com.codewithprojects.springsecurity.entities.Booking;
import com.codewithprojects.springsecurity.entities.Slot;
import com.codewithprojects.springsecurity.entities.User;
import com.codewithprojects.springsecurity.exception.BookingException;
import com.codewithprojects.springsecurity.repository.BookingRepository;
import com.codewithprojects.springsecurity.repository.SlotRepository;
import com.codewithprojects.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {

    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);
    private final BookingRepository bookingRepository;
    private final SlotRepository slotRepository;
    private final UserRepository userRepository;

    public BookingResponseDto bookSlot(BookingRequestDto request, String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new BookingException("User not found"));
        Slot slot = slotRepository.findById(request.getSlotId())
                .orElseThrow(() -> new BookingException("Slot not found"));
        if (bookingRepository.existsBySlot(slot)) {
            throw new BookingException("Slot already booked");
        }
        Booking booking = Booking.builder()
                .user(user)
                .slot(slot)
                .build();
        bookingRepository.save(booking);
        logger.info("Slot booked: slotId={}, user={}", slot.getId(), user.getEmail());
        return BookingResponseDto.fromEntity(booking);
    }

    public List<BookingResponseDto> getBookingsForUser(String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new BookingException("User not found"));
        return bookingRepository.findByUser(user).stream()
                .map(BookingResponseDto::fromEntity)
                .collect(Collectors.toList());
    }
}

