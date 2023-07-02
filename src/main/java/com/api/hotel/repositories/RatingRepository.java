package com.api.hotel.repositories;

import com.api.hotel.model.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByHotelId(Long hotelId);
}
