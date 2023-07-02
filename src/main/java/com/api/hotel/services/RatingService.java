package com.api.hotel.services;

import com.api.hotel.model.entities.Customer;
import com.api.hotel.model.entities.Hotel;
import com.api.hotel.model.entities.Rating;
import com.api.hotel.repositories.CustomerRepository;
import com.api.hotel.repositories.HotelRepository;
import com.api.hotel.repositories.RatingRepository;
import com.api.hotel.security.exception.APIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public void vote(Long hotelId, Long customerId, Integer ratingValue) {
        Hotel hotel = verifyIfHotelExists(hotelId);
        Customer customer = verifyIfCustomerExists(customerId);

        List<Rating> ratings = ratingRepository.findByHotelId(hotel.getId());
        for (Rating rating: ratings) {
            if (rating.getCustomer().getId() == customerId) {
                throw new APIException("This customer already voted.");
            }
        }

        Rating rating = new Rating(ratingValue, customer, hotel);
        ratings.add(rating);
        ratingRepository.save(rating);
    }

    public Double reviewRating(Long hotelId) {
        Hotel hotel = verifyIfHotelExists(hotelId);

        List<Rating> ratings = ratingRepository.findByHotelId(hotel.getId());

        if (ratings.isEmpty()) {
            throw new APIException("This hotel has no ratings yet.");
        }

        double ratingSize = ratings.size();
        double totalVoteValue = ratings.stream().mapToInt(Rating::getRatingValue).sum();
        return (totalVoteValue / ratingSize);
    }

    private Hotel verifyIfHotelExists(Long id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        if (hotel.isEmpty()) {
            throw new APIException("There's no hotel with this id!");
        }

        return hotel.get();
    }

    private Customer verifyIfCustomerExists(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new APIException("There's no customer with this id!");
        }

        return customer.get();
    }


}

