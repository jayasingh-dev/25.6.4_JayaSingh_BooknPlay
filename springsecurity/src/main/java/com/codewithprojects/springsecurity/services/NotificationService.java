package com.codewithprojects.springsecurity.services;

public interface NotificationService {
    void sendBookingConfirmation(String to, String bookingDetails);
    void sendBookingReminder(String to, String bookingDetails);
}