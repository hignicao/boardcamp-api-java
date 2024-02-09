package com.boardcamp.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDTO {

    @NotBlank(message = "Name is required")
    private String name;

    private String image;

    @NotNull(message = "Price per day is required")
    @Positive(message = "Stock total must be greater than zero")
    private int stockTotal;

    @NotNull(message = "Price per day is required")
    @Positive(message = "Price per day must be greater than zero")
    private int pricePerDay;
}
