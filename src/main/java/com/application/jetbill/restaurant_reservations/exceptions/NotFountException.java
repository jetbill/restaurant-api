package com.application.jetbill.restaurant_reservations.exceptions;

import com.application.jetbill.restaurant_reservations.dtos.ErrorDto;
import org.springframework.http.HttpStatus;

import java.util.Collections;

public class NotFountException extends BookingException{

    public NotFountException(String code, String message) {
        super(code, HttpStatus.NOT_FOUND.value(),message);
    }

    public NotFountException(String code, String message, ErrorDto data) {
        super(code,HttpStatus.NOT_FOUND.value(),message, Collections.singletonList(data));
    }
}
