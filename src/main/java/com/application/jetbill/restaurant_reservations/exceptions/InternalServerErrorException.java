package com.application.jetbill.restaurant_reservations.exceptions;

import com.application.jetbill.restaurant_reservations.dtos.ErrorDto;
import org.springframework.http.HttpStatus;

import java.util.Collections;

public class InternalServerErrorException extends BookingException{
    public InternalServerErrorException(String code, String message) {
        super(code,HttpStatus.INTERNAL_SERVER_ERROR.value(),message);
    }

    public InternalServerErrorException(String code, String message, ErrorDto data) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(),message, Collections.singletonList(data));
    }
}
