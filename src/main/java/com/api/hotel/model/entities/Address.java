package com.api.hotel.model.entities;

import com.api.hotel.model.dto.CreateAddress;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String number;
    private String neighbourhood;
    private String city;
    private String state;
    private String country;

    public Address(CreateAddress address) {
        this.street = address.street();
        this.number = address.number();
        this.neighbourhood = address.neighbourhood();
        this.city = address.city();
        this.state = address.state();
        this.country = address.country();
    }
}
