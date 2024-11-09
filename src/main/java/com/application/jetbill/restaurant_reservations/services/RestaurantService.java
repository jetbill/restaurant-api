package com.application.jetbill.restaurant_reservations.services;

import com.application.jetbill.restaurant_reservations.exceptions.BookingException;
import com.application.jetbill.restaurant_reservations.jsons.RestaurantRest;

import java.util.List;

public interface RestaurantService {
    RestaurantRest getRestaurantById(Long restaurantId) throws BookingException;

    public List<RestaurantRest> getRestaurants() throws BookingException;
}
