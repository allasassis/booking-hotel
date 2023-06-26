package com.api.hotel.model.entities;

import com.api.hotel.model.dto.CreateCustomerDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @Enumerated(EnumType.STRING)
    private PaymentInfo paymentInfo;

    private Double bill;

    @OneToOne
    private Address address;

    public Customer(CreateCustomerDTO dto) {
        this.firstName = dto.firstName();
        this.lastName = dto.lastName();
        this.email = dto.email();
        this.phoneNumber = dto.phoneNumber();
        this.checkInDate = dto.checkInDate();
        this.roomType = dto.roomType();
        this.paymentInfo = PaymentInfo.NOT_PAID;
        this.address = new Address(dto.address());
    }

    public void pay() {
        this.paymentInfo = PaymentInfo.PAID;
    }

    public void setCheckOutDate(LocalDateTime checkOutDate) {
        this.checkOutDate = checkOutDate;
        long between = ChronoUnit.DAYS.between(this.checkInDate, this.checkOutDate);
        System.out.println(between);
        // Calculating customer's bill
        this.bill = (double) (between * 30);
    }
}
