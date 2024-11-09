package com.application.jetbill.restaurant_reservations.services.impl;

import com.application.jetbill.restaurant_reservations.entities.Reservation;
import com.application.jetbill.restaurant_reservations.entities.Restaurant;
import com.application.jetbill.restaurant_reservations.entities.Turn;
import com.application.jetbill.restaurant_reservations.exceptions.BookingException;
import com.application.jetbill.restaurant_reservations.exceptions.InternalServerErrorException;
import com.application.jetbill.restaurant_reservations.exceptions.NotFountException;
import com.application.jetbill.restaurant_reservations.jsons.CreateReservationRest;
import com.application.jetbill.restaurant_reservations.jsons.ReservationRest;
import com.application.jetbill.restaurant_reservations.repositories.ReservationRepository;
import com.application.jetbill.restaurant_reservations.repositories.RestaurantRepository;
import com.application.jetbill.restaurant_reservations.repositories.TurnRepository;
import com.application.jetbill.restaurant_reservations.services.ReservationService;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor

public class ReservationServiceImpl implements ReservationService {

    private static final Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);
    private final RestaurantRepository restaurantRepository;

    private final TurnRepository turnRepository;

    private final ReservationRepository reservationRepository;

    private  final ModelMapper modelMapper;

    @Override
    public ReservationRest getReservation(Long reservationId) throws BookingException {
        return modelMapper.map(getReservationEntity(reservationId), ReservationRest.class);
    }

    @Override
    public String createReservation(CreateReservationRest createReservationRest) throws BookingException {
        final Restaurant restaurantId = restaurantRepository.findById(createReservationRest.getRestaurantId())
                .orElseThrow(() -> new NotFountException("RESTAURANT_NOT_FOUND", "RESTAURANT_NOT_FOUND"));

        final Turn turn = turnRepository.findById(createReservationRest.getTurnId())
                .orElseThrow(() -> new NotFountException("TURN_NOT_FOUND", "TURN_NOT_FOUND"));

        if (reservationRepository.findByTurnAndRestaurantId(turn.getName(), restaurantId.getId()).isPresent()) {
            throw new NotFountException("RESERVATION_ALREADT_EXIST", "RESERVATION_ALREADT_EXIST");
        }

        String locator = generateLocator(restaurantId, createReservationRest);

        final Reservation reservation = new Reservation();
        reservation.setLocator(locator);
        reservation.setPerson(createReservationRest.getPerson());
        //reservation.setDate(createReservationRest.getDate());
        reservation.setRestaurant(restaurantId);
        reservation.setTurn(turn.getName());

        try {
            reservationRepository.save(reservation);
        } catch (final Exception e) {
           logger.error("INTERNAL_SERVER_ERROR", e);
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }
        return locator;
    }

    private String generateLocator(final Restaurant restaurantId, final CreateReservationRest createReservationRest)
            throws BookingException {
        return restaurantId.getName() + createReservationRest.getTurnId();
    }

    private Reservation getReservationEntity(Long reservationId) throws BookingException {
        return reservationRepository.findById(reservationId)
                .orElseThrow(() -> new NotFountException("SNOT-404-1", "RESERVATION_NOT_FOUND"));
    }
}
