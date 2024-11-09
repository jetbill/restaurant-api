package com.application.jetbill.restaurant_reservations.services.impl;

import com.application.jetbill.restaurant_reservations.entities.Restaurant;
import com.application.jetbill.restaurant_reservations.exceptions.BookingException;
import com.application.jetbill.restaurant_reservations.exceptions.NotFountException;
import com.application.jetbill.restaurant_reservations.jsons.RestaurantRest;
import com.application.jetbill.restaurant_reservations.repositories.RestaurantRepository;
import com.application.jetbill.restaurant_reservations.services.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private  final ModelMapper modelMapper;
    @Override
    public RestaurantRest getRestaurantById(Long restaurantId) throws BookingException {
        return modelMapper.map(getRestaurantEntity(restaurantId), RestaurantRest.class);
    }

    @Override
    public List<RestaurantRest> getRestaurants() throws BookingException {
        final List<Restaurant> restaurantsEntity = restaurantRepository.findAll();
        return restaurantsEntity.stream()
                .map(restaurants -> modelMapper.map(restaurants, RestaurantRest.class))
                .toList();
    }

    private Restaurant getRestaurantEntity(Long restaurantId) throws BookingException {
        return restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NotFountException("SNOT-404-1", "RESTAURANT_NOT_FOUND"));
    }
}
