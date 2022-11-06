package com.capstone.gbuma.service;

import com.capstone.gbuma.entity.Customer;
import com.capstone.gbuma.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Optional<Customer> getCustomerById(String customerId) {
        return customerRepo.findById(customerId);
    }
}
