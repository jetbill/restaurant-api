package com.application.jetbill.restaurant_reservations.repositories;

import com.application.jetbill.restaurant_reservations.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findById(Long id);

    Optional<Restaurant> findByName(String nameRestaurant);

    @Query(value = "SELECT rest FROM restaurant rest", nativeQuery = true)
    public List<Restaurant> findRestaurants();
}
