package com.api.hotel.model.dto;

import com.api.hotel.model.entities.PaymentInfo;
import com.api.hotel.model.entities.RoomType;

import java.time.LocalDateTime;
import java.util.Date;

public record CreateCustomerDTO(String firstName, String lastName, String email, String phoneNumber, LocalDateTime checkInDate,
                                RoomType roomType, CreateAddress address
) {
}
