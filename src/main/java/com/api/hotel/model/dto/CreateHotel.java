package com.api.hotel.model.dto;

public record CreateHotel(String name, String cnpj, String phone, CreateAddress address, String website, String email) {
}
