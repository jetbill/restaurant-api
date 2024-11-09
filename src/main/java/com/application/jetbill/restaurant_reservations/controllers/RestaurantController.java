package com.application.jetbill.restaurant_reservations.controllers;

import java.util.List;


import com.application.jetbill.restaurant_reservations.exceptions.BookingException;
import com.application.jetbill.restaurant_reservations.jsons.RestaurantRest;
import com.application.jetbill.restaurant_reservations.responses.BookingResponse;
import com.application.jetbill.restaurant_reservations.services.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking-restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/restaurant/{restaurantId}")
    public BookingResponse<RestaurantRest> getRestaurantById(@PathVariable Long restaurantId) throws BookingException {
        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                restaurantService.getRestaurantById(restaurantId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public BookingResponse<List<RestaurantRest>> getRestaurants() throws BookingException {
        return new BookingResponse<>("Success",
                String.valueOf(HttpStatus.OK), "OK", restaurantService.getRestaurants());
    }
}
