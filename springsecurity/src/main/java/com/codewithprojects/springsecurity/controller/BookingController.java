package com.codewithprojects.springsecurity.controller;

import com.codewithprojects.springsecurity.dto.BookingRequestDto;
import com.codewithprojects.springsecurity.dto.BookingResponseDto;
import com.codewithprojects.springsecurity.dto.PaymentRequest;
import com.codewithprojects.springsecurity.services.BookingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/with-payment")
    public ResponseEntity<BookingResponseDto> bookSlotWithPayment(
            @Valid @RequestBody BookingWithPaymentRequestDto request,
            Authentication authentication) {
        String username = authentication.getName();
        BookingResponseDto responseDTO = bookingService.bookSlotWithPayment(
                request.getBookingRequest(), request.getPaymentRequest(), username);
        return ResponseEntity.ok(responseDTO);
    }

//    @PreAuthorize("hasRole('USER')")
//    @PostMapping
//    public ResponseEntity<BookingResponseDto> bookSlot(@Valid @RequestBody BookingRequestDto bookingRequestDto, Authentication authentication) {
//        String username = authentication.getName();
//        BookingResponseDto responseDTO = bookingService.bookSlot(bookingRequestDto, username);
//        return ResponseEntity.ok(responseDTO);
//    }


    @PreAuthorize("hasRole('USER')")
    @GetMapping("/my")
    public ResponseEntity<List<BookingResponseDto>> getMyBookings(@Valid Authentication authentication) {
        String username = authentication.getName();
        return ResponseEntity.ok(bookingService.getBookingsForUser(username));
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BookingWithPaymentRequestDto {
        private BookingRequestDto bookingRequest;
        private PaymentRequest paymentRequest;
    }
}
