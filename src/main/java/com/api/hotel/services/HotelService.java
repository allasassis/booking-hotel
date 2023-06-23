package com.api.hotel.services;

import com.api.hotel.model.entities.Hotel;
import com.api.hotel.model.dto.CreateHotel;
import com.api.hotel.repositories.AddressRepository;
import com.api.hotel.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private AddressRepository addressRepository;

    public List<Hotel> listHotels() {
        return hotelRepository.findAll();
    }

    public Hotel registerHotel(CreateHotel createHotel) {
        Hotel hotel = new Hotel(createHotel);
        hotel.setRating(0);
        addressRepository.save(hotel.getAddress());
        hotelRepository.save(hotel);
        return hotel;
    }
}
