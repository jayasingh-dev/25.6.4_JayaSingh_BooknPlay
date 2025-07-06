package com.codewithprojects.springsecurity.services.impl;

import com.codewithprojects.springsecurity.services.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService {

    @Override
    public void sendBookingConfirmation(String to, String bookingDetails) {
        // Integrate with your email provider here
        System.out.println("Sending booking confirmation to " + to + ": " + bookingDetails);
    }

    @Override
    public void sendBookingReminder(String to, String bookingDetails) {
        // Integrate with your email provider here
        System.out.println("Sending booking reminder to " + to + ": " + bookingDetails);
    }
}