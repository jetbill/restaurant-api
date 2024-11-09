package com.application.jetbill.restaurant_reservations.jsons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationRest {

    @JsonProperty("locator")
    private String locator;

    @JsonProperty("restaurantId")
    private Long restaurantId;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("person")
    private Long person;

    @JsonProperty("turnId")
    private Long turnId;
}
