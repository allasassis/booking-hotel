package com.api.hotel.model.entities;

import com.api.hotel.model.dto.CreateHotel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "hotels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cnpj;
    private String phone;

    @OneToOne
    private Address address;

    private String website;
    private String email;

    @Max(5)
    @Min(0)
    private Integer rating;

    public Hotel(CreateHotel createHotel) {
        this.name = createHotel.name();
        this.cnpj = createHotel.cnpj();
        this.phone = createHotel.phone();
        this.website = createHotel.website();
        this.email = createHotel.email();
        this.address = new Address(createHotel.address());

    }
}
