package com.application.jetbill.restaurant_reservations.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ErrorDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String name;

    private String value;
}
