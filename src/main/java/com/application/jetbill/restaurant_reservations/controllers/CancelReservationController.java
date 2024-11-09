package com.application.jetbill.restaurant_reservations.controllers;


import com.application.jetbill.restaurant_reservations.exceptions.BookingException;
import com.application.jetbill.restaurant_reservations.responses.BookingResponse;
import com.application.jetbill.restaurant_reservations.services.CancelReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking-restaurant")
@RequiredArgsConstructor
public class CancelReservationController {

    private final CancelReservationService cancelReservationService;

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deleteReservation")
    public BookingResponse<String> deleteReservation(@RequestParam String locator) throws BookingException {
        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                cancelReservationService.deleteReservation(locator));
    }


}
