package com.application.jetbill.restaurant_reservations.jsons;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class CreateReservationRest {

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("person")
    private Long person;

    @JsonProperty("turnId")
    private Long turnId;

    @JsonProperty("restaurantId")
    private Long restaurantId;
}
