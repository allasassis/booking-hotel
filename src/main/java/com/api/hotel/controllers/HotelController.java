package com.api.hotel.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @GetMapping("/isitworking")
    public ResponseEntity<String> itsWorking() {
        return ResponseEntity.ok().body("It's working!");
    }
}
