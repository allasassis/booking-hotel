package com.api.hotel.model.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public record CreateHotel(@NotBlank String name, @NotBlank String cnpj, @NotBlank String phone, @Valid @NotBlank CreateAddress address,
                          @NotBlank String website, @NotBlank String email) {
}
