package com.capstone.gbuma.service;


import com.capstone.gbuma.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private CustomerService customerService;
    @Override
    public UserDetails loadUserByUsername(String customerId) throws UsernameNotFoundException {
        Optional<Customer> userOptional =  customerService.getCustomerById(customerId.trim());
        if (userOptional.isPresent() && userOptional.get().getCustomerId().equals(customerId)) {
            return new User(userOptional.get().getCustomerId(),userOptional.get().getPassword(), new ArrayList<>());
        }
        else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}