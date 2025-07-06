package com.codewithprojects.springsecurity.services;

import com.codewithprojects.springsecurity.entities.Booking;
import com.codewithprojects.springsecurity.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingReminderScheduler {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private NotificationService notificationService;

    // Runs every hour (customize as needed)
    @Scheduled(cron = "0 0 * * * *")
    public void sendReminders() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime reminderTime = now.plusHours(1); // Remind 1 hour before

        List<Booking> upcomingBookings = bookingRepository.findBySlot_StartTimeBetween(now, reminderTime);

        for (Booking booking : upcomingBookings) {
            notificationService.sendBookingReminder(
                    booking.getUser().getEmail(),
                    "Reminder: Your booking for slot " + booking.getSlot().getId() +
                            " is at " + booking.getSlot().getStartTime()
            );
        }
    }
}