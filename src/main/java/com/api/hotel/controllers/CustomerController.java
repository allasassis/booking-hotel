package com.api.hotel.controllers;

import com.api.hotel.model.dto.CreateCustomerDTO;
import com.api.hotel.model.entities.Customer;
import com.api.hotel.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> registerCustomer(@RequestBody CreateCustomerDTO dto) {
        return ResponseEntity.status(201).body(customerService.registerCustomer(dto));
    }

    @PutMapping("/payment/{id}")
    public ResponseEntity<Boolean> payment(@PathVariable Long id) {
        return ResponseEntity.ok().body(customerService.payment(id));
    }

    @PutMapping("/checkout/{id}")
    public ResponseEntity<Customer> registerCheckout(@PathVariable Long id) {
        return ResponseEntity.ok().body(customerService.registerCheckout(id));
    }

}
