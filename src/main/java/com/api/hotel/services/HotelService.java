package com.api.hotel.services;

import com.api.hotel.model.dto.HotelDTO;
import com.api.hotel.model.entities.Hotel;
import com.api.hotel.model.dto.CreateHotel;
import com.api.hotel.repositories.AddressRepository;
import com.api.hotel.repositories.HotelRepository;
import com.api.hotel.security.exception.APIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private AddressRepository addressRepository;

    public List<Hotel> listHotels() {
        return hotelRepository.findAll();
    }

    public HotelDTO registerHotel(CreateHotel createHotel) {
        Hotel hotel = new Hotel(createHotel);
        hotel.setRating(0);
        addressRepository.save(hotel.getAddress());
        hotelRepository.save(hotel);
        return new HotelDTO(hotel);
    }

    public void deleteHotel(Long id) {
        Hotel hotel = verifyIfExists(id);
        hotelRepository.deleteById(id);
        addressRepository.deleteById(hotel.getAddress().getId());
    }

    private Hotel verifyIfExists(Long id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        if (hotel.isEmpty()) {
            throw new APIException("This hotel does not exist in our database!");
        }
        return hotel.get();
    }
}
