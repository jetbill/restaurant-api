package com.application.jetbill.restaurant_reservations.controllers;


import com.application.jetbill.restaurant_reservations.exceptions.BookingException;
import com.application.jetbill.restaurant_reservations.jsons.CreateReservationRest;
import com.application.jetbill.restaurant_reservations.jsons.ReservationRest;
import com.application.jetbill.restaurant_reservations.responses.BookingResponse;
import com.application.jetbill.restaurant_reservations.services.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking-restaurant")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/reservation/{reservationId}")
    public BookingResponse<ReservationRest> getReservationById(@PathVariable Long reservationId) throws BookingException {
        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                reservationService.getReservation(reservationId));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/reservation")
    public BookingResponse<String> createReservation(@RequestBody @Valid CreateReservationRest createReservationRest)
            throws BookingException {
        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                reservationService.createReservation(createReservationRest));
    }


}
