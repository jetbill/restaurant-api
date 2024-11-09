package com.application.jetbill.restaurant_reservations.repositories;

import com.application.jetbill.restaurant_reservations.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findById(Long id);

    Optional<Reservation> findByLocator(String locator);

    @Modifying
    @Transactional
    Optional<Reservation> deleteByLocator(String locator);

    Optional<Reservation> findByTurnAndRestaurantId(String turn, Long restaurantId);
}
