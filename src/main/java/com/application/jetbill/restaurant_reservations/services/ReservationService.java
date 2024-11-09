package com.application.jetbill.restaurant_reservations.services;

import com.application.jetbill.restaurant_reservations.exceptions.BookingException;
import com.application.jetbill.restaurant_reservations.jsons.CreateReservationRest;
import com.application.jetbill.restaurant_reservations.jsons.ReservationRest;

public interface ReservationService {

    ReservationRest getReservation(Long reservationId) throws BookingException;

    String createReservation(CreateReservationRest createReservationRest) throws BookingException;
}
