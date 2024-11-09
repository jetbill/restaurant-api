package com.application.jetbill.restaurant_reservations.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class BookingResponse<T> implements Serializable {

    private String status;
    private String code;
    private String message;
    private T data;

    public BookingResponse(String status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
