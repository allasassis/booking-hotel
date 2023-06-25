package com.api.hotel.controllers;

import com.api.hotel.model.dto.HotelDTO;
import com.api.hotel.model.entities.Hotel;
import com.api.hotel.model.dto.CreateHotel;
import com.api.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping()
    public ResponseEntity<List<Hotel>> listHotels() {
        return ResponseEntity.ok().body(hotelService.listHotels());
    }

    @PostMapping
    public ResponseEntity<HotelDTO> registerHotel(@RequestBody CreateHotel createHotel) {
        return ResponseEntity.status(201).body(hotelService.registerHotel(createHotel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }
}
