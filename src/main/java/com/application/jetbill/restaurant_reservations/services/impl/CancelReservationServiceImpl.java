package com.application.jetbill.restaurant_reservations.services.impl;
import com.application.jetbill.restaurant_reservations.exceptions.BookingException;
import com.application.jetbill.restaurant_reservations.exceptions.InternalServerErrorException;
import com.application.jetbill.restaurant_reservations.exceptions.NotFountException;
import com.application.jetbill.restaurant_reservations.repositories.ReservationRepository;
import com.application.jetbill.restaurant_reservations.services.CancelReservationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CancelReservationServiceImpl implements CancelReservationService {
    private static final Logger logger = LoggerFactory.getLogger(CancelReservationServiceImpl.class);

    private final ReservationRepository reservationRepository;

    @Override
    public String deleteReservation(String locator) throws BookingException {
        reservationRepository.findByLocator(locator)
                .orElseThrow(() -> new NotFountException("LOCATOR_NOT_FOUND", "LOCATOR_NOT_FOUND"));

        try {
            reservationRepository.deleteByLocator(locator);
        } catch (Exception e) {
            logger.error("INTERNAL_SERVER_ERROR", e);
            throw new InternalServerErrorException("400", "INTERNAL_SERVER_ERROR");
        }

        return "LOCATOR_DELETED";
     }

}
