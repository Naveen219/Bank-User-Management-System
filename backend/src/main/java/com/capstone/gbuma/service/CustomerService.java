package com.capstone.gbuma.service;

import com.capstone.gbuma.entity.Customer;

import java.util.Optional;

public interface CustomerService {
    public Customer saveCustomer(Customer customer);
    public Optional<Customer> getCustomerById(String customerId);

}
