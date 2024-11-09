package com.application.jetbill.restaurant_reservations.services;

import com.application.jetbill.restaurant_reservations.exceptions.BookingException;

public interface CancelReservationService {
    public String deleteReservation(String locator) throws BookingException;
}
