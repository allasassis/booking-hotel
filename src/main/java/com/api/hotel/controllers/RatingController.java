package com.api.hotel.controllers;

import com.api.hotel.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/rate/{customerId}/{hotelId}")
    public ResponseEntity rateTheHotel(@PathVariable Long customerId, @PathVariable Long hotelId, @RequestParam @NotNull @Max(5) @Min(0) Integer note) {
        ratingService.vote(hotelId, customerId, note);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Double> reviewRate(@PathVariable Long hotelId) {
        return ResponseEntity.ok().body(ratingService.reviewRating(hotelId));
    }
}
