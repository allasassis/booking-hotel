package com.api.hotel.model.dto;

import com.api.hotel.model.entities.Address;

public record AddressDTO(String street, String number, String neighbourhood, String city, String state, String country) {
    public AddressDTO(Address address) {
        this(address.getStreet(), address.getNumber(), address.getNeighbourhood(), address.getCity(), address.getState(), address.getCountry());
    }
}
