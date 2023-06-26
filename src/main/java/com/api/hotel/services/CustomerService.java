package com.api.hotel.services;

import com.api.hotel.model.dto.CreateCustomerDTO;
import com.api.hotel.model.entities.Customer;
import com.api.hotel.repositories.AddressRepository;
import com.api.hotel.repositories.CustomerRepository;
import com.api.hotel.security.exception.APIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    public Customer registerCustomer(CreateCustomerDTO dto) {
        Customer customer = new Customer(dto);
        addressRepository.save(customer.getAddress());
        customerRepository.save(customer);
        return customer;
    }

    public Boolean payment(Long id) {
        Customer customer = verifyIfExists(id);
        customer.pay();
        customerRepository.save(customer);
        return true;
    }

    private Customer verifyIfExists(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isEmpty()) {
            throw new APIException("This customer does not exist in our database.");
        }

        return customer.get();
    }

    public Customer registerCheckout(Long id) {
        Customer customer = verifyIfExists(id);

        if (customer.getCheckOutDate() != null) {
            throw new APIException("This customer already left the hotel on: " + customer.getCheckOutDate());
        }

        customer.setCheckOutDate(LocalDateTime.now());
        customerRepository.save(customer);
        return customer;
    }
}
