package com.api.hotel.model.dto;

import javax.validation.constraints.NotBlank;

public record CreateAddress(@NotBlank String street, @NotBlank String number, @NotBlank String neighbourhood, @NotBlank String city,
                            @NotBlank String state, @NotBlank String country) {
}
