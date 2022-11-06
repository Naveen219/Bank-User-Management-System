package com.capstone.gbuma.restcontroller;

import com.capstone.gbuma.entity.Customer;
import com.capstone.gbuma.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {


    @Autowired
    CustomerService customerService;

    @PostMapping("/login")
    public void home() {

    }
    @PostMapping("/register")
    public ResponseEntity<Customer> register(@RequestBody Customer customer) {
        Customer tempCustomer = customerService.saveCustomer(customer);
        System.out.println("hello");
        return  ResponseEntity.ok(customer);
    }
}
