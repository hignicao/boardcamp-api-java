package com.boardcamp.api.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalDTO {

    @NotNull(message = "Customer ID is required")
    private Long customerId;

    @NotNull(message = "Game ID is required")
    private Long gameId;

    @NotNull(message = "Days rented is required")
    @Positive(message = "Days rented must be greater than zero")
    private int daysRented;
}
