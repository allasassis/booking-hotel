package com.api.hotel.model.dto;

import com.api.hotel.model.entities.Hotel;

public record HotelDTO(String name, String cnpj, String phone, AddressDTO address, String website, String email) {
    public HotelDTO(Hotel hotel) {
        this(hotel.getName(), hotel.getCnpj(), hotel.getPhone(), new AddressDTO(hotel.getAddress()), hotel.getWebsite(), hotel.getEmail());
    }
}
