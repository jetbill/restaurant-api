package com.application.jetbill.restaurant_reservations.repositories;


import java.util.Optional;

import com.application.jetbill.restaurant_reservations.entities.Turn;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TurnRepository extends JpaRepository<Turn, Long> {
    Optional<Turn> findById(Long id);
}
